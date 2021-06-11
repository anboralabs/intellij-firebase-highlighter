package co.anbora.labs.firebase.ide.formatter

import co.anbora.labs.firebase.ide.formatter.impl.*
import co.anbora.labs.firebase.lang.core.psi.FirebaseRulesTypes.*
import com.intellij.formatting.*
import com.intellij.lang.ASTNode
import com.intellij.psi.formatter.common.AbstractBlock

class FirebaseFormatterBlock(
    node: ASTNode,
    wrap: Wrap? = null,
    alignment: Alignment? = null,
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
            FUNCTION_PARAMETER_LIST -> Alignment.createAlignment()
            FUNCTION_PARAMETER -> ctx.sharedAlignment
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

    override fun getChildAttributes(newChildIndex: Int): ChildAttributes {
        val indent = when {
            node.elementType == CONDITIONAL_BLOCK -> Indent.getNoneIndent()
            node.isDelimitedBlock -> Indent.getNormalIndent()
            // Otherwise we don't want any indentation (null means continuation indent)
            else -> Indent.getNoneIndent()
        }
        return ChildAttributes(indent, null)
    }

}
