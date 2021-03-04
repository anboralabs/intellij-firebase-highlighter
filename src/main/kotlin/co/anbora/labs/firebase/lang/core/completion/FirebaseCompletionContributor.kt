package co.anbora.labs.firebase.lang.core.completion

import co.anbora.labs.firebase.lang.FirebaseRulesLanguage
import com.intellij.codeInsight.completion.CompletionContributor
import com.intellij.codeInsight.completion.CompletionType.BASIC
import com.intellij.patterns.PlatformPatterns.psiElement

private val serviceNameCompletion = arrayOf("cloud.firestore", "firebase.storage")
private val matchPathCompletion = arrayOf("/", "/databases", "/databases/{database}", "/user", "/user/{userId}")
private val allowPermissionCompletion = arrayOf("get", "read", "write", "list", "create", "update", "delete")

class FirebaseCompletionContributor: CompletionContributor() {

    init {
        extend(
            BASIC,
            psiElement().withLanguage(FirebaseRulesLanguage),
            FirebaseCompletionProvider()
        )
    }
}