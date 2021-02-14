package co.anbora.labs.firebase.lang.core.completion

import co.anbora.labs.firebase.lang.core.psi.FirebaseRulesTypes.SERVICE_NAME
import com.intellij.codeInsight.completion.CompletionContributor
import com.intellij.codeInsight.completion.CompletionParameters
import com.intellij.codeInsight.completion.CompletionProvider
import com.intellij.codeInsight.completion.CompletionResultSet
import com.intellij.codeInsight.completion.CompletionType.BASIC
import com.intellij.codeInsight.lookup.LookupElementBuilder
import com.intellij.patterns.PlatformPatterns
import com.intellij.util.ProcessingContext

private val serviceNameCompletion = arrayOf("cloud.firestore", "firebase.storage")

class BasicCompletionContributor: CompletionContributor() {

    init {
        extend(
            BASIC,
            PlatformPatterns.psiElement(SERVICE_NAME),
            BasicCompletionProvider(serviceNameCompletion)
        )
    }

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