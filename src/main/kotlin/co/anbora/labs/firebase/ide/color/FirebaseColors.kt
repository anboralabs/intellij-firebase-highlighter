package co.anbora.labs.firebase.ide.color

import com.intellij.openapi.editor.DefaultLanguageHighlighterColors
import com.intellij.openapi.editor.HighlighterColors
import com.intellij.openapi.editor.colors.TextAttributesKey
import com.intellij.openapi.options.colors.AttributesDescriptor

enum class FirebaseColors(humanName: String, default: TextAttributesKey) {

    KEY_WORD("Keywords", DefaultLanguageHighlighterColors.KEYWORD),
    BAD_CHAR("Bad Character", HighlighterColors.BAD_CHARACTER),
    PERMISSIONS("Permissions", DefaultLanguageHighlighterColors.CONSTANT),
    PATH_AND_STRING("Path and Strings", DefaultLanguageHighlighterColors.STRING),
    COMMENTS("Comments", DefaultLanguageHighlighterColors.LINE_COMMENT),
    CALL_FUNCTION("Functions", DefaultLanguageHighlighterColors.FUNCTION_CALL),
    NUMBERS("Numbers", DefaultLanguageHighlighterColors.NUMBER),
    SERVICE_NAME("Service name", DefaultLanguageHighlighterColors.NUMBER);

    val textAttributesKey = TextAttributesKey.createTextAttributesKey("co.anbora.labs.firebase.$name", default)
    val attributesDescriptor = AttributesDescriptor(humanName, textAttributesKey)
}
