import pack.Initializer
import pack.Templating
import util.Global

class App(val packageName: String, val fileName: String) {

    fun generate() {
        val init = Initializer(packageName)
        val dir = init.packageDirectory(fileName.toLowerCase())
        Templating(fileName.capitalize()).create(dir, Global.Ext.Kt)
    }

}