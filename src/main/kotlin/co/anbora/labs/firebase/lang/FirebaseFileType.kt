package co.anbora.labs.firebase.lang

import co.anbora.labs.firebase.ide.icons.FirebaseIcons
import co.anbora.labs.firebase.lang.FirebaseRulesLanguage.LANGUAGE_NAME
import com.intellij.openapi.fileTypes.LanguageFileType
import javax.swing.Icon

object FirebaseFileType: LanguageFileType(FirebaseRulesLanguage) {

    private const val EXTENSION = "rules"

    override fun getName(): String = LANGUAGE_NAME

    override fun getDescription(): String = "Firebase rules configurations"

    override fun getDefaultExtension(): String = EXTENSION

    override fun getIcon(): Icon = FirebaseIcons.FILE

}
