package co.anbora.labs.firebase.ide.typing

import co.anbora.labs.firebase.lang.core.psi.FireRulesTypes.*
import com.intellij.lang.BracePair
import com.intellij.lang.PairedBraceMatcher
import com.intellij.psi.PsiFile
import com.intellij.psi.tree.IElementType

private val bracePairs = arrayOf(
    BracePair(L_PAREN, R_PAREN, true),
    BracePair(L_BRACK, R_BRACK, false),
    BracePair(L_BRACE, R_BRACE, true))

class FirebasePairedBraceMatcher: PairedBraceMatcher {
    override fun getPairs(): Array<BracePair> = bracePairs

    override fun isPairedBracesAllowedBeforeType(
        lbraceType: IElementType,
        contextType: IElementType?
    ): Boolean = true

    override fun getCodeConstructStart(
        file: PsiFile?,
        openingBraceOffset: Int
    ): Int = openingBraceOffset

}
