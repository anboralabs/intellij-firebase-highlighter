package co.anbora.labs.firebase.ide.icons

import com.intellij.openapi.util.IconLoader
import javax.swing.Icon

object FirebaseIcons {

    val FILE = getIcon("elm-file.png")

    private fun getIcon(path: String): Icon {
        return IconLoader.getIcon("/icons/$path")
    }
}
