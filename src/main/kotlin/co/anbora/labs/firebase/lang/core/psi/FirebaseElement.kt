package co.anbora.labs.firebase.lang.core.psi

import com.intellij.extapi.psi.ASTWrapperPsiElement
import com.intellij.lang.ASTNode
import com.intellij.psi.PsiElement

interface FirebaseElement: PsiElement {
}

abstract class FirebaseElementImpl(
    node: ASTNode
) : ASTWrapperPsiElement(node), FirebaseElement {

}