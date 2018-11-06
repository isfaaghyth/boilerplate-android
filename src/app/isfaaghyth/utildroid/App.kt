package app.isfaaghyth.utildroid

import app.isfaaghyth.utildroid.pack.Initializer
import app.isfaaghyth.utildroid.pack.Templating

class App(basePackage: String, private val appPackage: String) {

    private val init = Initializer(basePackage, appPackage)
    private val packager = init.pack()

    fun generate(classType: String, extension: String): Templating {
        return Templating(
                packager = packager,
                fileName = appPackage,
                extension = extension,
                prefix = classType)
                .build()
    }

}