package app.isfaaghyth.utildroid.util

import java.io.InputStream
import java.time.LocalDateTime
import java.time.format.DateTimeFormatter

object Util {

    //your project directory
    //@example: /home/username/projects/name
    val currentPath: String = System.getProperty(Global.System.DIR_PROPERTY)

    //get current time now
    fun timeNow(): String {
        val current = LocalDateTime.now()
        val formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss")
        return current.format(formatter)
    }

    fun template(name: String): InputStream {
        return javaClass.getResourceAsStream("/$name")
    }

    fun toLayoutName(appPackage: String, prefix: String): String {
        val className = toClassName(appPackage, prefix)
        val regex = "(?<=[a-z])(?=[A-Z])".toRegex()
        var layoutName = ""
        for (name in className.split(regex).reversed()) {
            layoutName += name.toLowerCase() + "_"
        }
        return layoutName.substring(0, layoutName.length - 1)
    }

    fun toClassName(appPackage: String, prefix: String): String {
        val index = appPackage.lastIndexOf(".")
        return appPackage.substring(index + 1)
                .capitalize()
                .plus(prefix.capitalize())
    }


}