package app.isfaaghyth.utildroid

import app.isfaaghyth.utildroid.util.Global

fun main(args: Array<String>) {
    Main(args)
}

class Main(args: Array<String>) {

    init {
        var option = "--activity"
        val basePackage = "isfa.ganteng.banget"
        val appPackage = "ui.dialog.authAdmin"

        when (option) {
            "--fragment" -> option = Global.Prefix.FRAGMENT
            "--activity" -> option = Global.Prefix.ACTIVITY
        }

        App(basePackage, appPackage)
                .generate(option, Global.Ext.Kt)
                .mvp()
                .layout()
    }

}