import pack.Initializer
import pack.Templating
import util.Global

class App(val packageName: String, val fileName: String) {

    fun generate(type: String) {
        val initializer = Initializer(packageName)
        val packager = initializer.packagePrepared(fileName.toLowerCase())

        Templating(
                packager = packager,
                fileName = fileName.capitalize() + type,
                extension = Global.Ext.Kt
        ).create(Global.Template.FRAGMENT)
    }

}