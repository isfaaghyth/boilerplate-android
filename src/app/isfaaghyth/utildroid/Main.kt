package app.isfaaghyth.utildroid

import app.isfaaghyth.utildroid.util.Global

fun main(args: Array<String>) {
    App("com.isfa", "login")
            .generate(Global.Prefix.FRAGMENT)
            .mvp()
            .layout()
}