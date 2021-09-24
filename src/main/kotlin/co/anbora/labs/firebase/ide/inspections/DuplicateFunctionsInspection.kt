package co.anbora.labs.firebase.ide.inspections

import co.anbora.labs.firebase.lang.core.psi.FirebaseFile
import co.anbora.labs.firebase.lang.core.psi.FirebaseRulesFunctionDef
import com.intellij.codeInspection.LocalInspectionTool
import com.intellij.codeInspection.ProblemHighlightType
import com.intellij.codeInspection.ProblemsHolder
import com.intellij.psi.PsiElement
import com.intellij.psi.PsiElementVisitor
import com.intellij.psi.util.PsiTreeUtil
import java.util.function.BiFunction

class DuplicateFunctionsDeclarationInspection : LocalInspectionTool() {
    override fun buildVisitor(holder: ProblemsHolder, isOnTheFly: Boolean): PsiElementVisitor {
        return object: PsiElementVisitor() {
            override fun visitElement(element: PsiElement) {
                super.visitElement(element)
                when (element) {
                    is FirebaseFile -> checkFunctionSignature(element, holder)
                }
            }
        }
    }
}

private fun checkFunctionSignature(element: FirebaseFile, holder: ProblemsHolder) {
    val functions = PsiTreeUtil.collectElementsOfType(element, FirebaseRulesFunctionDef::class.java)
    val mapFunctions = HashMap<String, Unit>()
    functions.forEach {
        val key = it.identifierExpr?.text + "_" + it.functionParameterList?.functionParameterList?.size
        mapFunctions.compute(key) { k, v ->
            if (v != null) holder.registerProblem(it.identifierExpr ?: it, "Duplicate definitions with name `${it.identifierExpr?.text}`", ProblemHighlightType.ERROR)
        }
    }
}