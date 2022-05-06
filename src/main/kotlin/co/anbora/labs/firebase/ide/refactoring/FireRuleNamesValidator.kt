package co.anbora.labs.firebase.ide.refactoring

import co.anbora.labs.firebase.lang.core.KEYWORDS
import co.anbora.labs.firebase.lang.core.lexer.createFireRulesLexer
import co.anbora.labs.firebase.lang.core.psi.FireRulesTypes.IDENTIFIER
import com.intellij.lang.refactoring.NamesValidator
import com.intellij.openapi.project.Project
import com.intellij.psi.tree.IElementType

class FireNamesValidator : NamesValidator {
    override fun isKeyword(name: String, project: Project?): Boolean {
        return getLexerType(name) in KEYWORDS
    }

    override fun isIdentifier(name: String, project: Project?): Boolean = isIdentifier(name)

    companion object {
        fun isIdentifier(name: String): Boolean = when (getLexerType(name)) {
            IDENTIFIER -> true
            else -> false
        }
    }
}

fun isValidFireRuleVariableIdentifier(name: String): Boolean = getLexerType(name) == IDENTIFIER

private fun getLexerType(text: String): IElementType? {
    val lexer = createFireRulesLexer()
    lexer.start(text)
    return if (lexer.tokenEnd == text.length) lexer.tokenType else null
}
