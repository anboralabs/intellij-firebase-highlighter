package co.anbora.labs.firebase.ide.compatibility

import com.intellij.formatting.FormattingContext
import com.intellij.formatting.FormattingMode
import com.intellij.formatting.FormattingModel
import com.intellij.openapi.util.TextRange
import com.intellij.psi.PsiElement
import com.intellij.psi.codeStyle.CodeStyleSettings

interface FormattingModelBuilderCompat {

    fun createModel(formattingContext: FormattingContext): FormattingModel {
        return createModel(
            formattingContext.psiElement,
            formattingContext.formattingRange,
            formattingContext.codeStyleSettings,
            formattingContext.formattingMode
        )
    }

    fun createModel(
        element: PsiElement,
        range: TextRange,
        settings: CodeStyleSettings,
        mode: FormattingMode
    ): FormattingModel = createModel(element, settings, mode) // just for compatibility with old implementations

    fun createModel(
        element: PsiElement,
        settings: CodeStyleSettings,
        mode: FormattingMode
    ): FormattingModel = createModel(element, settings)

    fun createModel(
        element: PsiElement?,
        settings: CodeStyleSettings?
    ): FormattingModel = createModel(FormattingContext.create(element!!, settings!!))

}
