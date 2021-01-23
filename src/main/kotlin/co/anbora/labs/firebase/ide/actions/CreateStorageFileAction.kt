package co.anbora.labs.firebase.ide.actions

import co.anbora.labs.firebase.ide.icons.FirebaseIcons
import com.intellij.ide.actions.CreateFileFromTemplateAction
import com.intellij.ide.actions.CreateFileFromTemplateDialog
import com.intellij.openapi.project.Project
import com.intellij.psi.PsiDirectory

class CreateStorageFileAction: CreateFileFromTemplateAction(CAPTION, "", FirebaseIcons.FILE) {

    private companion object {
        private const val CAPTION = "Firestore File"
    }

    override fun buildDialog(project: Project, directory: PsiDirectory, builder: CreateFileFromTemplateDialog.Builder) {
        builder.setTitle(CAPTION).addKind("Empty Rules file", FirebaseIcons.FILE, "Storage Rule File")
    }

    override fun getActionName(directory: PsiDirectory?, newName: String, templateName: String?): String =
        CAPTION
}
