package co.anbora.labs.firebase.ide.formatter

import co.anbora.labs.firebase.lang.FirebaseRulesLanguage
import co.anbora.labs.firebase.lang.core.psi.FirebaseRulesParameterStatement
import co.anbora.labs.firebase.lang.core.psi.FirebaseRulesTypes.*
import com.intellij.formatting.*
import com.intellij.lang.ASTNode
import com.intellij.psi.TokenType
import com.intellij.psi.codeStyle.CodeStyleSettings
import com.intellij.psi.tree.IElementType

fun FirebaseFormatterBlock.computeIndent(): Indent? {
    val parent = node.treeParent
    val psi = node.psi
    return when {
        parent?.treeParent == null -> Indent.getNoneIndent()
        node.areBraces() -> Indent.getNoneIndent()
        node.isBooleanOperator() -> Indent.getNormalIndent()
        parent.isComposeBlock() -> Indent.getNormalIndent()
        parent.isBooleanExpr() -> Indent.getNormalIndent()
        parent.isCallExpr() && psi is FirebaseRulesParameterStatement -> Indent.getNormalIndent()
        else -> Indent.getNoneIndent()
    }
}

fun FirebaseFormatterBlock.computeChildAttributes(): ChildAttributes {
    val indent = when {
        node.isComposeBlock() -> Indent.getNormalIndent()
        // Otherwise we don't want any indentation (null means continuation indent)
        else -> Indent.getNoneIndent()
    }
    return ChildAttributes(indent, null)
}

fun FirebaseFormatterBlock.computeSpacing(child1: Block?, child2: Block): Spacing? = this.spacingBuilder.getSpacing(this, child1, child2)

fun createSpacingBuilder(commonSettings: CodeStyleSettings): SpacingBuilder {
    return SpacingBuilder(commonSettings, FirebaseRulesLanguage)
        //Rules Version
        .after(RULES_VERSION).spacing(1, 1, 0, false, 0)
        .after(EQ).spacing(1, 1, 0, false, 0)
        .after(VERSIONS).spacing(0,0,0,false,0)
        //Service Statement
        .after(SERVICE_KEYWORD).spacing(1, 1, 0, false, 0)
        .after(SERVICE_NAME).spacing(1, 1, 0, false, 0)
        //Function Statement
        .after(FUNCTION_KEYWORD).spacing(1, 1, 0, false, 0)
        .after(FUNCTION_PARAMETER_LIST).spacing(1, 1, 0, false, 0)
        //Match Statement
        .after(MATCH_KEYWORD).spacing(1, 1, 0, false, 0)
        .after(FULL_PATH_STATEMENT).spacing(1, 1, 0, false, 0)
        //Allow Statement
        .after(ALLOW_KEYWORD).spacing(1, 1, 0, false, 0)
        .after(PERMISSION_KEY_WORD).spacing(0,0,0,false,0)
        .after(COMMA).spacing(1, 1, 0, false, 0)
        .after(COLON).spacing(1, 1, 0, false, 0)
        .after(IF_KEYWORD).spacing(1, 1, 0, false, 0)
        .after(EXPRESSION).spacing(1, 1, 0, false, 0)
        .after(OROR).spacing(1, 1, 0, false, 0)
        .after(ANDAND).spacing(1, 1, 0, false, 0)
        .after(LT).spacing(1, 1, 0, false, 0)
        .after(GT).spacing(1, 1, 0, false, 0)
        .after(LE).spacing(1, 1, 0, false, 0)
        .after(GE).spacing(1, 1, 0, false, 0)
        .after(EQEQ).spacing(1, 1, 0, false, 0)
        .after(NE).spacing(1, 1, 0, false, 0)
        .before(DOT_COMMA).spacing(0,0,0,false,0)
}

fun ASTNode.areBraces(): Boolean {
    return (elementType === LEFT_BRACE || elementType === RIGHT_BRACE)
}

fun ASTNode.isBooleanOperator(): Boolean {
    val elementType: IElementType = this.elementType
    return elementType == OROR ||
            elementType == ANDAND
}

fun ASTNode.isCallExpr(): Boolean {
    return this.elementType == CALL_EXPR
}

fun ASTNode.isBooleanExpr(): Boolean {
    return this.elementType == OR_EXPR
            || this.elementType == AND_EXPR
}

fun ASTNode.isParenthesisBlock(): Boolean {
    return this.elementType == PARENS_EXPR
}

fun ASTNode.isComposeBlock(): Boolean {
    val elementType: IElementType = this.elementType
    return elementType == SERVICE_BLOCK ||
            elementType == MATCH_BLOCK ||
            elementType == FUNCTION_BLOCK ||
            elementType == RETURN_BLOCK
}

fun ASTNode?.isWhitespaceOrEmpty() = this == null || textLength == 0 || elementType == TokenType.WHITE_SPACE
