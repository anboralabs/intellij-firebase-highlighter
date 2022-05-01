package co.anbora.labs.firebase.lang.core.psi.mixins

import co.anbora.labs.firebase.ide.icons.FirebaseIcons
import co.anbora.labs.firebase.lang.core.psi.FireRulesFunctionParameter
import co.anbora.labs.firebase.lang.core.psi.impl.FireRuleNameIdentifierOwnerImpl
import com.intellij.lang.ASTNode
import javax.swing.Icon

abstract class FireRuleFunctionParameterMixin(
    node: ASTNode
): FireRuleNameIdentifierOwnerImpl(node), FireRulesFunctionParameter {

    override fun getIcon(flags: Int): Icon? = FirebaseIcons.PARAMETER


}
