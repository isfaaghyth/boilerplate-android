package app.isfaaghyth.utildroid.pack

import app.isfaaghyth.utildroid.util.Global

object Template {

    fun templateName(prefix: String): String = when {
        prefix == Global.Prefix.FRAGMENT -> "fragment.template"
        prefix == Global.Prefix.PRESENTER -> "mvppresenter.template"
        prefix == Global.Prefix.VIEW -> "mvpview.template"
        else -> ""
    }

}