package com.shvants.balinatestapp.domain.mvp.presenter

import android.view.MenuItem
import androidx.core.view.GravityCompat
import androidx.drawerlayout.widget.DrawerLayout
import com.shvants.balinatestapp.R
import com.shvants.balinatestapp.domain.mvp.contract.MainContract
import com.shvants.balinatestapp.presentation.fragment.MapFragment
import com.shvants.balinatestapp.presentation.fragment.PhotosFragment
import kotlinx.coroutines.CoroutineScope

class MainPresenter : MainContract.Presenter, CoroutineScope {

    private var view: MainContract.View? = null

    override fun attachView(view: MainContract.View) {
        this.view = view
    }

    override fun detachView() {
        view = null
    }

    override fun navigationItemSelected(item: MenuItem, drawerLayout: DrawerLayout) {
        val fragment =
            if (item.itemId == R.id.nav_photos) PhotosFragment.INSTANCE else MapFragment.INSTANCE
        view?.setCheckedItem(item)
        view?.replaceFragment(fragment)
        drawerLayout.closeDrawer(GravityCompat.START)
    }
}