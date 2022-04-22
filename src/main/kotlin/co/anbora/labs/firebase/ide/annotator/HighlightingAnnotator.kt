package co.anbora.labs.firebase.ide.annotator

import co.anbora.labs.firebase.ide.color.FirebaseColors
import co.anbora.labs.firebase.lang.core.psi.FireRulesCallExpr
import co.anbora.labs.firebase.lang.core.psi.ext.elementType
import com.intellij.lang.annotation.AnnotationHolder
import com.intellij.lang.annotation.Annotator
import com.intellij.psi.PsiElement
import com.intellij.psi.impl.source.tree.LeafPsiElement

val BUILTIN_FUNCTIONS = setOf("get", "exists")

class HighlightingAnnotator: Annotator {
    override fun annotate(element: PsiElement, holder: AnnotationHolder) {
        val color = when {
            element.parent is FireRulesCallExpr -> highlightBuiltInFunctions(element)
            element is LeafPsiElement -> highlightLeaf(element)
            else -> null
        } ?: return
        val severity = color.testSeverity
        holder.newSilentAnnotation(severity).textAttributes(color.textAttributesKey).create()
    }

    private fun highlightLeaf(element: PsiElement): FirebaseColors? {
        return if (element.elementType.toString().endsWith("_kw")) return FirebaseColors.PERMISSIONS
            else null
    }

    private fun highlightBuiltInFunctions(element: PsiElement): FirebaseColors? {
        val parent = element.parent
        return if (parent is FireRulesCallExpr) {
            /*val name = (element as? FirebaseRulesIdentifierExpr)?.text
            if (name != null) FirebaseColors.CALL_FUNCTION
                else*/ null
        } else {
            null
        }
    }
}
