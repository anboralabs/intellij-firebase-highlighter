package co.anbora.labs.firebase.ide.style

import co.anbora.labs.firebase.lang.FirebaseRulesLanguage
import com.intellij.application.options.TabbedLanguageCodeStylePanel
import com.intellij.psi.codeStyle.CodeStyleSettings

class FirebaseCodeStyleMainPanel(
    currentSettings: CodeStyleSettings,
    settings: CodeStyleSettings
): TabbedLanguageCodeStylePanel(FirebaseRulesLanguage, currentSettings, settings) {

    override fun initTabs(settings: CodeStyleSettings?) {
        addIndentOptionsTab(settings)
        addSpacesTab(settings)
    }
}