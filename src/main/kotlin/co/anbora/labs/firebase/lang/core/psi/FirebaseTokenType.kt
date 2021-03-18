package co.anbora.labs.firebase.lang.core.psi

import co.anbora.labs.firebase.lang.FirebaseRulesLanguage
import co.anbora.labs.firebase.lang.core.psi.FirebaseRulesTypes.BLOCK_COMMENT
import co.anbora.labs.firebase.lang.core.psi.FirebaseRulesTypes.LINE_COMMENT
import com.intellij.psi.tree.IElementType
import com.intellij.psi.tree.TokenSet

class FirebaseTokenType(debugName: String) : IElementType(debugName, FirebaseRulesLanguage)

fun tokenSetOf(vararg tokens: IElementType) = TokenSet.create(*tokens)

val FIREBASE_COMMENTS = tokenSetOf(
        LINE_COMMENT,
        BLOCK_COMMENT
)
