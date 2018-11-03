package util

import java.time.LocalDateTime
import java.time.format.DateTimeFormatter

object Util {
    val currentDir = System.getProperty(Global.System.DIR_PROPERTY)

    fun getTimeNow(): String {
        val current = LocalDateTime.now()
        val formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss")
        return current.format(formatter)
    }
}