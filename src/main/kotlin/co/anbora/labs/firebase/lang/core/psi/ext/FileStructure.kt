package co.anbora.labs.firebase.lang.core.psi.ext

import co.anbora.labs.firebase.lang.core.psi.FireRulesFileStructure
import co.anbora.labs.firebase.lang.core.psi.FireRulesFunctionDef
import co.anbora.labs.firebase.lang.core.psi.psiFactory
import com.intellij.openapi.project.Project

fun FireRulesFileStructure.functions() = this.functionDefList.orEmpty()

fun FireRulesFileStructure.builtInFunctions(): List<FireRulesFunctionDef> {
    return listOf(
        createBuiltinFunction(
            """
            // Retrieves data from the given path. 
            function get(path) { return path; }
            """, project
        ),
        createBuiltinFunction(
            """
            /// Return true if the given path exists. 
            function exists(path) { return true; }
            """, project
        )
    )
}

fun createBuiltinFunction(text: String, project: Project): FireRulesFunctionDef {
    val trimmedText = text.trimIndent()
    val function = project.psiFactory.createFunction(trimmedText)
    (function as FireRuleFunctionMixin).builtIn = true
    return function
}
