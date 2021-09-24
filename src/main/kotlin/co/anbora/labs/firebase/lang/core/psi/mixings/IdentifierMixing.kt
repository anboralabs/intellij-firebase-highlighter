package co.anbora.labs.firebase.lang.core.psi.mixings

import co.anbora.labs.firebase.lang.core.psi.FirebaseRulesIdentifierExpr
import co.anbora.labs.firebase.lang.core.psi.impl.FirebaseNameIdentifierOwnerImpl
import com.intellij.lang.ASTNode

abstract class IdentifierMixing(node: ASTNode): FirebaseNameIdentifierOwnerImpl(node), FirebaseRulesIdentifierExpr {
}