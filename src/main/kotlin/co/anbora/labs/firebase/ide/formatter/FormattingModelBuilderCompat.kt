@file:Suppress("UnstableApiUsage")

package co.anbora.labs.firebase.ide.formatter

import co.anbora.labs.firebase.ide.compatibility.FormattingModelBuilderCompat
import com.intellij.formatting.FormattingContext
import com.intellij.formatting.FormattingMode
import com.intellij.formatting.FormattingModel
import com.intellij.formatting.FormattingModelBuilder
import com.intellij.openapi.util.TextRange
import com.intellij.psi.PsiElement
import com.intellij.psi.codeStyle.CodeStyleSettings

open class FormattingModelBuilderCompat: FormattingModelBuilderCompat, FormattingModelBuilder {

    override fun createModel(formattingContext: FormattingContext): FormattingModel {
        return createModel(
            formattingContext.psiElement,
            formattingContext.formattingRange,
            formattingContext.codeStyleSettings,
            formattingContext.formattingMode
        )
    }

    override fun createModel(
        element: PsiElement,
        range: TextRange,
        settings: CodeStyleSettings,
        mode: FormattingMode
    ): FormattingModel = createModel(element, settings, mode) // just for compatibility with old implementations

    override fun createModel(
        element: PsiElement,
        settings: CodeStyleSettings,
        mode: FormattingMode
    ): FormattingModel = createModel(element, settings)

    override fun createModel(
        element: PsiElement?,
        settings: CodeStyleSettings?
    ): FormattingModel = createModel(FormattingContext.create(element!!, settings!!))

}