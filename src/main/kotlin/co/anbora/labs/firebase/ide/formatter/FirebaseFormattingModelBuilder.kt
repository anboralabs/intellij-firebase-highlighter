package co.anbora.labs.firebase.ide.formatter

import com.intellij.formatting.*

class FirebaseFormattingModelBuilder: FormattingModelBuilder {

    override fun createModel(formattingContext: FormattingContext): FormattingModel {
        return FormattingModelProvider.createFormattingModelForPsiFile(
            formattingContext.containingFile,
            FirebaseFormatterBlock(formattingContext.node, null, null),
            formattingContext.codeStyleSettings
        )
    }
}