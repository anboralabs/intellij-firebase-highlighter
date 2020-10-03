package co.anbora.labs.firebase.syntax.psi;

import co.anbora.labs.firebase.syntax.FirebaseRulesFileType;
import co.anbora.labs.firebase.syntax.FirebaseRulesLanguage;
import com.intellij.extapi.psi.PsiFileBase;
import com.intellij.openapi.fileTypes.FileType;
import com.intellij.psi.FileViewProvider;
import org.jetbrains.annotations.NotNull;

public class FirebaseRulesFile extends PsiFileBase {
    public FirebaseRulesFile(@NotNull FileViewProvider viewProvider) {
        super(viewProvider, FirebaseRulesLanguage.INSTANCE);
    }

    @Override
    public @NotNull FileType getFileType() {
        return FirebaseRulesFileType.INSTANCE;
    }

    @Override
    public String toString() {
        return "Firebase rule file";
    }
}
