package pack

import util.Global
import util.Util
import java.io.File

class Templating(packager: HashMap<String, String>,
                 private val fileName: String,
                 private val extension: String) {

    private val packageName = packager[Global.Key.ROOT_PACKAGE].toString()
    private val fullPackage = packager[Global.Key.PACKAGE].toString()
    private val projectDir  = packager[Global.Key.DIRECTORY].toString()

    private val newFile = File("$projectDir$fileName$extension")

    fun create(type: String) {
        val template = File(Util.getTemplate(type))

        var temporary = template.readText()
        temporary = temporary.replace("~CLASS", fileName).trim()
        temporary = temporary.replace("~ROOT_PACKAGE", packageName).trim()
        temporary = temporary.replace("~PACKAGE", fullPackage).trim()
        temporary = temporary.replace("~TIME", Util.getTimeNow()).trim()
        temporary = temporary.replace("~LAYOUT", fileName).trim()

        newFile.writeText(temporary)
    }

    fun layout(): Templating {
        val layoutDirectory = Util.currentDir + Global.Directory.ANDROID_RES
        val template = File(Util.getTemplate(Global.Template.LAYOUT))
        val layoutName = Util.layoutName(fileName)
        val layout = File("$layoutDirectory$layoutName${Global.Ext.Xml}")
        layout.writeText(template.readText())
        return this
    }
}