package app.isfaaghyth.utildroid.pack

import app.isfaaghyth.utildroid.util.Global
import app.isfaaghyth.utildroid.util.Util
import java.io.File

class Initializer(val packageName: String) {

    private fun projectPackage(): String {
        var projectLocation = Util.currentDir.plus(Global.Directory.ANDROID_PROJECT)
        println(projectLocation)
        val packages = packageName.split(".")
        for (domain in packages) {
            projectLocation = projectLocation.plus("/").plus(domain)
        }
        return projectLocation
    }

    fun packagePrepared(newPackage: String): HashMap<String, String> {
        val packageCollection = HashMap<String, String>()

        val packageInit = projectPackage().plus("/").plus(newPackage)
        val isProjectDir = File(packageInit)

        val isLayoutDir = File(Util.currentDir.plus("/")
                .plus(Global.Directory.ANDROID_RES).plus("/"))

        if (!isLayoutDir.exists()) isLayoutDir.mkdirs()
        if (!isProjectDir.exists()) isProjectDir.mkdirs()

        val fullPackage = packageName.plus(newPackage)
        packageCollection.put(Global.Key.DIRECTORY, packageInit)
        packageCollection.put(Global.Key.ROOT_PACKAGE, packageName)
        packageCollection.put(Global.Key.PACKAGE, fullPackage)
        return packageCollection
    }
}