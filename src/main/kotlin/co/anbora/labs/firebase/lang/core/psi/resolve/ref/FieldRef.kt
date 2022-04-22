package co.anbora.labs.firebase.lang.core.psi.resolve.ref

import co.anbora.labs.firebase.lang.core.psi.FireRuleNamedElement
import co.anbora.labs.firebase.lang.core.psi.FireRulesStructLitField
import co.anbora.labs.firebase.lang.core.psi.psiFactory
import co.anbora.labs.firebase.lang.core.psi.resolve.FireRuleMandatoryReferenceElement
import co.anbora.labs.firebase.lang.core.psi.resolve.FireRulePathVarReferenceElement
import co.anbora.labs.firebase.lang.core.psi.resolve.resolveItem
import com.intellij.psi.PsiElement

class FireRuleStructFieldReferenceImpl(
    element: FireRuleMandatoryReferenceElement
) : FireRuleReferenceCached<FireRuleMandatoryReferenceElement>(element) {

    override fun resolveInner() = resolveItem(element, Namespace.STRUCT_FIELD)
}

/*class FireRuleStructLitShorthandFieldReferenceImpl(
    element: FireRulesStructLitField,
) : FireRuleReferenceCached<FireRulesStructLitField>(element) {

    override fun resolveInner(): List<FireRuleNamedElement> {
        return listOf(
            resolveItem(element, Namespace.STRUCT_FIELD),
            resolveItem(element, Namespace.NAME)
        ).flatten()
    }

    override fun handleElementRename(newName: String): PsiElement {
        val psiFactory = element.project.psiFactory
        val newLitField = psiFactory.createStructLitField(newName, element.referenceName)
        element.replace(newLitField)
        return element
    }
}

class FireRulePathVarReferenceImpl(
    element: FireRulePathVarReferenceElement
) : FireRuleReferenceCached<FireRulePathVarReferenceElement>(element) {

    override fun resolveInner(): List<FireRuleNamedElement> = resolveItem(element, Namespace.NAME)
}*/
