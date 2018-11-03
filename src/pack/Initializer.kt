package pack

import util.Global

class Initializer {
    fun currentDir(): String {
        return System.getProperty(Global.System.DIR_PROPERTY)
    }

    fun packageNamePrepared(packageName: String) {
        val packages = packageName.split(".")
        var temp = "${currentDir()}${Global.Directory.ANDROID_INIT}"
        for (test in packages) {
            temp = "$temp/$test"
        }
        println(temp)
    }
}