package co.anbora.labs.firebase.lang.core.psi.mixins

import co.anbora.labs.firebase.lang.core.psi.FireRuleElementImpl
import co.anbora.labs.firebase.lang.core.psi.FireRulesPathBuiltInLit
import co.anbora.labs.firebase.lang.core.psi.resolve.ref.FireRulePathBuiltInLitReferenceImpl
import co.anbora.labs.firebase.lang.core.psi.resolve.ref.FireRuleReference
import com.intellij.lang.ASTNode

abstract class FireRulePathBuiltMixin(
    node: ASTNode
): FireRuleElementImpl(node), FireRulesPathBuiltInLit {

    override fun getReference(): FireRuleReference? = FireRulePathBuiltInLitReferenceImpl(this)
}
