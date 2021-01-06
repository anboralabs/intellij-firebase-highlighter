package co.anbora.labs.firebase.ide.formatter

import co.anbora.labs.firebase.ide.formatter.impl.createSpacingBuilder
import co.anbora.labs.firebase.lang.core.FirebaseRulesLanguage
import com.intellij.formatting.Alignment
import com.intellij.formatting.SpacingBuilder
import com.intellij.psi.codeStyle.CodeStyleSettings
import com.intellij.psi.codeStyle.CommonCodeStyleSettings

data class FirebaseFmtContext private constructor(
    val commonSettings: CommonCodeStyleSettings,
    val spacingBuilder: SpacingBuilder,
    val sharedAlignment: Alignment? = null
) {
    companion object {
        fun create(settings: CodeStyleSettings): FirebaseFmtContext {
            val commonSettings = settings.getCommonSettings(FirebaseRulesLanguage)
            return FirebaseFmtContext(commonSettings, createSpacingBuilder(commonSettings))
        }
    }
}
