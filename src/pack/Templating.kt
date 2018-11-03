package pack

import template.Fragment
import util.Global
import java.io.File

class Templating(private val fileName: String) {
    fun create(initial: HashMap<String, String>): Boolean {
        val projectDirectory = initial[Global.Key.DIRECTORY].toString()
        val packageName = initial[Global.Key.PACKAGE].toString()
        val file = File("$projectDirectory$fileName.kt")
        file.writeText(Fragment.create(fileName, packageName))
        return file.createNewFile()
    }
}