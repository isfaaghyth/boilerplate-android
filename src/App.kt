import pack.Initializer
import pack.Templating
import util.Global

class App(val packageName: String, val fileName: String) {

    private val initializer = Initializer(packageName)
    private val packager = initializer.packagePrepared(fileName.toLowerCase())

    fun generate() {
        Templating(
                packager = packager,
                fileName = fileName.capitalize(),
                extension = Global.Ext.Kt,
                prefix = Global.Prefix.FRAGMENT)
                .mvp()
                .layout()
                .create()
    }

}