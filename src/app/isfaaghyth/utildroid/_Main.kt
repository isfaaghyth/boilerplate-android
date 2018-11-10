package app.isfaaghyth.utildroid

import app.isfaaghyth.utildroid.util.Global

fun main(args: Array<String>) {
    _Main(args)
}

class _Main(args: Array<String>) {

    init {
        var option = args[1]
        val basePackage = args[0]
        val paramPackage = args[2]

        option = when (option) {
            "--fragment" -> Global.Prefix.FRAGMENT
            "--activity" -> Global.Prefix.ACTIVITY
            else -> throw Exception("only supported fragment and activity")
        }

        App(basePackage, paramPackage)
                .generate(option, Global.Ext.Kt)
                .mvp()
                .layout()
    }

}