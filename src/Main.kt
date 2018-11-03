import pack.Initializer
import pack.Templating
import util.Global

fun main(args: Array<String>) {
    val init = Initializer("isfahani.ghiyath.ganteng")
    val dir = init.packageDirectory("login")
    Templating("LoginFragment").create(dir, Global.Ext.Kt)
}