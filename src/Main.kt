import pack.Initializer
import pack.Templating
import util.Global

fun main(args: Array<String>) {
    val init = Initializer()
    val dir = init.packageDirectory(
            "isfahani.ghiyath.ganteng",
            "login")

    Templating("LoginFragment").create(dir, Global.Ext.Kt)
}