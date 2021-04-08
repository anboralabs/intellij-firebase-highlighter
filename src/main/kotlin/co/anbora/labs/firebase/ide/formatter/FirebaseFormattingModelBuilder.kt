@file:Suppress("UnstableApiUsage")

package co.anbora.labs.firebase.ide.formatter

import com.intellij.formatting.FormattingModel
import com.intellij.formatting.FormattingModelBuilder
import com.intellij.formatting.FormattingModelProvider
import com.intellij.psi.PsiElement
import com.intellij.psi.codeStyle.CodeStyleSettings

class FirebaseFormattingModelBuilder: FormattingModelBuilder {

    /*override fun createModel(formattingContext: FormattingContext): FormattingModel {
        return FormattingModelProvider.createFormattingModelForPsiFile(
            formattingContext.containingFile,
            FirebaseFormatterBlock(
                node = formattingContext.node,
                spacingBuilder = createSpacingBuilder(formattingContext.codeStyleSettings)
            ),
            formattingContext.codeStyleSettings
        )
    }*/

    override fun createModel(element: PsiElement?, settings: CodeStyleSettings): FormattingModel {
        return FormattingModelProvider.createFormattingModelForPsiFile(
                element!!.containingFile,
                FirebaseFormatterBlock(
                        node = element.node,
                        spacingBuilder = createSpacingBuilder(settings)
                ),
                settings
        )
    }
}
