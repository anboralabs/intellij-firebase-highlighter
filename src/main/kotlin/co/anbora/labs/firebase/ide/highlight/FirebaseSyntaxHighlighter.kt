package co.anbora.labs.firebase.ide.highlight

import co.anbora.labs.firebase.ide.color.FirebaseColors
import co.anbora.labs.firebase.lang.core.lexer.FirebaseLexer
import co.anbora.labs.firebase.lang.core.psi.FirebaseRulesTypes.*
import com.intellij.lexer.Lexer
import com.intellij.openapi.editor.colors.TextAttributesKey
import com.intellij.openapi.fileTypes.SyntaxHighlighterBase
import com.intellij.psi.TokenType
import com.intellij.psi.tree.IElementType

class FirebaseSyntaxHighlighter: SyntaxHighlighterBase() {
    override fun getHighlightingLexer(): Lexer = FirebaseLexer()

    override fun getTokenHighlights(tokenType: IElementType?): Array<TextAttributesKey> =
            pack(map(tokenType)?.textAttributesKey)

    companion object {
        fun map(tokenType: IElementType?): FirebaseColors? =
                when (tokenType) {
                    RULES_VERSION, DOT_COMMA, SERVICE_KEYWORD, MATCH_KEYWORD, ALLOW_KEYWORD,
                        TRUE_KEYWORD, FALSE_KEYWORD, NULL_KEYWORD,
                        IF_KEYWORD, FUNCTION_KEYWORD, RETURN_KEYWORD,
                        IN_KEYWORD, LET_KEYWORD, IS_KEYWORD -> FirebaseColors.KEY_WORD
                    GET_KEYWORD, READ_KEYWORD, WRITE_KEYWORD,
                        LIST_KEYWORD, CREATE_KEYWORD, UPDATE_KEYWORD,
                        DELETE_KEYWORD, EXITS_KEYWORD -> FirebaseColors.PERMISSIONS
                    PATH_VARIABLE, PATH_BUILT_IN, STRING, VERSIONS -> FirebaseColors.PATH_AND_STRING
                    LINE_COMMENT, BLOCK_COMMENT -> FirebaseColors.COMMENTS
                    CALL_EXPR -> FirebaseColors.CALL_FUNCTION
                    NUMBER -> FirebaseColors.NUMBERS
                    SERVICE_NAME -> FirebaseColors.NUMBERS
                    TokenType.BAD_CHARACTER -> FirebaseColors.BAD_CHAR
                    else -> null
                }
    }
}
