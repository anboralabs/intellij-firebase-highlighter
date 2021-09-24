package co.anbora.labs.firebase.ide.editor

import co.anbora.labs.firebase.lang.core.psi.FirebaseRulesTypes.STRING
import com.intellij.codeInsight.editorActions.SimpleTokenSetQuoteHandler

class FirebaseQuoteHandler: SimpleTokenSetQuoteHandler(STRING)