/*
 * Use of this source code is governed by the MIT license that can be
 * found in the LICENSE file.
 */

package co.anbora.labs.firebase.ide.formatter

import com.intellij.formatting.Alignment
import com.intellij.lang.ASTNode
import com.intellij.psi.tree.IElementType
import com.intellij.psi.tree.TokenSet

interface FirebaseAlignmentStrategy {
    /**
     * Requests current strategy for alignment to use for given child.
     */
    fun getAlignment(child: ASTNode, parent: ASTNode?, childCtx: FirebaseFmtContext): Alignment?

    /**
     * Always returns `null`.
     */
    object NullStrategy : FirebaseAlignmentStrategy {
        override fun getAlignment(child: ASTNode, parent: ASTNode?, childCtx: FirebaseFmtContext): Alignment? = null
    }

    /**
     * Apply this strategy only when child element is in [tt].
     */
    fun alignIf(vararg tt: IElementType): FirebaseAlignmentStrategy = alignIf(TokenSet.create(*tt))

    /**
     * Apply this strategy only when child element type matches [filterSet].
     */
    fun alignIf(filterSet: TokenSet): FirebaseAlignmentStrategy =
        object : FirebaseAlignmentStrategy {
            override fun getAlignment(child: ASTNode, parent: ASTNode?, childCtx: FirebaseFmtContext): Alignment? =
                if (child.elementType in filterSet) {
                    this@FirebaseAlignmentStrategy.getAlignment(child, parent, childCtx)
                } else {
                    null
                }
        }

    /**
     * Apply this strategy only when [predicate] passes.
     */
    fun alignIf(predicate: (child: ASTNode, parent: ASTNode?, ctx: FirebaseFmtContext) -> Boolean): FirebaseAlignmentStrategy =
        object : FirebaseAlignmentStrategy {
            override fun getAlignment(child: ASTNode, parent: ASTNode?, childCtx: FirebaseFmtContext): Alignment? =
                if (predicate(child, parent, childCtx)) {
                    this@FirebaseAlignmentStrategy.getAlignment(child, parent, childCtx)
                } else {
                    null
                }
        }

    /**
     * Returns [NullStrategy] if [condition] is `false`. Useful for making strategies configurable.
     */
    fun alignIf(condition: Boolean): FirebaseAlignmentStrategy =
        if (condition) {
            this
        } else {
            NullStrategy
        }

    companion object {
        /**
         * Always returns [alignment].
         */
        fun wrap(alignment: Alignment = Alignment.createAlignment()): FirebaseAlignmentStrategy =
            object : FirebaseAlignmentStrategy {
                override fun getAlignment(child: ASTNode, parent: ASTNode?, childCtx: FirebaseFmtContext): Alignment? =
                    alignment
            }

        /**
         * Always returns [MoveFmtContext.sharedAlignment]
         */
        fun shared(): FirebaseAlignmentStrategy =
            object : FirebaseAlignmentStrategy {
                override fun getAlignment(child: ASTNode, parent: ASTNode?, childCtx: FirebaseFmtContext): Alignment? =
                    childCtx.sharedAlignment
            }
    }
}
