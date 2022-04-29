package co.anbora.labs.firebase.ide.annotator

import co.anbora.labs.firebase.ide.color.FirebaseColors
import co.anbora.labs.firebase.lang.core.RULES_PERMISSIONS
import co.anbora.labs.firebase.lang.core.psi.FireRulesCallExpr
import co.anbora.labs.firebase.lang.core.psi.FireRulesIdentifierExpr
import co.anbora.labs.firebase.lang.core.psi.ext.elementType
import com.intellij.lang.annotation.AnnotationHolder
import com.intellij.lang.annotation.Annotator
import com.intellij.psi.PsiElement
import com.intellij.psi.impl.source.tree.LeafPsiElement

class HighlightingAnnotator: Annotator {
    override fun annotate(element: PsiElement, holder: AnnotationHolder) {
        val color = when {
            element.parent is FireRulesCallExpr -> highlightCallFunctions(element)
            element is LeafPsiElement -> highlightPermissions(element)
            else -> null
        } ?: return
        val severity = color.testSeverity
        holder.newSilentAnnotation(severity).textAttributes(color.textAttributesKey).create()
    }

    private fun highlightPermissions(element: PsiElement): FirebaseColors? {
        return if (element.elementType in RULES_PERMISSIONS) return FirebaseColors.PERMISSIONS
            else null
    }

    private fun highlightCallFunctions(element: PsiElement): FirebaseColors? {
        val parent = element.parent
        return if (parent is FireRulesCallExpr) {
            val name = (element as? FireRulesIdentifierExpr)?.text
            when (name != null) {
                true -> FirebaseColors.CALL_FUNCTION
                else -> null
            }
        } else {
            null
        }
    }
}
