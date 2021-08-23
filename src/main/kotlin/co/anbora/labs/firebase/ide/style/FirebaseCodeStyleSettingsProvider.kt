package co.anbora.labs.firebase.ide.style

import co.anbora.labs.firebase.lang.FirebaseRulesLanguage.LANGUAGE_NAME
import com.intellij.psi.codeStyle.CodeStyleConfigurable
import com.intellij.psi.codeStyle.CodeStyleSettings
import com.intellij.psi.codeStyle.CodeStyleSettingsProvider
import com.intellij.psi.codeStyle.CustomCodeStyleSettings

object FirebaseCodeStyleSettingsProvider: CodeStyleSettingsProvider() {

    override fun createCustomSettings(
        settings: CodeStyleSettings?
    ): CustomCodeStyleSettings = FirebaseCodeStyleSettings(settings)

    override fun getConfigurableDisplayName(): String = LANGUAGE_NAME

    override fun createConfigurable(
        settings: CodeStyleSettings,
        originalSettings: CodeStyleSettings
    ): CodeStyleConfigurable = FirebaseCodeStyleConfigurable(settings, originalSettings)
}
