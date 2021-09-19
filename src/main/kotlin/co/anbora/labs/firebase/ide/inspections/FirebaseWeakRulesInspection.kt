package co.anbora.labs.firebase.ide.inspections

import co.anbora.labs.firebase.lang.core.psi.FirebaseRulesConditionalBlock
import co.anbora.labs.firebase.lang.core.psi.FirebaseRulesLiteralExpr
import com.intellij.codeInspection.LocalInspectionTool
import com.intellij.codeInspection.ProblemHighlightType
import com.intellij.codeInspection.ProblemsHolder
import com.intellij.psi.PsiElement
import com.intellij.psi.PsiElementVisitor

private const val FIREBASE_TRUE = "true"

class FirebaseWeakRulesInspection: LocalInspectionTool() {
    override fun buildVisitor(holder: ProblemsHolder, isOnTheFly: Boolean): PsiElementVisitor {
        return object: PsiElementVisitor() {
            override fun visitElement(element: PsiElement) {
                super.visitElement(element)
                when (element) {
                    is FirebaseRulesConditionalBlock -> checkWeakRule(element, holder)
                }
            }
        }
    }
}

private fun checkWeakRule(element: FirebaseRulesConditionalBlock, holder: ProblemsHolder) {
    val decl = element.expression
    val literal = decl as? FirebaseRulesLiteralExpr
    val booleanStm = literal?.booleanStatement
    if (booleanStm?.text == FIREBASE_TRUE) {
        holder.registerProblem(booleanStm, "Weak rule, this is not recommended for production environments.", ProblemHighlightType.WEAK_WARNING)
    }
}