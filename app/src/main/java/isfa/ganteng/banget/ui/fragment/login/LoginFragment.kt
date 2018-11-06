package isfa.ganteng.banget.ui.fragment.login

import android.view.View
import isfa.ganteng.banget.R
import isfa.ganteng.banget.base.BaseFragment

/**
 * Created by isfaaghyth on 2018-11-07 01:22:39.
 * github: @isfaaghyth
 */
class LoginFragment: BaseFragment<LoginFragmentPresenter>(), LoginFragmentView {

    override fun presenter(): LoginFragmentPresenter = LoginFragmentPresenter(this)
    override fun contentView(): Int = R.layout.fragment_login

    override fun onCreated(view: View) {

    }

}