import pack.Initializer
import pack.Templating
import util.Global

fun main(args: Array<String>) {
    val init = Initializer()
    val dir = init.packageDirectory("isfahani.ghiyath.ganteng", "login")
    println(dir[Global.Key.PACKAGE])
    println(dir[Global.Key.DIRECTORY])
    Templating("LoginFragment").create(dir)
}