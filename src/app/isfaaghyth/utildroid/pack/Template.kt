package app.isfaaghyth.utildroid.pack

import app.isfaaghyth.utildroid.util.empty
import app.isfaaghyth.utildroid.util.Global

object Template {

    fun templateName(prefix: String): String = when (prefix) {
        Global.Prefix.FRAGMENT  -> Global.Template.FRAGMENT
        Global.Prefix.PRESENTER -> Global.Template.Mvp.Presenter
        Global.Prefix.VIEW      -> Global.Template.Mvp.View
        Global.Prefix.ACTIVITY  -> Global.Template.ACTIVITY
        else -> String().empty()
    }

}