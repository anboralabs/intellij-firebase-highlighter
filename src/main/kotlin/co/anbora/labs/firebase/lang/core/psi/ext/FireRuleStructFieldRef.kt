package co.anbora.labs.firebase.lang.core.psi.ext

import co.anbora.labs.firebase.lang.core.psi.FireRuleElementImpl
import co.anbora.labs.firebase.lang.core.psi.FireRuleNamedElement
import co.anbora.labs.firebase.lang.core.psi.FireRulesStructFieldRef
import co.anbora.labs.firebase.lang.core.psi.resolve.FireRuleStructFieldReferenceElement
import co.anbora.labs.firebase.lang.core.psi.resolve.ref.FireRuleReference
import co.anbora.labs.firebase.lang.core.psi.resolve.ref.FireRuleReferenceCached
import co.anbora.labs.firebase.lang.core.psi.resolve.ref.Namespace
import co.anbora.labs.firebase.lang.core.psi.resolve.resolveItem
import com.intellij.lang.ASTNode

class FireRuleDotStructFieldAccessReferenceImpl(
    element: FireRuleStructFieldReferenceElement
) : FireRuleReferenceCached<FireRuleStructFieldReferenceElement>(element) {

    override fun resolveInner(): List<FireRuleNamedElement> = resolveItem(element, Namespace.DOT_ACCESSED_FIELD)
}

/*abstract class FireRuleStructFieldRefMixin(node: ASTNode) : FireRuleElementImpl(node), FireRulesStructFieldRef {
    override fun getReference(): FireRuleReference {
        return FireRuleDotStructFieldAccessReferenceImpl(this)
    }
}*/
