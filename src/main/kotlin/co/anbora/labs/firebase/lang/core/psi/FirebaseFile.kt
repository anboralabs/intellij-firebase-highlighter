package co.anbora.labs.firebase.lang.core.psi

import co.anbora.labs.firebase.lang.core.FirebaseFileType
import co.anbora.labs.firebase.lang.core.FirebaseRulesLanguage
import com.intellij.extapi.psi.PsiFileBase
import com.intellij.openapi.fileTypes.FileType
import com.intellij.psi.FileViewProvider

class FirebaseFile(viewProvider: FileViewProvider) : PsiFileBase(viewProvider, FirebaseRulesLanguage) {

    override fun getFileType(): FileType = FirebaseFileType

    override fun toString(): String = "Firebase rule file"

}