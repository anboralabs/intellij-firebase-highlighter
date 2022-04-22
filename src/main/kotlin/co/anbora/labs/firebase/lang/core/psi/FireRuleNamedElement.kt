package co.anbora.labs.firebase.lang.core.psi

import co.anbora.labs.firebase.lang.core.psi.FireRulesTypes.IDENTIFIER
import co.anbora.labs.firebase.lang.core.psi.ext.findLastChildByType
import com.intellij.psi.NavigatablePsiElement
import com.intellij.psi.PsiElement
import com.intellij.psi.PsiNamedElement

interface FireRuleNamedElement : FireRuleElement,
                             PsiNamedElement,
                             NavigatablePsiElement {

    val nameElement: PsiElement?
        get() = findLastChildByType(IDENTIFIER)
}
