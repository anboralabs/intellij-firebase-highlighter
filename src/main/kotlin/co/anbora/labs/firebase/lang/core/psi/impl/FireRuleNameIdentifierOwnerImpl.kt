package co.anbora.labs.firebase.lang.core.psi.impl

import co.anbora.labs.firebase.lang.core.psi.FireRuleNameIdentifierOwner
import co.anbora.labs.firebase.lang.core.psi.FireRulePathIdentifierOwner
import com.intellij.lang.ASTNode
import com.intellij.psi.PsiElement

abstract class FireRuleNameIdentifierOwnerImpl(
    node: ASTNode
) : FireRuleNamedElementImpl(node), FireRuleNameIdentifierOwner {
    override fun getNameIdentifier(): PsiElement? = nameElement
}

abstract class FireRuleNamePathOwnerImpl(
    node: ASTNode
) : FireRuleNamedElementImpl(node), FireRulePathIdentifierOwner {
    override fun getNameIdentifier(): PsiElement? = nameElement
}
