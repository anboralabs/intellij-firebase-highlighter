package co.anbora.labs.firebase.lang.core.psi.resolve.ref

import co.anbora.labs.firebase.lang.core.psi.FireRuleNamedElement
import co.anbora.labs.firebase.lang.core.psi.FireRulesIdentifierExpr
import co.anbora.labs.firebase.lang.core.psi.resolve.ref.FireRuleReferenceCached
import co.anbora.labs.firebase.lang.core.psi.resolve.ref.Namespace
import co.anbora.labs.firebase.lang.core.psi.resolve.resolveItem

class FireRuleIdentifierExprReferenceImpl(
    element: FireRulesIdentifierExpr
) : FireRuleReferenceCached<FireRulesIdentifierExpr>(element) {

    override fun resolveInner(): List<FireRuleNamedElement> = resolveItem(element, Namespace.NAME)
}