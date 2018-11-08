package app.isfaaghyth.utildroid.pack

import app.isfaaghyth.utildroid.entity.Packager
import app.isfaaghyth.utildroid.util.Global
import app.isfaaghyth.utildroid.util.Util
import java.io.File

class Initializer(private val basePackage: String,
                  private val appPackage: String) {

    //current directory
    private val currentPath = Util.currentPath

    //@example: your.package.name.fragment.main
    private var fullPackage: String = ""

    //@example: /project/app/src/main/java/your/package/name/fragment/main/
    private var fullPath: String = ""

    private val INVALID_CODE = 0

    private fun valid(): Boolean =
            appPackage.contains(".") &&
            !appPackage.contains("\\s".toRegex())

    /**
     * featureIndexOf & featurePackage
     * for preparing to generate a new package based on the name of the base class
     * @example: your/package/name/fragment/main/
     * @result: main
     */
    private var featureIndexOf = if (valid()) {
        appPackage.lastIndexOf(".")
    } else {
        INVALID_CODE
    }

    //example: getting "main" from an example above
    private var featurePackage = if (valid()) {
        appPackage.substring(featureIndexOf + 1)
    } else {
        INVALID_CODE.toString()
    }

    init {
        //change to lowercase for package's name standardization
        basePackage.toLowerCase()
        appPackage.toLowerCase()

        /**
         * featureBasePackage is preparing the sub-package for your class
         * @example: /ui/main/fragment/...
          */
        val featureBasePackage = appPackage.substring(0, featureIndexOf)
        for (appPackage in featureBasePackage.split("\\.".toRegex())) {
            fullPackage = fullPackage.plus(".").plus(appPackage)
            fullPath = fullPath.plus("/").plus(appPackage)
        }

        //.toLowerCase() for best-practice of package name
        //fullPath = /location/your/project/
        fullPath = "${basePath()}/$fullPath/${featurePackage.toLowerCase()}/"

        //fullPackage = project.domain.name
        fullPackage = "$basePackage$fullPackage.$featurePackage"

        isDirectory()
    }

    /**
     * isDirectory()
     * ensure the project directory correctly
     */
    private fun isDirectory() {
        val projectPath = File(fullPath)
        val layoutPath = File("$currentPath/${Global.Directory.ANDROID_RES}/")
        if (!layoutPath.exists()) {
            //@TODO: throw Exception("uh no! You entered the wrong package.")
            layoutPath.mkdirs()
        }
        if (!projectPath.exists()) {
            //@TODO: throw Exception("uh no! You entered the wrong package.")
            projectPath.mkdirs()
        }
    }

    /**
     * basePath()
     * base location of java files for android projects including project package directory
     * @example: /path/to/project/app/src/main/java/your/package/name
     */
    private fun basePath(): String {
        var javaPath = currentPath.plus(Global.Directory.ANDROID_PROJECT)
        for (domain in basePackage.split("\\.".toRegex())) {
            javaPath = javaPath.plus("/").plus(domain)
        }
        return javaPath
    }


    fun pack(): Packager {
        return Packager(
                basePackage = basePackage,
                featurePackage = fullPackage,
                projectPath = fullPath
        )
    }
}