package app.isfaaghyth.utildroid.pack

import app.isfaaghyth.utildroid.util.Global
import app.isfaaghyth.utildroid.util.Util
import java.io.File

class Initializer(val packageName: String) {

    private fun projectPackage(): String {
        var projectLocation = Util.currentDir.plus(Global.Directory.ANDROID_PROJECT)
        val packages = packageName.split(".")
        for (domain in packages) {
            projectLocation = projectLocation.plus("/").plus(domain)
        }
        return projectLocation
    }

    fun packagePrepared(newPackage: String): HashMap<String, String> {
        val packageCollection = HashMap<String, String>()

        val path = projectPackage().plus("/").plus(newPackage).plus("/")
        val projectPath = File(path)

        val layoutPath = File(Util.currentDir
                        .plus("/")
                        .plus(Global.Directory.ANDROID_RES)
                        .plus("/"))

        if (!layoutPath.exists()) layoutPath.mkdirs()
        if (!projectPath.exists()) projectPath.mkdirs()

        val fullPackage = packageName.plus(".").plus(newPackage)
        packageCollection.put(Global.Key.DIRECTORY, path)
        packageCollection.put(Global.Key.ROOT_PACKAGE, packageName)
        packageCollection.put(Global.Key.PACKAGE, fullPackage)
        return packageCollection
    }
}