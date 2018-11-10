package app.isfaaghyth.utildroid

import app.isfaaghyth.utildroid.pack.Initializer
import app.isfaaghyth.utildroid.pack.Generator

class App(basePackage: String, private val paramPackage: String) {

    private val init = Initializer(basePackage, paramPackage)
    private val packager = init.pack()

    fun generate(classType: String, extension: String): Generator {
        return Generator(
                packager = packager,
                paramPackage = paramPackage,
                extension = extension,
                prefix = classType)
                .build()
    }

}