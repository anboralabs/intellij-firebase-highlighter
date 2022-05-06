package co.anbora.labs.firebase.lang.core.psi.mixins

import co.anbora.labs.firebase.lang.core.psi.FireRuleElementImpl
import co.anbora.labs.firebase.lang.core.psi.FireRulesIdentifierExpr
import co.anbora.labs.firebase.lang.core.psi.resolve.ref.FireRuleIdentifierExprReferenceImpl
import co.anbora.labs.firebase.lang.core.psi.resolve.ref.FireRuleReference
import com.intellij.lang.ASTNode

abstract class FireRuleIdentifierMixin(
    node: ASTNode
): FireRuleElementImpl(node), FireRulesIdentifierExpr {

    override fun getReference(): FireRuleReference? {
        return FireRuleIdentifierExprReferenceImpl(this)
    }
}
