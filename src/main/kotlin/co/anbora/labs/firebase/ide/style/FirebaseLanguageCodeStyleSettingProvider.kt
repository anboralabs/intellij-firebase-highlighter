package co.anbora.labs.firebase.ide.style

import co.anbora.labs.firebase.lang.FirebaseRulesLanguage
import co.anbora.labs.firebase.lang.FirebaseRulesLanguage.LANGUAGE_DEMO_TEXT
import com.intellij.application.options.IndentOptionsEditor
import com.intellij.application.options.SmartIndentOptionsEditor
import com.intellij.lang.Language
import com.intellij.psi.codeStyle.CodeStyleSettingsCustomizable
import com.intellij.psi.codeStyle.CommonCodeStyleSettings
import com.intellij.psi.codeStyle.LanguageCodeStyleSettingsProvider

object FirebaseLanguageCodeStyleSettingProvider: LanguageCodeStyleSettingsProvider() {

    override fun getLanguage(): Language = FirebaseRulesLanguage

    override fun getCodeSample(settingsType: SettingsType): String = LANGUAGE_DEMO_TEXT

    override fun customizeSettings(consumer: CodeStyleSettingsCustomizable, settingsType: SettingsType) {
        if (settingsType == SettingsType.SPACING_SETTINGS) {
            consumer.showStandardOptions("SPACE_AFTER_COMMA")
            consumer.showStandardOptions("SPACE_BEFORE_COMMA")
        } else if (settingsType == SettingsType.BLANK_LINES_SETTINGS) {
            consumer.showStandardOptions("KEEP_BLANK_LINES_IN_CODE")
        }
    }

    override fun customizeDefaults(commonSettings: CommonCodeStyleSettings, indentOptions: CommonCodeStyleSettings.IndentOptions) {
        indentOptions.INDENT_SIZE = 4
        commonSettings.KEEP_BLANK_LINES_IN_CODE = 0
    }

    override fun getIndentOptionsEditor(): IndentOptionsEditor = SmartIndentOptionsEditor()
}
