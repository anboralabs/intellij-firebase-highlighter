package co.anbora.labs.firebase.ide.color

import co.anbora.labs.firebase.ide.highlight.FirebaseSyntaxHighlighter
import co.anbora.labs.firebase.ide.icons.FirebaseIcons
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

    override fun getDemoText(): String =
         """rules_version = '2';
service cloud.firestore {
  // Allow the requestor to read or delete any resource on a path under the
  // user directory.
  match /users/{userId}/{anyUserFile=**} {
    allow read, delete: if request.auth != null && request.auth.uid == userId;
  }

  match /databases/{database}/documents {
    // True if the user is signed in or the requested data is 'public'
    function signedInOrPublic() {
      return request.auth.uid != null || resource.data.visibility == 'public';
    }
    match /{role}/{document=**} {
      allow read, write: if
          request.time < timestamp.date(2020, 9, 23) && role in request.auth.token.authorities;
    }
  }
  // Allow the requestor to create or update their own images.
  // When 'request.method' == 'delete' this rule and the one matching
  // any path under the user directory would both match and the `delete`
  // would be permitted.

  match /users/{userId}/images/{imageId} {
    // Whether to permit the request depends on the logical OR of all
    // matched rules. This means that even if this rule did not explicitly
    // allow the 'delete' the earlier rule would have.
    allow write: if request.auth != null && request.auth.uid == userId && imageId.matches('*.png');
  }
}"""

    override fun getAdditionalHighlightingTagToDescriptorMap(): MutableMap<String, TextAttributesKey> = mutableMapOf()
}
