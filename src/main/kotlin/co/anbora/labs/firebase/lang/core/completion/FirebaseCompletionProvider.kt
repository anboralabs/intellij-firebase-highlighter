package co.anbora.labs.firebase.lang.core.completion

import com.intellij.codeInsight.completion.CompletionParameters
import com.intellij.codeInsight.completion.CompletionProvider
import com.intellij.codeInsight.completion.CompletionResultSet
import com.intellij.util.ProcessingContext

interface Suggestor {
    fun addCompletions(parameters: CompletionParameters, result: CompletionResultSet)
}

class FirebaseCompletionProvider: CompletionProvider<CompletionParameters>() {

    val suggestors = listOf(FirebaseKeywordSuggestions)

    override fun addCompletions(parameters: CompletionParameters, context: ProcessingContext, result: CompletionResultSet) {
        suggestors.forEach { it.addCompletions(parameters, result) }
    }
}