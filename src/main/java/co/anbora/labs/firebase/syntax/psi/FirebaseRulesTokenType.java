package co.anbora.labs.firebase.syntax.psi;

import co.anbora.labs.firebase.syntax.language.FirebaseRulesLanguage;
import com.intellij.psi.tree.IElementType;
import org.jetbrains.annotations.NotNull;

public class FirebaseRulesTokenType extends IElementType {
    public FirebaseRulesTokenType(@NotNull String debugName) {
        super(debugName, FirebaseRulesLanguage.INSTANCE);
    }

    @Override
    public String toString() {
        return "FirebaseRulesTokenType." + super.toString();
    }
}
