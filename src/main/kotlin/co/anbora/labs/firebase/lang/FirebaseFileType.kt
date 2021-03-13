package co.anbora.labs.firebase.lang

import co.anbora.labs.firebase.ide.icons.FirebaseIcons
import com.intellij.openapi.fileTypes.LanguageFileType
import javax.swing.Icon

object FirebaseFileType: LanguageFileType(FirebaseRulesLanguage) {

    const val EXTENSION = "rules"

    override fun getName(): String = "Firebase Rules"

    override fun getDescription(): String = "Firebase rules configurations"

    override fun getDefaultExtension(): String = EXTENSION

    override fun getIcon(): Icon = FirebaseIcons.FILE

}