package co.anbora.labs.firebase.ide.inspections

import co.anbora.labs.firebase.lang.core.psi.*
import co.anbora.labs.firebase.lang.core.psi.ext.scope
import com.intellij.codeInspection.LocalInspectionTool
import com.intellij.codeInspection.ProblemHighlightType
import com.intellij.codeInspection.ProblemsHolder
import com.intellij.psi.PsiElement
import com.intellij.psi.PsiElementVisitor
import com.intellij.psi.util.PsiTreeUtil

class DuplicateFunctionsDeclarationInspection : LocalInspectionTool() {
    override fun buildVisitor(holder: ProblemsHolder, isOnTheFly: Boolean): PsiElementVisitor {
        return object: PsiElementVisitor() {
            override fun visitElement(element: PsiElement) {
                super.visitElement(element)
                when (element) {
                    is FirebaseFile -> checkFunctionSignature(element, holder)
                    is FireRulesFullPath -> checkPathVariable(element, holder)
                }
            }
        }
    }
}

private fun checkFunctionSignature(element: FirebaseFile, holder: ProblemsHolder) {
    val functions = PsiTreeUtil.collectElementsOfType(element, FireRulesFunctionDef::class.java)
    val mapFunctions = HashMap<String, Unit>()
    functions.forEach {
        val key = "${it.scope()}_${it.identifier?.text}_${it.functionParameterList?.functionParameterList?.size}"
        mapFunctions.compute(key) { _, v ->
            if (v != null) markDuplicate(it.identifier ?: it, holder)
        }
    }
}

private fun checkPathVariable(element: FireRulesFullPath, holder: ProblemsHolder) {
    val variables = PsiTreeUtil.collectElementsOfType(element, FireRulesPathVar::class.java)
    val mapPathVariables = HashMap<String, Unit>()
    variables.forEach {
        val key = it.text
        mapPathVariables.compute(key) { _, v ->
            if (v != null) markDuplicate(it, holder)
        }
    }
}

private fun markDuplicate(element: PsiElement, holder: ProblemsHolder) {
    holder.registerProblem(element, "Duplicate definitions with name `${element.text}`", ProblemHighlightType.ERROR)
}
