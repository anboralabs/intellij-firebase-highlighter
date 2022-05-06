package co.anbora.labs.firebase.ide.inspections

import co.anbora.labs.firebase.lang.core.psi.*
import com.intellij.codeInspection.ProblemHighlightType
import com.intellij.codeInspection.ProblemsHolder
import com.intellij.psi.search.searches.ReferencesSearch

class FindUsagesInspection: FireRuleLocalInspection() {
    override fun visitElement(element: FireRuleElement, holder: ProblemsHolder, isOnTheFly: Boolean) {
        if (element !is FireRuleNamedElement) return
        val name = element.name.orEmpty()

        when (element) {
            is FireRulesFunctionDef -> checkUsages(holder, element, name)
            is FireRulesFunctionParameter -> checkUsages(holder, element, name)
            is FireRulesLetStatement -> checkUsages(holder, element, name)
            is FireRulesPathVar -> checkUsages(holder, element, name)
        }
    }

    private fun checkUsages(holder: ProblemsHolder, element: FireRuleNamedElement, name: String) {
        val usages = ReferencesSearch.search(element).findAll()
        if (usages.isEmpty()) {
            markAsUnused(holder, element, name)
        }
    }

    private fun markAsUnused(holder: ProblemsHolder, element: FireRuleNamedElement, name: String) {
        holder.registerProblem(
            element.nameElement ?: element,
            "'$name' is never used",
            ProblemHighlightType.LIKE_UNUSED_SYMBOL
        )
    }
}
