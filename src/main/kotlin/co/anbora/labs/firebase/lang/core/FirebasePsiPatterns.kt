package co.anbora.labs.firebase.lang.core

import co.anbora.labs.firebase.lang.core.psi.*
import com.intellij.patterns.PatternCondition
import com.intellij.patterns.PlatformPatterns
import com.intellij.patterns.PsiElementPattern
import com.intellij.patterns.StandardPatterns
import com.intellij.psi.PsiComment
import com.intellij.psi.PsiElement
import com.intellij.psi.PsiErrorElement
import com.intellij.psi.PsiWhiteSpace
import com.intellij.psi.util.PsiTreeUtil
import com.intellij.util.ProcessingContext

object FirebasePsiPatterns {

    fun onStatementBeginning(vararg startWords: String): PsiElementPattern.Capture<PsiElement> =
            PlatformPatterns.psiElement().with(OnStatementBeginning(*startWords))

    fun toplevel(): PsiElementPattern.Capture<PsiElement> =
            psiElementWithParent<FirebaseFile>()

    fun serviceStatement(): PsiElementPattern.Capture<PsiElement> =
            psiElementWithParent<FirebaseRulesServiceDef>()

    fun pathStatement(): PsiElementPattern.Capture<PsiElement> =
            psiElementWithParent<FirebaseRulesPathStatement>()

    fun permissionStatement(): PsiElementPattern.Capture<PsiElement> =
            psiElementWithParent<FirebaseRulesPermissionStatement>()

    fun allowStatement(): PsiElementPattern.Capture<PsiElement> =
            psiElementWithParent<FirebaseRulesAllowStatement>()

    inline fun <reified I : PsiElement> psiElementWithParent() =
        PlatformPatterns.psiElement().withParent(
            StandardPatterns.or(
                psiElement<I>(),
                psiElement<PsiErrorElement>().withParent(psiElement<I>())
            )
        )

    inline fun <reified I : PsiElement> psiElementWithAncestor() =
            PlatformPatterns.psiElement().withAncestor(0,
                    StandardPatterns.or(
                            psiElement<I>(),
                            psiElement<PsiErrorElement>().withAncestor(0, psiElement<I>())
                    )
            )

    inline fun <reified I : PsiElement> psiElementInside() =
            PlatformPatterns.psiElement().inside(
                    StandardPatterns.or(
                            psiElement<I>(),
                            psiElement<PsiErrorElement>().withParent(psiElement<I>())
                    )
            )


    private class OnStatementBeginning(vararg startWords: String) :
            PatternCondition<PsiElement>("on statement beginning") {
        val myStartWords = startWords
        override fun accepts(t: PsiElement, context: ProcessingContext?): Boolean {
            val prev = t.prevVisibleOrNewLine
            return if (myStartWords.isEmpty())
                prev == null || prev is PsiWhiteSpace
            else {
                prev != null && prev.node.text in myStartWords
            }
        }
    }
}

val PsiElement.leftLeaves: Sequence<PsiElement>
    get() {
        return generateSequence(this, PsiTreeUtil::prevLeaf).drop(1)
    }

private val PsiElement.prevVisibleOrNewLine: PsiElement?
    get() {
        return leftLeaves
                .filterNot { it is PsiComment || it is PsiErrorElement }
                .filter { it !is PsiWhiteSpace || it.textContains('\n') }
                .firstOrNull()

    }

inline fun <reified I : PsiElement> psiElement(): PsiElementPattern.Capture<I> {
    return PlatformPatterns.psiElement(I::class.java)
}