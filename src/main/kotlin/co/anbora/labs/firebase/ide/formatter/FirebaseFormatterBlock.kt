package co.anbora.labs.firebase.ide.formatter

import co.anbora.labs.firebase.ide.formatter.impl.*
import co.anbora.labs.firebase.lang.core.psi.FirebaseRulesTypes.PARAMETER_STATEMENT
import com.intellij.formatting.*
import com.intellij.lang.ASTNode
import com.intellij.psi.formatter.common.AbstractBlock

class FirebaseFormatterBlock(
    node: ASTNode,
    wrap: Wrap?,
    alignment: Alignment?,
    private val indent: Indent?,
    val ctx: FirebaseFmtContext
): AbstractBlock(node, wrap, alignment) {

    override fun isLeaf(): Boolean = node.firstChildNode == null

    override fun getIndent(): Indent? = indent

    override fun getSpacing(child1: Block?, child2: Block): Spacing? = computeSpacing(child1, child2, ctx)

    override fun getSubBlocks(): List<Block> = mySubBlocks

    private val mySubBlocks: List<Block> by lazy { buildChildren() }

    override fun buildChildren(): List<Block> {
        val sharedAlignment = when (node.elementType) {
            PARAMETER_STATEMENT -> Alignment.createAlignment()
            else -> null
        }
        val alignment = getAlignmentStrategy()

        return node.getChildren(null)
            .filter { !it.isWhitespaceOrEmpty() }
            .map { childNode: ASTNode ->
                val childCtx = ctx.copy(sharedAlignment = sharedAlignment)
                val indent = computeIndent(childNode)
                FirebaseFormatterBlock(
                    node = childNode,
                    alignment = alignment.getAlignment(childNode, node, childCtx),
                    indent = indent,
                    wrap = null,
                    ctx = childCtx
                )
            }
    }
}