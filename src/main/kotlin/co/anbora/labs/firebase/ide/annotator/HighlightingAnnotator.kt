package co.anbora.labs.firebase.ide.annotator

import co.anbora.labs.firebase.ide.color.FirebaseColors
import co.anbora.labs.firebase.lang.core.RULES_PERMISSIONS
import co.anbora.labs.firebase.lang.core.psi.FireRulesCallExpr
import co.anbora.labs.firebase.lang.core.psi.FireRulesDotExpr
import co.anbora.labs.firebase.lang.core.psi.FireRulesIdentifierExpr
import co.anbora.labs.firebase.lang.core.psi.FireRulesTypes
import co.anbora.labs.firebase.lang.core.psi.ext.elementType
import com.intellij.lang.annotation.AnnotationHolder
import com.intellij.lang.annotation.Annotator
import com.intellij.psi.PsiElement
import com.intellij.psi.impl.source.tree.LeafPsiElement

class HighlightingAnnotator: Annotator {
    override fun annotate(element: PsiElement, holder: AnnotationHolder) {
        val color = when {
            element.parent is FireRulesCallExpr -> highlightCallFunctions(element)
            element.parent is FireRulesDotExpr -> highlightFields(element)
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
        return when(element) {
            is FireRulesIdentifierExpr -> FirebaseColors.CALL_FUNCTION
            else -> null
        }
    }

    private fun highlightFields(element: PsiElement): FirebaseColors? {
        return when(element) {
            is FireRulesIdentifierExpr -> {
                if (FireRulesTypes.DOT == element.prevSibling) FirebaseColors.FIELDS
                else null
            }
            else -> null
        }
    }
}
