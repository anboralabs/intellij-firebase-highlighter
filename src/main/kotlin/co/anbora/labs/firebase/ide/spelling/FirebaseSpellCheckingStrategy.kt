package co.anbora.labs.firebase.ide.spelling

import co.anbora.labs.firebase.lang.FirebaseRulesLanguage
import co.anbora.labs.firebase.lang.core.psi.FireRulesTypes
import com.intellij.psi.PsiElement
import com.intellij.psi.util.elementType
import com.intellij.spellchecker.inspections.PlainTextSplitter
import com.intellij.spellchecker.tokenizer.SpellcheckingStrategy
import com.intellij.spellchecker.tokenizer.Tokenizer
import com.intellij.spellchecker.tokenizer.TokenizerBase

class FirebaseSpellCheckingStrategy: SpellcheckingStrategy() {

    override fun getTokenizer(element: PsiElement?): Tokenizer<*> =
            when (element?.elementType) {
                FireRulesTypes.STRING -> FIREBASE_STRING_TOKENIZER
                else -> super.getTokenizer(element)
            }

    override fun isMyContext(element: PsiElement): Boolean =
            element.language.`is`(FirebaseRulesLanguage)
}

val FIREBASE_STRING_TOKENIZER =
        TokenizerBase<PsiElement>(PlainTextSplitter.getInstance())
