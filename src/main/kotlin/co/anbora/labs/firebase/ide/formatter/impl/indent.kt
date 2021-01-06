package co.anbora.labs.firebase.ide.formatter.impl

import co.anbora.labs.firebase.ide.formatter.FirebaseFormatterBlock
import com.intellij.formatting.Indent
import com.intellij.lang.ASTNode

fun FirebaseFormatterBlock.computeIndent(child: ASTNode): Indent? {
    val parent = child.treeParent
    return when {

        parent?.treeParent == null -> Indent.getNoneIndent()

        child.isBetweenBraces() -> Indent.getNormalIndent()

        else -> Indent.getNoneIndent()
    }
}
