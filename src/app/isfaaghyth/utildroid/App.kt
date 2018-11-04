package app.isfaaghyth.utildroid

import app.isfaaghyth.utildroid.pack.Initializer
import app.isfaaghyth.utildroid.pack.Template
import app.isfaaghyth.utildroid.pack.Templating
import app.isfaaghyth.utildroid.util.Global

class App(packageName: String, val fileName: String) {

    private val initializer = Initializer(packageName)
    private val packager = initializer.packagePrepared(fileName.toLowerCase())

    fun generate(classType: String): Templating {
        return Templating(
                packager = packager,
                fileName = fileName.capitalize(),
                extension = Global.Ext.Kt,
                prefix = classType)
                .build()
    }

}