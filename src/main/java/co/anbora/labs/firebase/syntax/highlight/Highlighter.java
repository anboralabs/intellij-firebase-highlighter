package co.anbora.labs.firebase.syntax.highlight;

import co.anbora.labs.firebase.syntax.FirebaseRulesAdapter;
import co.anbora.labs.firebase.syntax.psi.FirebaseRulesTypes;
import com.intellij.lexer.Lexer;
import com.intellij.openapi.editor.DefaultLanguageHighlighterColors;
import com.intellij.openapi.editor.colors.TextAttributesKey;
import com.intellij.openapi.fileTypes.SyntaxHighlighterBase;
import com.intellij.psi.tree.IElementType;
import org.jetbrains.annotations.NotNull;

import static com.intellij.openapi.editor.colors.TextAttributesKey.createTextAttributesKey;

public class Highlighter extends SyntaxHighlighterBase {

    public static final TextAttributesKey KEY =
            createTextAttributesKey("FIREBASE_KEYWORD", DefaultLanguageHighlighterColors.KEYWORD);

    public static final TextAttributesKey PERMISSION =
            createTextAttributesKey("FIREBASE_PERMISSIONS", DefaultLanguageHighlighterColors.CONSTANT);

    public static final TextAttributesKey PATH =
            createTextAttributesKey("FIREBASE_PATH", DefaultLanguageHighlighterColors.STRING);

    public static final TextAttributesKey COMMENT =
            createTextAttributesKey("COMMENT", DefaultLanguageHighlighterColors.LINE_COMMENT);

    public static final TextAttributesKey CALL_FUNCTION =
            createTextAttributesKey("CALL_FUNCTION", DefaultLanguageHighlighterColors.FUNCTION_CALL);

    public static final TextAttributesKey NUMBER =
            createTextAttributesKey("NUMBER", DefaultLanguageHighlighterColors.NUMBER);

    private static final TextAttributesKey[] KEYWORDS_KEYS = new TextAttributesKey[]{KEY};
    private static final TextAttributesKey[] PERMISSION_KEYS = new TextAttributesKey[]{PERMISSION};
    private static final TextAttributesKey[] PATH_KEYS = new TextAttributesKey[]{PATH};
    private static final TextAttributesKey[] COMMENT_KEYS = new TextAttributesKey[]{COMMENT};
    private static final TextAttributesKey[] CALL_FUNCTION_KEYS = new TextAttributesKey[]{CALL_FUNCTION};
    private static final TextAttributesKey[] NUMBER_KEYS = new TextAttributesKey[]{NUMBER};
    private static final TextAttributesKey[] EMPTY_KEYS = new TextAttributesKey[0];

    @Override
    public @NotNull Lexer getHighlightingLexer() {
        return new FirebaseRulesAdapter();
    }

    @Override
    public @NotNull TextAttributesKey[] getTokenHighlights(IElementType tokenType) {
        if (tokenType.equals(FirebaseRulesTypes.SERVICE_KEYWORD)
                || tokenType.equals(FirebaseRulesTypes.MATCH_KEYWORD)
                || tokenType.equals(FirebaseRulesTypes.ALLOW_KEYWORD)
                || tokenType.equals(FirebaseRulesTypes.TRUE_KEYWORD)
                || tokenType.equals(FirebaseRulesTypes.FALSE_KEYWORD)
                || tokenType.equals(FirebaseRulesTypes.NULL_KEYWORD)
                || tokenType.equals(FirebaseRulesTypes.IF_KEYWORD)
                || tokenType.equals(FirebaseRulesTypes.FUNCTION_KEYWORD)
                || tokenType.equals(FirebaseRulesTypes.RETURN_KEYWORD)
                || tokenType.equals(FirebaseRulesTypes.IN_KEYWORD)) {
            return KEYWORDS_KEYS;
        } else if (tokenType.equals(FirebaseRulesTypes.PERMISSION)) {
            return PERMISSION_KEYS;
        } else if (tokenType.equals(FirebaseRulesTypes.PATH_VARIABLE)
                || tokenType.equals(FirebaseRulesTypes.STRING)) {
            return PATH_KEYS;
        } else if (tokenType.equals(FirebaseRulesTypes.LINE_COMMENT)) {
            return COMMENT_KEYS;
        } else if (tokenType.equals(FirebaseRulesTypes.CALL_FUNCTION_STATEMENT)) {
            return CALL_FUNCTION_KEYS;
        } else if (tokenType.equals(FirebaseRulesTypes.NUMBER)) {
            return NUMBER_KEYS;
        }
        return EMPTY_KEYS;
    }
}
