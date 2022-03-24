package co.anbora.labs.firebase.ide.color

import com.intellij.lang.annotation.HighlightSeverity
import com.intellij.openapi.editor.DefaultLanguageHighlighterColors
import com.intellij.openapi.editor.HighlighterColors
import com.intellij.openapi.editor.colors.TextAttributesKey
import com.intellij.openapi.editor.markup.TextAttributes
import com.intellij.openapi.options.colors.AttributesDescriptor
import java.awt.Color
import java.awt.Font

enum class FirebaseColors(humanName: String, default: TextAttributesKey) {

    KEY_WORD("Keywords", DefaultLanguageHighlighterColors.KEYWORD),
    BAD_CHAR("Bad Character", HighlighterColors.BAD_CHARACTER),
    PERMISSIONS("Permissions", DefaultLanguageHighlighterColors.CONSTANT),
    PATH_AND_STRING("Path and Strings", DefaultLanguageHighlighterColors.STRING),
    COMMENTS("Comments", DefaultLanguageHighlighterColors.LINE_COMMENT),
    CALL_FUNCTION(
        "Functions",
        TextAttributesKey.createTempTextAttributesKey(
            "FIREBASE_CALL_FUNCTION",
            TextAttributes(Color.decode("#E8C32A"), null, null, null, Font.PLAIN)
        )
    ),
    NUMBERS("Numbers", DefaultLanguageHighlighterColors.NUMBER),
    SERVICE_NAME("Service name", TextAttributesKey.createTextAttributesKey("DEFAULT_SERVICE_NAME", DefaultLanguageHighlighterColors.NUMBER));

    val textAttributesKey = TextAttributesKey.createTextAttributesKey("co.anbora.labs.firebase.$name", default)
    val attributesDescriptor = AttributesDescriptor(humanName, textAttributesKey)
    val testSeverity: HighlightSeverity = HighlightSeverity(name, HighlightSeverity.INFORMATION.myVal)
}
