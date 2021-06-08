package co.anbora.labs.firebase.ide.style

import co.anbora.labs.firebase.lang.FirebaseRulesLanguage
import com.intellij.application.options.CodeStyleAbstractConfigurable
import com.intellij.application.options.CodeStyleAbstractPanel
import com.intellij.psi.codeStyle.CodeStyleSettings

class FirebaseCodeStyleConfigurable(
    settings: CodeStyleSettings,
    originalSettings: CodeStyleSettings?
): CodeStyleAbstractConfigurable(settings, originalSettings, FirebaseRulesLanguage.LANGUAGE_NAME) {

    override fun createPanel(
        settings: CodeStyleSettings
    ): CodeStyleAbstractPanel = FirebaseCodeStyleMainPanel(currentSettings, settings)

    override fun getHelpTopic(): String? = null
}
