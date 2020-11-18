package com.shvants.balinatestapp.domain.mvp.contract

import android.view.MenuItem
import androidx.drawerlayout.widget.DrawerLayout
import androidx.fragment.app.Fragment
import com.shvants.balinatestapp.domain.mvp.presenter.BasePresenter

interface MainContract {

    interface View {
        fun replaceFragment(fragment: Fragment)
        fun setCheckedItem(item: MenuItem)
    }

    interface Presenter : BasePresenter<View> {
        fun navigationItemSelected(item: MenuItem, drawerLayout: DrawerLayout)
    }
}