package co.anbora.labs.firebase.syntax.language;

import com.intellij.lang.Language;

public class FirebaseRulesLanguage extends Language {

    public static final FirebaseRulesLanguage INSTANCE = new FirebaseRulesLanguage();

    protected FirebaseRulesLanguage() {
        super("firebase_rules");
    }
}
