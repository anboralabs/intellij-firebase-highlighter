package co.anbora.labs.firebase.ide.icons

import com.intellij.icons.AllIcons
import com.intellij.openapi.util.IconLoader
import javax.swing.Icon

object FirebaseIcons {

    val FILE = getIcon("icon_file.svg")


    val FUNCTION = AllIcons.Nodes.Function
    val PARAMETER = AllIcons.Nodes.Parameter

    val VARIABLE = AllIcons.Nodes.Variable

    private fun getIcon(path: String): Icon {
        return IconLoader.findIcon("/icons/$path", FirebaseIcons::class.java.classLoader) as Icon
    }
}
