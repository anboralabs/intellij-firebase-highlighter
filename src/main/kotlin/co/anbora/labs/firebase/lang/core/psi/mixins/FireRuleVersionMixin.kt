package co.anbora.labs.firebase.lang.core.psi.mixins

import co.anbora.labs.firebase.lang.core.psi.FireRuleElementImpl
import co.anbora.labs.firebase.lang.core.psi.FireRulesVersions
import com.intellij.icons.AllIcons
import com.intellij.lang.ASTNode

abstract class FireRuleVersionMixin(
    node: ASTNode
): FireRuleElementImpl(node), FireRulesVersions {

    override fun getIcon(flags: Int) = AllIcons.Nodes.Annotationtype

}