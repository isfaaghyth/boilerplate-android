package pack

import util.Global
import util.Util
import java.io.File

class Initializer(val packageName: String) {

    private fun packageNamePrepared(): String {
        // project/path/location/app/src/main/java
        var projectLocation = "${Util.currentDir}${Global.Directory.ANDROID_INIT}"

        val packages = packageName.split(".")
        for (domain in packages) projectLocation = "$projectLocation/$domain"
        return projectLocation
    }

    fun packageDirectory(newPackage: String): HashMap<String, String> {
        val temp = HashMap<String, String>()
        val packageInit = "${packageNamePrepared()}/$newPackage/"
        val packagesName = "$packageName.$newPackage"
        val test = File(packageInit)
        if (!test.exists()) {
            test.mkdirs()
        }
        temp.put(Global.Key.DIRECTORY, packageInit)
        temp.put(Global.Key.PACKAGE, packagesName)
        return temp
    }
}