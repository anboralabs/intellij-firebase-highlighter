package co.anbora.labs.firebase.ide.formatter

import co.anbora.labs.firebase.ide.formatter.impl.*
import co.anbora.labs.firebase.lang.core.psi.FirebaseRulesTypes.PARAMETER_STATEMENT
import com.intellij.formatting.*
import com.intellij.lang.ASTNode
import com.intellij.psi.formatter.common.AbstractBlock

class FirebaseFormatterBlock(
    node: ASTNode,
    wrap: Wrap?,
    alignment: Alignment?
): AbstractBlock(node, wrap, alignment) {

    override fun isLeaf(): Boolean = node.firstChildNode == null

    override fun getIndent(): Indent? {
        val parent = node.treeParent
        return when {
            parent?.treeParent == null -> Indent.getNoneIndent()
            node.isBetweenBraces() -> Indent.getNormalIndent()
            else -> Indent.getNoneIndent()
        }
    }

    override fun getSpacing(child1: Block?, child2: Block): Spacing? = null

    override fun getSubBlocks(): List<Block> = mySubBlocks

    private val mySubBlocks: List<Block> by lazy { buildChildren() }

    override fun buildChildren(): List<Block> {
        return node.getChildren(null)
            .filter { !it.isWhitespaceOrEmpty() }
            .map { childNode: ASTNode ->
                FirebaseFormatterBlock(
                    node = childNode,
                    alignment = null,
                    wrap = null
                )
            }
    }
}