package app.isfaaghyth.utildroid.pack

import app.isfaaghyth.utildroid.util.Global
import app.isfaaghyth.utildroid.util.Util
import java.io.File

class Initializer(val packageName: String) {

    private fun basePackage(p: String): String {
        var projectLocation = Util.currentDir.plus(Global.Directory.ANDROID_PROJECT)
        val packages = p.split("\\.".toRegex())
        for (domain in packages) {
            projectLocation = projectLocation.plus("/").plus(domain)
        }
        return projectLocation
    }

    fun packagePrepared(className: String): HashMap<String, String> {
        val packageCollection = HashMap<String, String>()

        var addNewPackage = ""
        var addNewPackage1 = ""
        val index = className.lastIndexOf(".")
        for (t in className.substring(0, index).split("\\.".toRegex())) {
            addNewPackage = addNewPackage.plus("/").plus(t)
            addNewPackage1 = addNewPackage1.plus(".").plus(t)
        }

        val cn = className.substring(index + 1)

        val path = basePackage(packageName)
                .plus("/")
                .plus(addNewPackage).plus("/")
                .plus(cn)
                .plus("/")

        val fullPackage = packageName.plus(addNewPackage1).plus(".").plus(cn)

        println(addNewPackage)
        println(addNewPackage1)
        println(cn)
        println(fullPackage)

        val projectPath = File(path)

        val layoutPath = File(Util.currentDir
                        .plus("/")
                        .plus(Global.Directory.ANDROID_RES)
                        .plus("/"))

        if (!layoutPath.exists()) layoutPath.mkdirs()
        if (!projectPath.exists()) projectPath.mkdirs()

        //val rootPackage = packageName.substring(0, packageName.indexOf(packageName.split("\\.".toRegex())[packageName.split("\\.".toRegex()).size-1])-1)
        packageCollection.put(Global.Key.DIRECTORY, path)
        packageCollection.put(Global.Key.ROOT_PACKAGE, packageName)
        packageCollection.put(Global.Key.PACKAGE, fullPackage)
        return packageCollection
    }
}