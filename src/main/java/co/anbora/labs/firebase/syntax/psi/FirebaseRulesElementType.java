package co.anbora.labs.firebase.syntax.psi;

import co.anbora.labs.firebase.syntax.language.FirebaseRulesLanguage;
import com.intellij.psi.tree.IElementType;
import org.jetbrains.annotations.NotNull;

public class FirebaseRulesElementType extends IElementType {
    public FirebaseRulesElementType(@NotNull String debugName) {
        super(debugName, FirebaseRulesLanguage.INSTANCE);
    }
}
