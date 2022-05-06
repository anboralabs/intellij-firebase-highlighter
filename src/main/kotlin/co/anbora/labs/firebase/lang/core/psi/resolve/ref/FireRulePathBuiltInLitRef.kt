package co.anbora.labs.firebase.lang.core.psi.resolve.ref

import co.anbora.labs.firebase.lang.core.psi.FireRuleNamedElement
import co.anbora.labs.firebase.lang.core.psi.FireRulesPathBuiltInLit
import co.anbora.labs.firebase.lang.core.psi.resolve.resolveItem

class FireRulePathBuiltInLitReferenceImpl(
    element: FireRulesPathBuiltInLit
): FireRuleReferenceCached<FireRulesPathBuiltInLit>(element) {
    override fun resolveInner(): List<FireRuleNamedElement> = resolveItem(element, Namespace.NAME)
}
