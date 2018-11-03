package pack

import util.Global
import java.io.File

class Initializer {
    fun currentDir(): String {
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

    fun packageDirectory(packageName: String, newPackage: String): HashMap<String, String> {
        val packageTemp = HashMap<String, String>()
        val packageInit = "${packageNamePrepared(packageName)}/$newPackage/"
        val packagesName = "$packageName.$newPackage"
        val test = File(packageInit)
        if (!test.exists()) {
            test.mkdirs()
        }
        packageTemp.put(Global.Key.DIRECTORY, packageInit)
        packageTemp.put(Global.Key.PACKAGE, packagesName)
        return packageTemp
    }
}