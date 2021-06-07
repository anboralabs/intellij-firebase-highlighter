package co.anbora.labs.firebase.ide.formatter

import co.anbora.labs.firebase.ide.formatter.impl.createSpacingBuilder
import com.intellij.formatting.Alignment
import com.intellij.formatting.SpacingBuilder
import com.intellij.psi.codeStyle.CodeStyleSettings

data class FirebaseFmtContext private constructor(
    val commonSettings: CodeStyleSettings,
    val spacingBuilder: SpacingBuilder,
    val sharedAlignment: Alignment? = null
) {
    companion object {
        fun create(settings: CodeStyleSettings): FirebaseFmtContext {
            return FirebaseFmtContext(settings, createSpacingBuilder(settings))
        }
    }

}