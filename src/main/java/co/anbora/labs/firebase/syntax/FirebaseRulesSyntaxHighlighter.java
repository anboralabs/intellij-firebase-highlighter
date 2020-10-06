package co.anbora.labs.firebase.syntax;

import co.anbora.labs.firebase.syntax.psi.FirebaseRulesTypes;
import com.intellij.lexer.Lexer;
import com.intellij.openapi.editor.DefaultLanguageHighlighterColors;
import com.intellij.openapi.editor.colors.TextAttributesKey;
import com.intellij.openapi.fileTypes.SyntaxHighlighterBase;
import com.intellij.psi.tree.IElementType;
import org.jetbrains.annotations.NotNull;

import static com.intellij.openapi.editor.colors.TextAttributesKey.createTextAttributesKey;

public class FirebaseRulesSyntaxHighlighter extends SyntaxHighlighterBase {

    public static final TextAttributesKey KEY =
            createTextAttributesKey("FIREBASE_KEY_WORD", DefaultLanguageHighlighterColors.KEYWORD);

    private static final TextAttributesKey[] KEYWORDS_KEYS = new TextAttributesKey[]{KEY};
    private static final TextAttributesKey[] EMPTY_KEYS = new TextAttributesKey[0];

    @Override
    public @NotNull Lexer getHighlightingLexer() {
        return new FirebaseRulesAdapter();
    }

    @Override
    public @NotNull TextAttributesKey[] getTokenHighlights(IElementType tokenType) {
        if (tokenType.equals(FirebaseRulesTypes.SERVICE)
                || tokenType.equals(FirebaseRulesTypes.MATCH)
                || tokenType.equals(FirebaseRulesTypes.ALLOW)) {
            return KEYWORDS_KEYS;
        }
        return EMPTY_KEYS;
    }
}
