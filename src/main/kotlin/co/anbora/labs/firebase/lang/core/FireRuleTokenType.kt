package co.anbora.labs.firebase.lang.core

import co.anbora.labs.firebase.lang.FirebaseRulesLanguage
import co.anbora.labs.firebase.lang.FirebaseParserDefinition.Companion.BLOCK_COMMENT
import co.anbora.labs.firebase.lang.FirebaseParserDefinition.Companion.EOL_COMMENT
import co.anbora.labs.firebase.lang.FirebaseParserDefinition.Companion.EOL_DOC_COMMENT
import co.anbora.labs.firebase.lang.core.psi.FireRulesTypes.*
import com.intellij.psi.tree.IElementType
import com.intellij.psi.tree.TokenSet

class FireRuleTokenType(debugName: String) : IElementType(debugName, FirebaseRulesLanguage)

fun tokenSetOf(vararg tokens: IElementType) = TokenSet.create(*tokens)

val KEYWORDS = tokenSetOf(
        RULES_VERSION, REQUEST, RESOURCE, NULL,
        IF, IN, IS,
        LET, RETURN,
        MATCH, SERVICE, FUNCTION, ALLOW
)

val RULES_PERMISSIONS = tokenSetOf(
        CREATE, DELETE, EXITS, GET, READ, UPDATE, WRITE, LIST
)

val TYPES = tokenSetOf(
        BOOL, INT, FLOAT, NUMBER, STRING, LIST, MAP, TIMESTAMP, DURATION, PATH, LATLNG
)

val FIREBASE_COMMENTS = tokenSetOf(BLOCK_COMMENT, EOL_COMMENT, EOL_DOC_COMMENT)
