package co.anbora.labs.firebase.ide.formatter

import com.intellij.formatting.*

class FirebaseFormattingModelBuilder: FormattingModelBuilder {

    override fun createModel(formattingContext: FormattingContext): FormattingModel {
        val ctx = FirebaseFmtContext.create(formattingContext.codeStyleSettings)
        return FormattingModelProvider.createFormattingModelForPsiFile(
            formattingContext.containingFile,
            FirebaseFormatterBlock(formattingContext.node, null, null, Indent.getNoneIndent(), ctx),
            formattingContext.codeStyleSettings
        )
    }
}