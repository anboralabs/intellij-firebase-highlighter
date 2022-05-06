package co.anbora.labs.firebase.ide.highlight

import co.anbora.labs.firebase.ide.color.FirebaseColors
import co.anbora.labs.firebase.lang.core.FIREBASE_COMMENTS
import co.anbora.labs.firebase.lang.core.KEYWORDS
import co.anbora.labs.firebase.lang.core.RULES_PERMISSIONS
import co.anbora.labs.firebase.lang.core.lexer.FirebaseLexer
import co.anbora.labs.firebase.lang.core.psi.FireRulesTypes.*
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
                    in KEYWORDS, BOOL_LITERAL -> FirebaseColors.KEY_WORD
                    SEMICOLON -> FirebaseColors.SEMICOLON
                    DOT -> FirebaseColors.DOT
                    COMMA -> FirebaseColors.COMMA
                    PATH_VARIABLE_LITERAL -> FirebaseColors.PATH_VARIABLE
                    PATH_BUILT_IN_LITERAL -> FirebaseColors.PATH_BUILT_IN
                    STRING_LITERAL -> FirebaseColors.STRINGS
                    in FIREBASE_COMMENTS -> FirebaseColors.COMMENTS
                    CALL_EXPR -> FirebaseColors.CALL_FUNCTION
                    NUMBER_LITERAL -> FirebaseColors.NUMBERS
                    SERVICE_NAME -> FirebaseColors.SERVICE_NAME
                    TokenType.BAD_CHARACTER -> FirebaseColors.BAD_CHAR
                    else -> null
                }
    }
}
