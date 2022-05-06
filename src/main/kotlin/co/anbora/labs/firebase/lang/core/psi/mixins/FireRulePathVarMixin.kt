package co.anbora.labs.firebase.lang.core.psi.mixins

import co.anbora.labs.firebase.lang.core.psi.FireRulesPathVar
import co.anbora.labs.firebase.lang.core.psi.impl.FireRuleNamePathOwnerImpl
import com.intellij.lang.ASTNode

abstract class FireRulePathVarMixin(
    node: ASTNode
): FireRuleNamePathOwnerImpl(node), FireRulesPathVar {

    override fun getName(): String? {
        return super.getName()?.replace("=**", "")
            ?.replace("{", "")
            ?.replace("}", "")
    }
}
