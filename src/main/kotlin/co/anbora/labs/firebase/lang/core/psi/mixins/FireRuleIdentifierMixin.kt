package co.anbora.labs.firebase.lang.core.psi.mixins

import co.anbora.labs.firebase.ide.icons.FirebaseIcons
import co.anbora.labs.firebase.lang.core.psi.FireRuleElementImpl
import co.anbora.labs.firebase.lang.core.psi.FireRulesIdentifierExpr
import co.anbora.labs.firebase.lang.core.psi.resolve.ref.FireRuleIdentifierExprReferenceImpl
import co.anbora.labs.firebase.lang.core.psi.resolve.ref.FireRuleReference
import com.intellij.lang.ASTNode
import com.intellij.psi.PsiElement
import com.intellij.psi.PsiReference
import com.intellij.psi.impl.source.resolve.reference.ReferenceProvidersRegistry
import javax.swing.Icon

abstract class FireRuleIdentifierMixin(
    node: ASTNode
): FireRuleElementImpl(node), FireRulesIdentifierExpr {

    override fun getReference(): FireRuleReference? {
        return FireRuleIdentifierExprReferenceImpl(this)
    }
}
