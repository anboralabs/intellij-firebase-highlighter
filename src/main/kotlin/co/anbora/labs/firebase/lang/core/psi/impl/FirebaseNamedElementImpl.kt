package co.anbora.labs.firebase.lang.core.psi.impl

import co.anbora.labs.firebase.lang.core.psi.FirebaseElementImpl
import co.anbora.labs.firebase.lang.core.psi.FirebaseNamedElement
import com.intellij.lang.ASTNode
import com.intellij.psi.PsiElement

abstract class FirebaseNamedElementImpl(
    node: ASTNode
) : FirebaseElementImpl(node), FirebaseNamedElement {
    override fun getName(): String? = nameElement?.text

    override fun setName(name: String): PsiElement {
        //nameElement?.replace(MovePsiFactory(project).createIdentifier(name))
        return this
    }

    override fun getNavigationElement(): PsiElement = nameElement ?: this

    override fun getTextOffset(): Int = nameElement?.textOffset ?: super.getTextOffset()
}
