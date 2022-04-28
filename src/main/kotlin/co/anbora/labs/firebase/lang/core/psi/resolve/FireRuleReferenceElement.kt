package co.anbora.labs.firebase.lang.core.psi.resolve

import co.anbora.labs.firebase.lang.core.psi.FireRuleElement
import co.anbora.labs.firebase.lang.core.psi.resolve.ref.FireRuleReference
import com.intellij.psi.PsiElement
import com.intellij.psi.PsiReference

interface PsiReferenceElement : PsiElement {
    val identifier: PsiElement?

    val referenceNameElement: PsiElement?
        get() = identifier

    val referenceName: String?
        get() = identifier?.text

    override fun getReference(): PsiReference?

    val isUnresolved: Boolean
        get() = reference?.resolve() == null
}

interface FireRuleReferenceElement : PsiReferenceElement, FireRuleElement {

    override fun getReference(): FireRuleReference?
}

//interface MvPolyVariantReferenceElement: PsiReferenceElement, MvElement {
//    override val identifier: PsiElement
//
////    override val referenceNameElement: PsiElement get() = identifier
//
////    override val referenceName: String get() = referenceNameElement.text
//
//    override fun getReference(): MvReference
//}
