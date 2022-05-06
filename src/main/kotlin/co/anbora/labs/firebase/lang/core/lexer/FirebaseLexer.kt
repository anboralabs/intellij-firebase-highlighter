package co.anbora.labs.firebase.lang.core.lexer

import com.intellij.lexer.FlexAdapter
import co.anbora.labs.firebase.lang.FirebaseRulesLexer

fun createFireRulesLexer(): FirebaseLexer {
    return FirebaseLexer()
}

class FirebaseLexer: FlexAdapter(FirebaseRulesLexer())
