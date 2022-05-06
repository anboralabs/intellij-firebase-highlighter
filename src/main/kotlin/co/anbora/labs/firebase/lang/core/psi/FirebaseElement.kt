package co.anbora.labs.firebase.lang.core.psi

import com.intellij.extapi.psi.ASTWrapperPsiElement
import com.intellij.lang.ASTNode
import com.intellij.psi.PsiElement

interface FireRuleElement: PsiElement

abstract class FireRuleElementImpl(
    node: ASTNode
) : ASTWrapperPsiElement(node), FireRuleElement
