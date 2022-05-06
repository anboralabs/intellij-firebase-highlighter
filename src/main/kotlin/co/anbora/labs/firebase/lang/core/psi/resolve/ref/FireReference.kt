package co.anbora.labs.firebase.lang.core.psi.resolve.ref

import co.anbora.labs.firebase.lang.core.psi.FireRuleElement
import co.anbora.labs.firebase.lang.core.psi.FireRuleNamedElement
import com.intellij.psi.PsiPolyVariantReference

interface FireRuleReference : PsiPolyVariantReference {

    override fun getElement(): FireRuleElement

    override fun resolve(): FireRuleNamedElement?

    fun multiResolve(): List<FireRuleNamedElement>
}

interface FireRulePathReference: FireRuleReference
