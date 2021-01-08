package co.anbora.labs.firebase.ide.formatter

import co.anbora.labs.firebase.lang.core.psi.FirebaseRulesTypes
import com.intellij.formatting.ChildAttributes
import com.intellij.formatting.Indent
import com.intellij.lang.ASTNode
import com.intellij.psi.TokenType
import com.intellij.psi.tree.IElementType

fun FirebaseFormatterBlock.computeIndent(): Indent? {
    val parent = node.treeParent
    return when {
        parent?.treeParent == null -> Indent.getNoneIndent()
        node.isBetweenBraces() -> Indent.getNormalIndent()
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

fun ASTNode.isBetweenBraces(): Boolean {
    val elementType: IElementType = this.elementType
    if (elementType === FirebaseRulesTypes.LEFT_BRACE || elementType === FirebaseRulesTypes.RIGHT_BRACE) return false

    var sibling: ASTNode? = this.treePrev
    while (sibling != null) {
        if (sibling.elementType === FirebaseRulesTypes.LEFT_BRACE) return true
        sibling = sibling.treePrev
    }

    return false
}

fun ASTNode.isComposeBlock(): Boolean {
    val elementType: IElementType = this.elementType
    return elementType == FirebaseRulesTypes.SERVICE_STATEMENT ||
            elementType == FirebaseRulesTypes.MATCH_STATEMENT ||
            elementType == FirebaseRulesTypes.FUNCTION_STATEMENT
}

fun ASTNode?.isWhitespaceOrEmpty() = this == null || textLength == 0 || elementType == TokenType.WHITE_SPACE
