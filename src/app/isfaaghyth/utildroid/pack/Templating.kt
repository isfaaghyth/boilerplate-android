package app.isfaaghyth.utildroid.pack

import app.isfaaghyth.utildroid.util.Global
import app.isfaaghyth.utildroid.util.Util
import java.io.File

class Templating(packager: HashMap<String, String>,
                 private var fileName: String,
                 private var prefix: String,
                 private var extension: String) {

    private val packageName = packager[Global.Key.ROOT_PACKAGE].toString()
    private val fullPackage = packager[Global.Key.PACKAGE].toString()
    private val projectDir  = packager[Global.Key.DIRECTORY].toString()

    private val layoutName = Util.layoutName(fileName + prefix)

    init {
        fileName += prefix
    }

    private fun templateGenerator(type: String): String {
        val template = File(Util.getTemplate(type))
        var temporary = template.readText()
        temporary = temporary.replace("~CLASS", fileName).trim()
        temporary = temporary.replace("~ROOT_PACKAGE", packageName).trim()
        temporary = temporary.replace("~PACKAGE", fullPackage).trim()
        temporary = temporary.replace("~TIME", Util.getTimeNow()).trim()
        temporary = temporary.replace("~LAYOUT", layoutName).trim()
        return temporary
    }

    fun create() {
        val newFile = File("$projectDir$fileName$extension")
        newFile.writeText(templateGenerator(Template.templateName(prefix)))
        println("[DONE] Class -> $fileName$extension")
    }

    private fun create(file: File, template: String) {
        file.writeText(templateGenerator(template))
    }

    fun layout(): Templating {
        val layoutDirectory = Util.currentDir + Global.Directory.ANDROID_RES
        val template = File(Util.getTemplate(Global.Template.LAYOUT))
        val layout = File("$layoutDirectory$layoutName${Global.Ext.Xml}")
        layout.writeText(template.readText())
        println("[DONE] XML Layout -> $layoutName")
        return this
    }

    fun mvp(): Templating {
        create(File("$projectDir$fileName${Global.Prefix.VIEW}$extension"), Global.Template.Mvp.View)
        println("[DONE] MVP View Layout -> $fileName${Global.Prefix.VIEW}$extension")

        create(File("$projectDir$fileName${Global.Prefix.PRESENTER}$extension"), Global.Template.Mvp.Presenter)
        println("[DONE] MVP Presenter Layout -> $fileName${Global.Prefix.PRESENTER}$extension")
        return this
    }
}