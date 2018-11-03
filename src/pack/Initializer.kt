package pack

import util.Global
import java.io.File

class Initializer {
    private fun currentDir(): String {
        return System.getProperty(Global.System.DIR_PROPERTY)
    }

    private fun packageNamePrepared(packageName: String): String {
        val packages = packageName.split(".")
        var projectDir = "${currentDir()}${Global.Directory.ANDROID_INIT}"
        for (test in packages) {
            projectDir = "$projectDir/$test"
        }
        return projectDir
    }

    fun packageDirectory(packageName: String) {
        println(packageNamePrepared(packageName))
        val test = File(packageNamePrepared(packageName))
        if (!test.exists()) {
            test.mkdirs()
        }
    }
}