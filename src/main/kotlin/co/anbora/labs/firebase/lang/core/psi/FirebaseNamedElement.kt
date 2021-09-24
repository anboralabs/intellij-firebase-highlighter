package co.anbora.labs.firebase.lang.core.psi

import co.anbora.labs.firebase.lang.core.psi.FirebaseRulesTypes.IDENTIFIER
import co.anbora.labs.firebase.lang.core.psi.ext.findLastChildByType
import com.intellij.psi.NavigatablePsiElement
import com.intellij.psi.PsiElement
import com.intellij.psi.PsiNamedElement

interface FirebaseNamedElement : FirebaseElement,
                             PsiNamedElement,
                             NavigatablePsiElement {

    val nameElement: PsiElement?
        get() = findLastChildByType(IDENTIFIER)
}