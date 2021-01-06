package co.anbora.labs.firebase.ide.formatter.impl

import co.anbora.labs.firebase.lang.core.psi.*
import co.anbora.labs.firebase.lang.core.psi.FirebaseRulesTypes.*
import com.intellij.lang.ASTNode
import com.intellij.psi.PsiElement
import com.intellij.psi.TokenType
import com.intellij.psi.tree.IElementType
import com.intellij.psi.tree.TokenSet.create as ts


val PAREN_DELIMITED_BLOCKS = ts(
    FUNCTION_PARAMETER_STATEMENT, CALL_FUNCTION_STATEMENT
)

val ONE_LINE_ITEMS = ts(RETURN_STATEMENT)

val BLOCK_LIKE = ts(
    MATCH_STATEMENT, FUNCTION_STATEMENT, SERVICE_STATEMENT
)

fun ASTNode?.isWhitespaceOrEmpty() = this == null || textLength == 0 || elementType == TokenType.WHITE_SPACE

val PsiElement.isTopLevelItem: Boolean
    get() = (this is FirebaseRulesServiceStatement || this is FirebaseRulesMatchStatement)

val PsiElement.isDeclarationItem: Boolean
    get() = (this is FirebaseRulesFunctionStatement)

val PsiElement.isStatement: Boolean
    get() = this is FirebaseRulesMatchStatement && parent is FirebaseRulesPermissionStatement

val PsiElement.isStatementOrExpr: Boolean
    get() = this is FirebaseRulesPermissionStatement || this is FirebaseRulesExpression && parent is FirebaseRulesMatchStatement

fun ASTNode.isDelimiterOfCurrentBlock(parent: ASTNode?): Boolean {
    if (parent == null) return false
    val parentType = parent.elementType
    return when (elementType) {
        LEFT_BRACE, RIGHT_BRACE -> parentType in BLOCK_LIKE
        LP, RP -> parentType in PAREN_DELIMITED_BLOCKS
        else -> false
    }
}

fun ASTNode.isBetweenBraces(): Boolean {
    val elementType: IElementType = this.elementType
    if (elementType === LEFT_BRACE || elementType === RIGHT_BRACE) return false

    var sibling: ASTNode? = this.treePrev
    while (sibling != null) {
        if (sibling.elementType === LEFT_BRACE) return true
        sibling = sibling.treePrev
    }

    return false
}