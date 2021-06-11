package co.anbora.labs.firebase.ide.color

import co.anbora.labs.firebase.ide.highlight.FirebaseSyntaxHighlighter
import co.anbora.labs.firebase.ide.icons.FirebaseIcons
import co.anbora.labs.firebase.lang.FirebaseRulesLanguage.LANGUAGE_DEMO_TEXT
import com.intellij.openapi.editor.colors.TextAttributesKey
import com.intellij.openapi.fileTypes.SyntaxHighlighter
import com.intellij.openapi.options.colors.AttributesDescriptor
import com.intellij.openapi.options.colors.ColorDescriptor
import com.intellij.openapi.options.colors.ColorSettingsPage
import javax.swing.Icon

class FirebaseColorSettingPage: ColorSettingsPage {

    private val ATTRS = FirebaseColors.values().map { it.attributesDescriptor }.toTypedArray()

    override fun getAttributeDescriptors(): Array<AttributesDescriptor> = ATTRS

    override fun getColorDescriptors(): Array<ColorDescriptor> = ColorDescriptor.EMPTY_ARRAY

    override fun getDisplayName(): String = "Firebase Rules"

    override fun getIcon(): Icon = FirebaseIcons.FILE

    override fun getHighlighter(): SyntaxHighlighter = FirebaseSyntaxHighlighter()

    override fun getDemoText(): String = LANGUAGE_DEMO_TEXT

    override fun getAdditionalHighlightingTagToDescriptorMap(): MutableMap<String, TextAttributesKey> = mutableMapOf()
}
