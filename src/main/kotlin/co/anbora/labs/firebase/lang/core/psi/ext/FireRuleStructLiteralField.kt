package co.anbora.labs.firebase.lang.core.psi.ext

import co.anbora.labs.firebase.lang.core.psi.FireRuleElementImpl
import co.anbora.labs.firebase.lang.core.psi.FireRulesStructLitExpr
import co.anbora.labs.firebase.lang.core.psi.FireRulesStructLitField
import co.anbora.labs.firebase.lang.core.psi.FireRulesTypes
import co.anbora.labs.firebase.lang.core.psi.resolve.ref.FireRuleReference
import co.anbora.labs.firebase.lang.core.psi.resolve.ref.FireRuleStructFieldReferenceImpl
//import co.anbora.labs.firebase.lang.core.psi.resolve.ref.FireRuleStructLitShorthandFieldReferenceImpl
import com.intellij.lang.ASTNode

val FireRulesStructLitField.structLit: FireRulesStructLitExpr
    get() = ancestorStrict()!!

val FireRulesStructLitField.isShorthand: Boolean
    get() = !hasChild(FireRulesTypes.COLON)

/*fun MvStructLitField.inferInitExprTy(ctx: InferenceContext): Ty {
    val initExpr = this.expr
    return if (initExpr == null) {
        // find type of binding
        val resolved =
            this.reference.multiResolve().filterIsInstance<MvBindingPat>().firstOrNull() ?: return TyUnknown
        resolved.ty()
    } else {
        // find type of expression
        initExpr.inferExprTy(ctx)
    }
}*/

/*abstract class FireRuleStructLitFieldMixin(node: ASTNode) : FireRuleElementImpl(node), FireRulesStructLitField {
    override fun getReference(): FireRuleReference {
        if (!this.isShorthand) return FireRuleStructFieldReferenceImpl(this)
        return FireRuleStructLitShorthandFieldReferenceImpl(this)
    }
}*/
