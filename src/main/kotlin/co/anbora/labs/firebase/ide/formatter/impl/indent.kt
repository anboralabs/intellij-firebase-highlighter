package co.anbora.labs.firebase.ide.formatter.impl

import co.anbora.labs.firebase.ide.formatter.FirebaseFormatterBlock
import co.anbora.labs.firebase.lang.core.psi.*
import co.anbora.labs.firebase.lang.core.psi.FireRulesTypes.CONDITION
import com.intellij.formatting.Indent
import com.intellij.lang.ASTNode

fun FirebaseFormatterBlock.computeIndent(child: ASTNode): Indent? {
//    val parentType = node.elementType
    val parentPsi = node.psi
//    val childType = child.elementType
    val childPsi = child.psi
    return when {
        node.isDelimitedBlock -> getNormalIndentIfNotCurrentBlockDelimiter(child, node)
        // do not indent statements
        childPsi.prevSibling == null -> Indent.getNoneIndent()
        //     let a =
        //     92;
        // =>
        //     let a =
        //         92;
        // except if RefExpr as lhs of assignment expr
//        childPsi is MoveExpr
//                && (parentType == LET_EXPR || parentType == ASSIGNMENT_EXPR || parentType == CONST_DEF) -> Indent.getNormalIndent()
        childPsi is FireRulesExpr
                && parentPsi is FireRulesInitializer -> Indent.getNormalIndent()

        childPsi is FireRulesIfExpr
                && parentPsi is FireRulesAllowPredicate -> Indent.getNormalIndent()

        childPsi is FireRulesCondition -> Indent.getNormalIndent()
//        if (true)
//            create()
//        else
//            delete()
        parentPsi is FireRulesServiceBlock
                || parentPsi is FireRulesMatchBlock
                || parentPsi is FireRulesCodeBlock
                || parentPsi is FireRulesReturnExpr -> Indent.getNormalIndent()

        parentPsi is FireRulesIfExpr -> Indent.getNormalIndent()

        // binary expressions, chain calls
        // no indent on it's own, use parent indent
        parentPsi is FireRulesExpr -> Indent.getIndent(Indent.Type.NONE, true, true)

        else -> Indent.getNoneIndent()
    }
}

fun getNormalIndentIfNotCurrentBlockDelimiter(child: ASTNode, parent: ASTNode): Indent =
    if (child.isDelimiterOfCurrentBlock(parent)) {
        Indent.getNoneIndent()
    } else {
        if (parent.elementType == CONDITION) {
            Indent.getNoneIndent()
        } else {
            Indent.getNormalIndent()
        }
    }
