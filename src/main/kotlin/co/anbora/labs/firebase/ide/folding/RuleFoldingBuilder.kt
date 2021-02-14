package co.anbora.labs.firebase.ide.folding

import co.anbora.labs.firebase.lang.core.psi.FirebaseRulesFunctionBlock
import co.anbora.labs.firebase.lang.core.psi.FirebaseRulesMatchBlock
import co.anbora.labs.firebase.lang.core.psi.FirebaseRulesServiceBlock
import co.anbora.labs.firebase.lang.core.psi.FirebaseRulesVisitor
import com.intellij.lang.ASTNode
import com.intellij.lang.folding.FoldingBuilderEx
import com.intellij.lang.folding.FoldingDescriptor
import com.intellij.openapi.editor.Document
import com.intellij.openapi.project.DumbAware
import com.intellij.psi.PsiElement
import com.intellij.psi.util.PsiTreeUtil

private const val BLOCK_PLACE_HOLDER = "{...}"

class RuleFoldingBuilder: FoldingBuilderEx(), DumbAware {

    override fun buildFoldRegions(root: PsiElement, document: Document, quick: Boolean): Array<FoldingDescriptor> {
        val descriptors = mutableListOf<FoldingDescriptor>()
        val visitor = FoldingVisitor(descriptors)
        PsiTreeUtil.processElements(root) { it.accept(visitor); true }
        return descriptors.toTypedArray()
    }

    override fun getPlaceholderText(node: ASTNode): String? =
        when (node.psi) {
            is FirebaseRulesServiceBlock -> BLOCK_PLACE_HOLDER
            is FirebaseRulesMatchBlock -> BLOCK_PLACE_HOLDER
            is FirebaseRulesFunctionBlock -> BLOCK_PLACE_HOLDER
            else -> null
        }

    override fun isCollapsedByDefault(node: ASTNode): Boolean = false

    private class FoldingVisitor(private val descriptors: MutableList<FoldingDescriptor>) : FirebaseRulesVisitor() {

        override fun visitMatchBlock(o: FirebaseRulesMatchBlock) = fold(o)

        override fun visitServiceBlock(o: FirebaseRulesServiceBlock) = fold(o)

        override fun visitFunctionBlock(o: FirebaseRulesFunctionBlock) = fold(o)

        private fun fold(element: PsiElement) {
            descriptors += FoldingDescriptor(element.node, element.textRange)
        }
    }

}
