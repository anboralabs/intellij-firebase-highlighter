package co.anbora.labs.firebase.ide.actions

import co.anbora.labs.firebase.ide.icons.FirebaseIcons
import com.intellij.ide.actions.CreateFileFromTemplateAction
import com.intellij.ide.actions.CreateFileFromTemplateDialog
import com.intellij.openapi.project.Project
import com.intellij.psi.PsiDirectory

class CreateFirestoreFileAction: CreateFileFromTemplateAction(CAPTION, "", FirebaseIcons.FILE) {

    override fun buildDialog(project: Project, directory: PsiDirectory, builder: CreateFileFromTemplateDialog.Builder) {
        builder.setTitle(CAPTION).addKind("Empty Rules file", FirebaseIcons.FILE, "Firestore Rule File")
    }

    override fun getActionName(directory: PsiDirectory?, newName: String, templateName: String?): String =
        CAPTION

    private companion object {
        private const val CAPTION = "Firestore File"
    }
}
