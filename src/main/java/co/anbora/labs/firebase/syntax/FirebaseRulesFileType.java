package co.anbora.labs.firebase.syntax;

import com.intellij.lang.Language;
import com.intellij.openapi.fileTypes.LanguageFileType;
import com.intellij.openapi.util.NlsContexts;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import javax.swing.*;

public class FirebaseRulesFileType extends LanguageFileType {

    public static final FirebaseRulesFileType INSTANCE = new FirebaseRulesFileType();

    protected FirebaseRulesFileType() {
        super(FirebaseRulesLanguage.INSTANCE);
    }

    @Override
    public @NotNull String getName() {
        return "Firebase Rule File";
    }

    @Override
    public @NotNull @NlsContexts.Label String getDescription() {
        return "Firebase rules configurations";
    }

    @Override
    public @NotNull String getDefaultExtension() {
        return "rules";
    }

    @Override
    public @Nullable Icon getIcon() {
        return FirebaseRulesIcons.FILE;
    }
}
