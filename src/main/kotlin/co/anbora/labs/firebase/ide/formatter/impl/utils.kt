package co.anbora.labs.firebase.ide.formatter.impl

import co.anbora.labs.firebase.lang.core.psi.FireRulesTypes.*
import com.intellij.lang.ASTNode
import com.intellij.psi.TokenType
import com.intellij.psi.tree.TokenSet

val PAREN_DELIMITED_BLOCKS = TokenSet.create(
    PARENS_EXPR, //ARRAY_LITERAL_EXPR,
    FUNCTION_PARAMETER_LIST, CALL_ARGUMENT_LIST
)

val BLOCK_LIKE = TokenSet.create(
    SERVICE_BLOCK, MATCH_BLOCK,
    CODE_BLOCK//, RETURN_BLOCK
)

val DELIMITED_BLOCKS = TokenSet.orSet(PAREN_DELIMITED_BLOCKS, BLOCK_LIKE)

fun ASTNode?.isWhitespaceOrEmpty() = this == null || textLength == 0 || elementType == TokenType.WHITE_SPACE

val ASTNode.isDelimitedBlock: Boolean
    get() = elementType in DELIMITED_BLOCKS

fun ASTNode.isDelimiterOfCurrentBlock(parent: ASTNode?): Boolean {
    if (parent == null) return false
    val parentType = parent.elementType
    return when (elementType) {
        L_BRACE, R_BRACE -> parentType in BLOCK_LIKE
        L_BRACK, R_BRACK -> parentType in BLOCK_LIKE
        L_PAREN, R_PAREN -> parentType in PAREN_DELIMITED_BLOCKS
        else -> false
    }
}
