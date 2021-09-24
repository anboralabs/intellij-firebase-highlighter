package co.anbora.labs.firebase.ide.annotator

import co.anbora.labs.firebase.ide.color.FirebaseColors
import co.anbora.labs.firebase.lang.core.psi.FirebaseRulesIdentifierExpr
import co.anbora.labs.firebase.lang.core.psi.FirebaseRulesMatchDef
import co.anbora.labs.firebase.lang.core.psi.FirebaseRulesPathStatement
import co.anbora.labs.firebase.lang.core.psi.FirebaseRulesVisitor
import com.intellij.lang.annotation.AnnotationHolder
import com.intellij.psi.PsiElement
import com.intellij.psi.util.PsiTreeUtil

class PathVariableHighlightAnnotator : FirebaseAnnotator() {
    override fun annotateInternal(element: PsiElement, holder: AnnotationHolder) {
        val visitor = object : FirebaseRulesVisitor() {
            override fun visitMatchDef(o: FirebaseRulesMatchDef) {
                checkPathVariablesInMatchDef(holder, element)
            }
        }
        element.accept(visitor)
    }

    private fun checkPathVariablesInMatchDef(holder: AnnotationHolder, element: PsiElement) {
        val color = FirebaseColors.NUMBERS
        val pathVariables = PsiTreeUtil.collectElementsOfType(element, FirebaseRulesPathStatement::class.java)
            .map { it.text }
            .map { it.replace("{", "")
                .replace("}", "")
                .replace("=", "")
                .replace("*", "")
            }.toSet()
        val variables = PsiTreeUtil.collectElementsOfType(element, FirebaseRulesIdentifierExpr::class.java)
        variables.forEach {
            if (pathVariables.contains(it.text)) {

            }
        }
    }
}