package app.isfaaghyth.utildroid.pack

import app.isfaaghyth.utildroid.entity.Packager
import app.isfaaghyth.utildroid.util.Global
import app.isfaaghyth.utildroid.util.Util
import java.io.File

class Generator(private val packager: Packager,
                private var appPackage: String,
                private var prefix: String,
                private var extension: String) {

    private val packageName = packager.basePackage
    private val fullPackage = packager.featurePackage
    private val projectDir  = packager.projectPath

    private var layoutName: String

    init {
        println("appPackage {p} -> $appPackage")
        val index = appPackage.lastIndexOf(".")
        appPackage = appPackage.substring(index + 1).capitalize()
        println("appPackage {b} -> $appPackage")
        layoutName = Util.layoutName(appPackage + prefix)
        println("layoutName -> $layoutName")
        appPackage += prefix
        println("appPackage {a} -> $appPackage")
    }

    private fun generator(file: String): String {
        var template = Util.template(file).bufferedReader().use {
            template -> template.readText()
        }

        val replace = mapOf(
                "~CLASS" to appPackage,
                "~ROOT_PACKAGE" to packageName,
                "~PACKAGE" to fullPackage,
                "~TIME" to Util.timeNow(),
                "~LAYOUT" to layoutName
        )

        replace.forEach { base, new ->
            template = template.replace(base, new).trim()
        }

        return template
    }

    private fun create(file: File, template: String) {
        file.writeText(generator(template))
        println("[DONE] Class -> $file")
    }

    fun layout(): Generator {
        val layoutDirectory = Util.currentPath.plus(Global.Directory.ANDROID_RES)
        val template = Util.template(Global.Template.LAYOUT).bufferedReader().use { it.readText() }
        val xmlFile = layoutDirectory.plus(layoutName).plus(Global.Ext.Xml)
        val layout = File(xmlFile)
        layout.writeText(template)
        println("[DONE] XML Layout -> $xmlFile")
        return this
    }

    fun mvp(): Generator {
        val mvpView = projectDir.plus(appPackage).plus(Global.Prefix.VIEW).plus(extension)
        val mvpPresenter = projectDir.plus(appPackage).plus(Global.Prefix.PRESENTER).plus(extension)
        create(File(mvpView), Global.Template.Mvp.View)
        create(File(mvpPresenter), Global.Template.Mvp.Presenter)
        return this
    }

    fun build(): Generator {
        val newFile = File(projectDir.plus(appPackage).plus(extension))
        create(newFile, Template.name(prefix))
        return this
    }

}