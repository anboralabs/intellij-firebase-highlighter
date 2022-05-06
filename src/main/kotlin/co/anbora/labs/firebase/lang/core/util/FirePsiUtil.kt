package co.anbora.labs.firebase.lang.core.util

import co.anbora.labs.firebase.ide.refactoring.isValidFireRuleVariableIdentifier
import co.anbora.labs.firebase.lang.core.psi.FireRulePsiFactory
import co.anbora.labs.firebase.lang.core.psi.FireRulesTypes
import co.anbora.labs.firebase.lang.core.psi.ext.elementType
import com.intellij.psi.PsiElement

fun doRenameIdentifier(identifier: PsiElement, newName: String) {
    val factory = FireRulePsiFactory(identifier.project)
    val newIdentifier = when (identifier.elementType) {
        FireRulesTypes.IDENTIFIER -> {
            if (!isValidFireRuleVariableIdentifier(newName)) return
            factory.createIdentifier(newName)
        }
        else -> error("Unsupported identifier type for `$newName` (${identifier.elementType})")
    }
    identifier.replace(newIdentifier)
}
