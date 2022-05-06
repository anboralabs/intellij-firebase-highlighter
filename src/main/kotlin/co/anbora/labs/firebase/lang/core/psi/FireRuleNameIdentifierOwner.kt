package co.anbora.labs.firebase.lang.core.psi

import co.anbora.labs.firebase.lang.core.psi.ext.findLastChildByType
import com.intellij.psi.PsiElement
import com.intellij.psi.PsiNameIdentifierOwner

interface FireRuleNameIdentifierOwner : FireRuleNamedElement,
                                    PsiNameIdentifierOwner

interface FireRulePathIdentifierOwner : FireRuleNamedElement, PsiNameIdentifierOwner {

    override val nameElement: PsiElement?
        get() = findLastChildByType(FireRulesTypes.PATH_VARIABLE_LITERAL)
}
