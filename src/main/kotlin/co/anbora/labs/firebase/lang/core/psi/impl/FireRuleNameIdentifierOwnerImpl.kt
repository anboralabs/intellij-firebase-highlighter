package co.anbora.labs.firebase.lang.core.psi.impl

import co.anbora.labs.firebase.lang.core.psi.FireRuleNameIdentifierOwner
import com.intellij.lang.ASTNode
import com.intellij.psi.PsiElement

abstract class FireRuleNameIdentifierOwnerImpl(
    node: ASTNode
) : FireRuleNamedElementImpl(node), FireRuleNameIdentifierOwner {
    override fun getNameIdentifier(): PsiElement? = nameElement
}
