package co.anbora.labs.firebase.syntax.highlight;

import co.anbora.labs.firebase.syntax.language.FirebaseRulesIcons;
import com.intellij.openapi.editor.colors.TextAttributesKey;
import com.intellij.openapi.fileTypes.SyntaxHighlighter;
import com.intellij.openapi.options.colors.AttributesDescriptor;
import com.intellij.openapi.options.colors.ColorDescriptor;
import com.intellij.openapi.options.colors.ColorSettingsPage;
import com.intellij.openapi.util.NlsContexts;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import javax.swing.*;
import java.util.Map;

public class ColorSettings implements ColorSettingsPage {

    private static final AttributesDescriptor[] DESCRIPTORS = new AttributesDescriptor[]{
            new AttributesDescriptor("Keywords", Highlighter.KEY),
            new AttributesDescriptor("Permissions", Highlighter.PERMISSION),
            new AttributesDescriptor("Path", Highlighter.PATH)
    };

    @Override
    public @Nullable Icon getIcon() {
        return FirebaseRulesIcons.FILE;
    }

    @Override
    public @NotNull SyntaxHighlighter getHighlighter() {
        return new Highlighter();
    }

    @Override
    public @NotNull String getDemoText() {
        return "rules_version = '2';\n" +
                "service cloud.firestore {\n" +
                "  match /databases/{database}/documents {\n" +
                "\n" +
                "    function signedInOrPublic() {\n" +
                "        return request.auth.uid != null || resource.data.visibility == 'public';\n" +
                "    }\n" +
                "\n" +
                "    match /cities/{city} {\n" +
                "      allow read, write: if signedInOrPublic();\n" +
                "    }\n" +
                "\n" +
                "    match /users/{user} {\n" +
                "      allow read, write: if signedInOrPublic();\n" +
                "    }\n" +
                "  }\n" +
                "}\n";
    }

    @Override
    public @Nullable Map<String, TextAttributesKey> getAdditionalHighlightingTagToDescriptorMap() {
        return null;
    }

    @Override
    public @NotNull AttributesDescriptor[] getAttributeDescriptors() {
        return DESCRIPTORS;
    }

    @Override
    public @NotNull ColorDescriptor[] getColorDescriptors() {
        return ColorDescriptor.EMPTY_ARRAY;
    }

    @Override
    public @NotNull @NlsContexts.ConfigurableName String getDisplayName() {
        return "Firebase Rules";
    }
}
