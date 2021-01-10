package co.anbora.labs.firebase.ide.formatter

import com.intellij.formatting.*
import com.intellij.lang.ASTNode
import com.intellij.psi.formatter.common.AbstractBlock

class FirebaseFormatterBlock(
    node: ASTNode,
    wrap: Wrap? = null,
    alignment: Alignment? = null,
    val spacingBuilder: SpacingBuilder
): AbstractBlock(node, wrap, alignment) {

    override fun isLeaf(): Boolean = node.firstChildNode == null

    override fun getIndent(): Indent?
        = computeIndent()

    override fun getChildAttributes(newChildIndex: Int): ChildAttributes
        = computeChildAttributes()

    override fun getSpacing(child1: Block?, child2: Block): Spacing?
        = computeSpacing(child1, child2)

    override fun getSubBlocks(): List<Block> = mySubBlocks

    private val mySubBlocks: List<Block> by lazy { buildChildren() }

    override fun buildChildren(): List<Block> {
        return node.getChildren(null)
            .filter { !it.isWhitespaceOrEmpty() }
            .map { childNode: ASTNode ->
                FirebaseFormatterBlock(
                    node = childNode,
                    spacingBuilder = spacingBuilder
                )
            }
    }
}
