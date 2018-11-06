package app.isfaaghyth.utildroid

import app.isfaaghyth.utildroid.pack.Initializer
import app.isfaaghyth.utildroid.pack.Templating
import app.isfaaghyth.utildroid.util.Global

class App(packageName: String, val className: String) {

    private val initializer = Initializer(packageName)
    private val packager = initializer.packagePrepared(className.toLowerCase())

    fun generate(classType: String): Templating {
        return Templating(
                packager = packager,
                fileName = className,
                extension = Global.Ext.Kt,
                prefix = classType)
                .build()
    }

}