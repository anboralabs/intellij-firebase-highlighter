package co.anbora.labs.firebase.syntax;

import com.intellij.lexer.FlexAdapter;

public class FirebaseRulesAdapter extends FlexAdapter {
    public FirebaseRulesAdapter() {
        super(new FirebaseRulesLexer(null));
    }
}
