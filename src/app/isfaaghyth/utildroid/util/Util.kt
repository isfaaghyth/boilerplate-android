package app.isfaaghyth.utildroid.util

import java.io.InputStream
import java.time.LocalDateTime
import java.time.format.DateTimeFormatter

object Util {

    val currentPath: String = System.getProperty(Global.System.DIR_PROPERTY)

    fun test() {
        println("featurePackage -> ${"isfa.ganteng".substring(0, "isfa.ganteng".lastIndexOf("."))}")
        println("featureIndexOf -> ${"isfa.ganteng".lastIndexOf(".")}")
    }

    fun timeNow(): String {
        val current = LocalDateTime.now()
        val formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss")
        return current.format(formatter)
    }

    fun layoutName(file: String): String {
        var layoutName = ""
        for (name in file.split("(?<=[a-z])(?=[A-Z])".toRegex()).reversed()) {
            layoutName += name.toLowerCase() + "_"
        }
        return layoutName.substring(0, layoutName.length - 1)
    }

    fun template(name: String): InputStream {
        return javaClass.getResourceAsStream("/$name")
    }

}