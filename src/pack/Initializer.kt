package pack

import util.Global
import util.Util
import java.io.File

class Initializer(val packageName: String) {

    private fun projectPackage(): String {
        // project/path/location/app/src/main/java
        var projectLocation = "${Util.currentDir}${Global.Directory.ANDROID_INIT}"

        val packages = packageName.split(".")
        for (domain in packages) projectLocation = "$projectLocation/$domain"
        return projectLocation
    }

    fun packagePrepared(newPackage: String): HashMap<String, String> {
        val temp = HashMap<String, String>()
        val packageInit = "${projectPackage()}/$newPackage/"
        val fullPackage = "$packageName.$newPackage"
        val test = File(packageInit)
        if (!test.exists()) {
            test.mkdirs()
        }
        temp.put(Global.Key.DIRECTORY, packageInit)
        temp.put(Global.Key.ROOT_PACKAGE, packageName)
        temp.put(Global.Key.PACKAGE, fullPackage)
        return temp
    }
}