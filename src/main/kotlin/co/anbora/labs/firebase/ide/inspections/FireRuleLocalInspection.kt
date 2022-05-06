package co.anbora.labs.firebase.ide.inspections

import co.anbora.labs.firebase.lang.core.psi.FireRuleElement
import com.intellij.codeInspection.LocalInspectionTool
import com.intellij.codeInspection.ProblemsHolder
import com.intellij.psi.PsiElement
import com.intellij.psi.PsiElementVisitor

abstract class FireRuleLocalInspection : LocalInspectionTool() {

    override fun buildVisitor(holder: ProblemsHolder, isOnTheFly: Boolean) = object : PsiElementVisitor() {
        override fun visitElement(element: PsiElement) {
            super.visitElement(element)
            if (element is FireRuleElement) {
                visitElement(element, holder, isOnTheFly)
            }
        }
    }

    abstract fun visitElement(element: FireRuleElement, holder: ProblemsHolder, isOnTheFly: Boolean)
}