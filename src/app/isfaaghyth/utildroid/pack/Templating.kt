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

    init { fileName += prefix }

    private fun generator(templateFile: String): String {
        var template = Util.getTemplate(templateFile).bufferedReader().use { it.readText() }

        val replace = mapOf(
                "~CLASS" to fileName,
                "~ROOT_PACKAGE" to packageName,
                "~PACKAGE" to fullPackage,
                "~TIME" to Util.getTimeNow(),
                "~LAYOUT" to layoutName)

        replace.forEach { base, new ->
            template = template.replace(base, new).trim()
        }

        return template
    }

    private fun create(file: File, template: String) {
        file.writeText(generator(template))
        println("[DONE] Class -> $file")
    }

    fun build(): Templating {
        val newFile = File(projectDir.plus(fileName).plus(extension))
        create(newFile, Template.templateName(prefix))
        return this
    }

    fun layout(): Templating {
        val layoutDirectory = Util.currentDir.plus(Global.Directory.ANDROID_RES)
        val template = Util.getTemplate(Global.Template.LAYOUT).bufferedReader().use { it.readText() }
        val xmlFile = layoutDirectory.plus(layoutName).plus(Global.Ext.Xml)
        val layout = File(xmlFile)
        layout.writeText(template)
        println("[DONE] XML Layout -> $xmlFile")
        return this
    }

    fun mvp(): Templating {
        val mvpView = projectDir.plus(fileName).plus(Global.Prefix.VIEW).plus(extension)
        val mvpPresenter = projectDir.plus(fileName).plus(Global.Prefix.PRESENTER).plus(extension)
        create(File(mvpView), Global.Template.Mvp.View)
        create(File(mvpPresenter), Global.Template.Mvp.Presenter)
        return this
    }
}