package co.anbora.labs.firebase.ide.inspections

import co.anbora.labs.firebase.lang.core.psi.FireRuleElement
import co.anbora.labs.firebase.lang.core.psi.FireRulesFileStructure
import com.intellij.codeInspection.ProblemHighlightType
import com.intellij.codeInspection.ProblemsHolder
import com.intellij.psi.PsiElement

private const val SERVICE_DEF_MAIN_INDEX = 0

class DuplicateServiceInspection: FireRuleLocalInspection() {
    override fun visitElement(element: FireRuleElement, holder: ProblemsHolder, isOnTheFly: Boolean) {
        if (element is FireRulesFileStructure) {
            val serviceDef = element.serviceDefList
            serviceDef.forEachIndexed { index, fireRulesServiceDef ->
                val name = fireRulesServiceDef.serviceNameDef.text
                if (index > SERVICE_DEF_MAIN_INDEX) {
                    markAsDuplicated(holder, fireRulesServiceDef.serviceNameDef, name)
                }
            }
        }
    }

    private fun markAsDuplicated(holder: ProblemsHolder, element: PsiElement, name: String) {
        holder.registerProblem(
            element,
            "'$name', Only one service definition is allowed",
            ProblemHighlightType.ERROR
        )
    }

}
