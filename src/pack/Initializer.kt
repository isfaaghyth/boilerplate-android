package pack

import util.Global
import java.io.File

class Initializer {
    private fun currentDir(): String {
        return System.getProperty(Global.System.DIR_PROPERTY)
    }

    fun packageNamePrepared(packageName: String): Boolean {
        val packages = packageName.split(".")
        var projectDir = "${currentDir()}${Global.Directory.ANDROID_INIT}"
        for (test in packages) {
            projectDir = "$projectDir/$test"
        }
        val projects = File(projectDir)
        return projects.exists() && projects.isDirectory
    }
}