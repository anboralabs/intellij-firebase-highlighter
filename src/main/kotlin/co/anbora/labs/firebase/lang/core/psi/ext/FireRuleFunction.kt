package co.anbora.labs.firebase.lang.core.psi.ext

import co.anbora.labs.firebase.ide.icons.FirebaseIcons
import co.anbora.labs.firebase.lang.core.psi.FireRulesFunctionDef
import co.anbora.labs.firebase.lang.core.psi.impl.FireRuleNameIdentifierOwnerImpl
import com.intellij.lang.ASTNode
import javax.swing.Icon

abstract class FireRuleFunctionMixin(node: ASTNode) : FireRuleNameIdentifierOwnerImpl(node),
                                                    FireRulesFunctionDef {

    var builtIn = false

    override fun canNavigate(): Boolean = !builtIn
    override fun canNavigateToSource(): Boolean = !builtIn

    override fun getIcon(flags: Int): Icon = FirebaseIcons.FUNCTION
}
