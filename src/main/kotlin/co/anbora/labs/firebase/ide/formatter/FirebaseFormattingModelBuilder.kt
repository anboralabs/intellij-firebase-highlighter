package co.anbora.labs.firebase.ide.formatter

import com.intellij.formatting.*

class FirebaseFormattingModelBuilder: FormattingModelBuilderCompat() {

    override fun createModel(formattingContext: FormattingContext): FormattingModel {
        return FormattingModelProvider.createFormattingModelForPsiFile(
            formattingContext.containingFile,
            FirebaseFormatterBlock(
                node = formattingContext.node,
                spacingBuilder = createSpacingBuilder(formattingContext.codeStyleSettings)
            ),
            formattingContext.codeStyleSettings
        )
    }
}