package app.isfaaghyth.utildroid.pack

import app.isfaaghyth.utildroid.util.Global

object Template {

    fun templateName(prefix: String): String = when (prefix) {
        Global.Prefix.FRAGMENT -> "fragment.template"
        Global.Prefix.PRESENTER -> "mvppresenter.template"
        Global.Prefix.VIEW -> "mvpview.template"
        Global.Prefix.ACTIVITY -> "activity.template"
        else -> ""
    }

}