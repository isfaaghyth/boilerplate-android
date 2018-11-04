import pack.Initializer
import pack.Templating
import util.Global

class App(val packageName: String, val fileName: String) {

    fun generate(type: String) {
        val init = Initializer(packageName)
        val dir = init.packageDirectory(fileName.toLowerCase())
        Templating(fileName.capitalize() + type).create(dir, Global.Ext.Kt)
    }

}