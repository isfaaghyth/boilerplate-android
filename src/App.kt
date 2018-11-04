import pack.Initializer
import pack.Templating
import util.Global

class App(val packageName: String, val fileName: String) {

    private val initializer = Initializer(packageName)
    private val packager = initializer.packagePrepared(fileName.toLowerCase())

    fun generate(type: String) {
        Templating(
                packager = packager,
                fileName = fileName.capitalize() + type,
                extension = Global.Ext.Kt)
                .layout()
                .create(Global.Template.FRAGMENT)
    }

}