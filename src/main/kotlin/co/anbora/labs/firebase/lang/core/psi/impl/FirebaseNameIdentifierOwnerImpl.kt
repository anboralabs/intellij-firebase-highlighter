package co.anbora.labs.firebase.lang.core.psi.impl

import co.anbora.labs.firebase.lang.core.psi.FirebaseNameIdentifierOwner
import com.intellij.lang.ASTNode
import com.intellij.psi.PsiElement

abstract class FirebaseNameIdentifierOwnerImpl(
    node: ASTNode
) : FirebaseNamedElementImpl(node), FirebaseNameIdentifierOwner {
    override fun getNameIdentifier(): PsiElement? = nameElement
}
