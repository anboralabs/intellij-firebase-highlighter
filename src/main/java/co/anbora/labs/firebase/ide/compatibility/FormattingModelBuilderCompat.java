package co.anbora.labs.firebase.ide.compatibility;

import com.intellij.formatting.FormattingContext;
import com.intellij.formatting.FormattingMode;
import com.intellij.formatting.FormattingModel;
import com.intellij.openapi.util.TextRange;
import com.intellij.psi.PsiElement;
import com.intellij.psi.codeStyle.CodeStyleSettings;
import org.jetbrains.annotations.NotNull;

public interface FormattingModelBuilderCompat {

    default @NotNull FormattingModel createModel(@NotNull FormattingContext formattingContext) {
        return createModel(formattingContext.getPsiElement(),
                formattingContext.getFormattingRange(),
                formattingContext.getCodeStyleSettings(),
                formattingContext.getFormattingMode());
    }

    default @NotNull FormattingModel createModel(final @NotNull PsiElement element,
                                                 final @NotNull TextRange range,
                                                 final @NotNull CodeStyleSettings settings,
                                                 final @NotNull FormattingMode mode) {
        return createModel(element, settings, mode); // just for compatibility with old implementations
    }

    default @NotNull FormattingModel createModel(final @NotNull PsiElement element,
                                                 final @NotNull CodeStyleSettings settings,
                                                 @NotNull FormattingMode mode) {
        return createModel(element, settings);
    }

    default @NotNull FormattingModel createModel(final PsiElement element, final CodeStyleSettings settings) {
        return createModel(FormattingContext.create(element, settings));
    }
}
