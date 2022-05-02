package co.anbora.labs.firebase.lang.core.psi

import co.anbora.labs.firebase.lang.FirebaseFileType
import co.anbora.labs.firebase.lang.core.psi.ext.descendantOfTypeStrict
import com.intellij.openapi.project.Project
import com.intellij.psi.PsiElement
import com.intellij.psi.PsiFileFactory

val Project.psiFactory get() = FireRulePsiFactory(this)

class FireRulePsiFactory(private val project: Project ) {

    fun createStructLitField(name: String, value: String): FireRulesStructLitField =
        createFromText("function test() { let a = { $name: $value }; }")
            ?: error("Failed to create FireRulesStructLitField")

    fun createFunction(text: String): PsiElement =
        createFromText<FireRulesFunctionDef>(text)
            ?: error("Failed to create identifier: `$text`")

    fun createIdentifier(text: String): PsiElement =
        createFromText<FireRulesFunctionDef>("function $text() {}")?.nameIdentifier
            ?: error("Failed to create identifier: `$text`")


    private inline fun <reified T : FireRuleElement> createFromText(code: CharSequence): T? {
        val dummyFile = PsiFileFactory.getInstance(project)
            .createFileFromText(
                "DUMMY.rules",
                FirebaseFileType,
                code
            ) as FirebaseFile
        return dummyFile.descendantOfTypeStrict()
    }
}