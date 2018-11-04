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

    fun create(): Templating {
        val newFile = File(projectDir.plus(fileName).plus(extension))
        newFile.writeText(templateGenerator(Template.templateName(prefix)))
        println("[DONE] Class -> $newFile")
        return this
    }

    private fun create(file: File, template: String) {
        file.writeText(templateGenerator(template))
    }

    fun layout(): Templating {
        val layoutDirectory = Util.currentDir.plus(Global.Directory.ANDROID_RES)
        val template = File(Util.getTemplate(Global.Template.LAYOUT))
        val xmlFile = layoutDirectory.plus(layoutName).plus(Global.Ext.Xml)
        val layout = File(xmlFile)
        layout.writeText(template.readText())
        println("[DONE] XML Layout -> $xmlFile")
        return this
    }

    fun mvp(): Templating {
        val mvpView = projectDir.plus(fileName).plus(Global.Prefix.VIEW).plus(extension)
        val mvpPresenter = projectDir.plus(fileName).plus(Global.Prefix.PRESENTER).plus(extension)

        create(File(mvpView), Global.Template.Mvp.View)
        println("[DONE] MVP View -> $mvpView")

        create(File(mvpPresenter), Global.Template.Mvp.Presenter)
        println("[DONE] MVP Presenter -> $mvpPresenter")
        return this
    }
}