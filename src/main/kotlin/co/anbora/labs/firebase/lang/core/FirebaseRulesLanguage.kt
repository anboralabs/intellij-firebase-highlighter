package co.anbora.labs.firebase.lang.core

import co.anbora.labs.firebase.ide.icons.FirebaseIcons
import com.intellij.lang.Language
import com.intellij.openapi.fileTypes.LanguageFileType
import javax.swing.Icon

object FirebaseRulesLanguage: Language("firebase_rules")

object FirebaseFileType: LanguageFileType(FirebaseRulesLanguage) {

    const val EXTENSION = "rules"

    override fun getName(): String = "Firebase Rule File"

    override fun getDescription(): String = "Firebase rules configurations"

    override fun getDefaultExtension(): String = EXTENSION

    override fun getIcon(): Icon = FirebaseIcons.FILE

}
