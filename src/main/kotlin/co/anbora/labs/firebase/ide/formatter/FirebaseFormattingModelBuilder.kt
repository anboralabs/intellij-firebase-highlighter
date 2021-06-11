@file:Suppress("UnstableApiUsage")

package co.anbora.labs.firebase.ide.formatter

import com.intellij.formatting.FormattingModel
import com.intellij.formatting.FormattingModelBuilder
import com.intellij.formatting.FormattingModelProvider
import com.intellij.formatting.Indent
import com.intellij.psi.PsiElement
import com.intellij.psi.codeStyle.CodeStyleSettings

class FirebaseFormattingModelBuilder: FormattingModelBuilder {

    override fun createModel(element: PsiElement?, settings: CodeStyleSettings): FormattingModel {
        val ctx = FirebaseFmtContext.create(settings)
        return FormattingModelProvider.createFormattingModelForPsiFile(
                element!!.containingFile,
                FirebaseFormatterBlock(element.node, null, null, Indent.getNoneIndent(), ctx),
                settings
        )
    }
}
