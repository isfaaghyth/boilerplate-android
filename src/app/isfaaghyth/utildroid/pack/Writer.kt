package app.isfaaghyth.utildroid.pack

import app.isfaaghyth.utildroid.util.Util
import java.io.File

class Writer(val className: String,
             val packageName: String,
             val fullPackage: String,
             val layoutName: String) {

    fun generator(file: String): String {
        var template = Util.template(file).bufferedReader().use {
            template -> template.readText()
        }

        val replace = mapOf(
                "~CLASS" to className,
                "~ROOT_PACKAGE" to packageName,
                "~PACKAGE" to fullPackage,
                "~TIME" to Util.timeNow(),
                "~LAYOUT" to layoutName
        )

        replace.forEach { base, new ->
            template = template.replace(base, new).trim()
        }

        return template
    }

    fun create(file: File, template: String) {
        file.writeText(generator(template))
        println("[DONE] Class -> $file")
    }

}