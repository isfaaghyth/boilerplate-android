package pack

import util.Global
import util.Util
import java.io.File

class Initializer(val packageName: String,
                  val directory: Directory) {

    private fun projectPackage(): String {
        var projectLocation = when (directory) {
            Directory.PROJECT -> {
                "${Util.currentDir}${Global.Directory.ANDROID_PROJECT}"
            }
            Directory.LAYOUT -> {
                "${Util.currentDir}${Global.Directory.ANDROID_RES}"
            }
        }

        val packages = packageName.split(".")
        for (domain in packages) projectLocation = "$projectLocation/$domain"
        return projectLocation
    }

    fun packagePrepared(newPackage: String): HashMap<String, String> {
        val packageCollection = HashMap<String, String>()
        val packageInit = "${projectPackage()}/$newPackage/"
        val fullPackage = "$packageName.$newPackage"
        val isProject = File(packageInit)
        if (!isProject.exists()) {
            isProject.mkdirs()
        }
        packageCollection.put(Global.Key.DIRECTORY, packageInit)
        packageCollection.put(Global.Key.ROOT_PACKAGE, packageName)
        packageCollection.put(Global.Key.PACKAGE, fullPackage)
        return packageCollection
    }
}