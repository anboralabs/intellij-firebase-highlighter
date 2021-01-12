// Copyright 2000-2020 JetBrains s.r.o. Use of this source code is governed by the Apache 2.0 license that can be found in the LICENSE file.
package com.intellij.formatting

import com.intellij.psi.PsiElement
import com.intellij.openapi.util.TextRange
import com.intellij.psi.codeStyle.CodeStyleSettings
import com.intellij.formatting.FormattingMode
import com.intellij.lang.ASTNode
import com.intellij.openapi.project.Project
import com.intellij.psi.PsiFile
import java.util.*

/**
 * Represents a context of current formatting operation
 */
class FormattingContext private constructor(
    /**
     * @return element being formatted
     */
    val psiElement: PsiElement,
    /**
     * @return range being formatted. When text is selected in editor, or auto-formatting  performed after some Psi change, returns respective
     * range: selection or psi element. When this is an offset-based formatting, like indentation or spacing computation at offset, returns
     * empty range `(offset,offset)`
     * @apiNote returned range is relative to the containing [file][.getContainingFile], not the [psiElement][.getPsiElement]
     */
    val formattingRange: TextRange,
    val codeStyleSettings: CodeStyleSettings,
    /**
     * @return [type][FormattingMode] of formatting operation performed
     */
    val formattingMode: FormattingMode
) {
    fun withPsiElement(psiElement: PsiElement): FormattingContext {
        // fixme should we overwrite range here?
        return FormattingContext(psiElement, formattingRange, codeStyleSettings, formattingMode)
    }

    val containingFile: PsiFile
        get() = Objects.requireNonNull(psiElement.containingFile)
    val node: ASTNode
        get() = psiElement.node
    val project: Project
        get() = psiElement.project

    override fun toString(): String {
        return "FormattingContext{" +
                "myPsiElement=" + psiElement +
                ", myFormattingRange=" + formattingRange +
                ", myCodeStyleSettings=" + codeStyleSettings +
                ", myFormattingMode=" + formattingMode +
                '}'
    }

    companion object {
        fun create(
            psiElement: PsiElement,
            formattingRange: TextRange,
            codeStyleSettings: CodeStyleSettings,
            formattingMode: FormattingMode
        ): FormattingContext {
            return FormattingContext(psiElement, formattingRange, codeStyleSettings, formattingMode)
        }

        /**
         * @return formatting context for the full-range of `psiElement`
         */
        fun create(
            psiElement: PsiElement,
            codeStyleSettings: CodeStyleSettings,
            formattingMode: FormattingMode
        ): FormattingContext {
            return FormattingContext(psiElement, psiElement.textRange, codeStyleSettings, formattingMode)
        }

        /**
         * @return formatting context for [re-formatting][FormattingMode.REFORMAT] of the full range of `psiElement`
         */
        fun create(
            psiElement: PsiElement,
            codeStyleSettings: CodeStyleSettings
        ): FormattingContext {
            return FormattingContext(psiElement, psiElement.textRange, codeStyleSettings, FormattingMode.REFORMAT)
        }
    }
}
