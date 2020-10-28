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
            new AttributesDescriptor("Path and Strings", Highlighter.PATH),
            new AttributesDescriptor("Comments", Highlighter.COMMENT),
            new AttributesDescriptor("Numbers", Highlighter.NUMBER)
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
                "  // Allow the requestor to read or delete any resource on a path under the\n" +
                "  // user directory.\n" +
                "  match /users/{userId}/{anyUserFile=**} {\n" +
                "    allow read, delete: if request.auth != null && request.auth.uid == userId;\n" +
                "  }\n" +
                "\n" +
                "  match /databases/{database}/documents {\n" +
                "    // True if the user is signed in or the requested data is 'public'\n" +
                "    function signedInOrPublic() {\n" +
                "      return request.auth.uid != null || resource.data.visibility == 'public';\n" +
                "    }\n" +
                "    match /{role}/{document=**} {\n" +
                "      allow read, write: if\n" +
                "          request.time < timestamp.date(2020, 9, 23) && role in request.auth.token.authorities;\n" +
                "    }\n" +
                "  }\n" +
                "  // Allow the requestor to create or update their own images.\n" +
                "  // When 'request.method' == 'delete' this rule and the one matching\n" +
                "  // any path under the user directory would both match and the `delete`\n" +
                "  // would be permitted.\n" +
                "\n" +
                "  match /users/{userId}/images/{imageId} {\n" +
                "    // Whether to permit the request depends on the logical OR of all\n" +
                "    // matched rules. This means that even if this rule did not explicitly\n" +
                "    // allow the 'delete' the earlier rule would have.\n" +
                "    allow write: if request.auth != null && request.auth.uid == userId && imageId.matches('*.png');\n" +
                "  }\n" +
                "}";
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
