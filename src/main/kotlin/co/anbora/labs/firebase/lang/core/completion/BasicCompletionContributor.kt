package co.anbora.labs.firebase.lang.core.completion

import co.anbora.labs.firebase.lang.core.FirebasePsiPatterns
import co.anbora.labs.firebase.lang.core.FirebasePsiPatterns.allowStatement
import co.anbora.labs.firebase.lang.core.FirebasePsiPatterns.matchStatement
import co.anbora.labs.firebase.lang.core.FirebasePsiPatterns.serviceBlock
import co.anbora.labs.firebase.lang.core.FirebasePsiPatterns.serviceStatement
import co.anbora.labs.firebase.lang.core.psi.FirebaseRulesTypes.IDENTIFIER
import com.intellij.codeInsight.completion.CompletionContributor
import com.intellij.codeInsight.completion.CompletionParameters
import com.intellij.codeInsight.completion.CompletionProvider
import com.intellij.codeInsight.completion.CompletionResultSet
import com.intellij.codeInsight.completion.CompletionType.BASIC
import com.intellij.codeInsight.lookup.LookupElementBuilder
import com.intellij.patterns.PlatformPatterns
import com.intellij.patterns.PsiElementPattern
import com.intellij.psi.PsiElement
import com.intellij.util.ProcessingContext

private val serviceNameCompletion = arrayOf("cloud.firestore", "firebase.storage")
private val matchPathCompletion = arrayOf("/", "/databases", "/databases/{database}", "/user", "/user/{userId}")
private val allowPermissionCompletion = arrayOf("get", "read", "write", "list", "create", "update", "delete")

class BasicCompletionContributor: CompletionContributor() {

    init {
        extend(
            BASIC,
            serviceStatement().and(onStatementBeginning("service")),
            BasicCompletionProvider(serviceNameCompletion)
        )

        extend(
            BASIC,
            matchStatement().and(onStatementBeginning("match")),
            BasicCompletionProvider(matchPathCompletion)
        )

        extend(
            BASIC,
            allowStatement(),
            BasicCompletionProvider(allowPermissionCompletion)
        )
    }

    private fun onStatementBeginning(vararg startWords: String): PsiElementPattern.Capture<PsiElement> =
            PlatformPatterns.psiElement(IDENTIFIER).and(FirebasePsiPatterns.onStatementBeginning(*startWords))

}

private class BasicCompletionProvider(keywords: Array<String>): CompletionProvider<CompletionParameters>() {

    private val keywordLookupItems = keywords.map {
        LookupElementBuilder.create(it)
    }

    override fun addCompletions(
        parameters: CompletionParameters,
        context: ProcessingContext,
        result: CompletionResultSet
    ) = result.addAllElements(keywordLookupItems)
}