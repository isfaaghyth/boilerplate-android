package app.isfaaghyth.utildroid

import app.isfaaghyth.utildroid.pack.Initializer
import app.isfaaghyth.utildroid.pack.Generator

class App(basePackage: String, private val appPackage: String) {

    private val init = Initializer(basePackage, appPackage)
    private val packager = init.pack()

    fun generate(classType: String, extension: String): Generator {
        return Generator(
                packager = packager,
                fileName = appPackage,
                extension = extension,
                prefix = classType)
                .build()
    }

}