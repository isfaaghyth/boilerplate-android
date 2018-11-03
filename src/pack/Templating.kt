package pack

import util.Global
import java.io.File

class Templating(private val fileName: String) {

    fun getTemplate(type: String): String {
        return "${Initializer().currentDir()}${Global.Directory.TEMPLATE}$type"
    }

    fun create(initial: HashMap<String, String>, extension: String) {
        val packageName = initial[Global.Key.PACKAGE].toString()
        val projectDirectory = initial[Global.Key.DIRECTORY].toString()

        val newFile = File("$projectDirectory$fileName$extension")

        val fragmentTemplate = File(getTemplate(Global.Template.FRAGMENT))

        var temporary = fragmentTemplate.readText()
        temporary = temporary.replace("~CLASS", fileName)
        temporary = temporary.replace("~PACKAGE", packageName)
        println(temporary)
        newFile.writeText(temporary)
    }
}