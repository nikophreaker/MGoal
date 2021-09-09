package com.providoindodigital.mgoal.utils

import android.content.Context
import android.widget.ImageView
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.BindingAdapter
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentTransaction
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProviders
import com.squareup.picasso.Picasso
import com.squareup.picasso.RequestCreator

//fun AppCompatActivity.setupActionBar(@IdRes toolbarId: Int, action: ActionBar.() -> Unit) {
//    setSupportActionBar(findViewById(toolbarId))
//    supportActionBar?.run {
//        action()
//    }
//}
fun AppCompatActivity.replaceFragmentInActivity(fragment: Fragment, frameId: Int){
    supportFragmentManager.transact {
        replaceFragmentInActivity(fragment,frameId)
    }
}
private inline fun FragmentManager.transact(action: () -> Unit) { // must be appv4 maybe
    beginTransaction().apply {
        action()
    }.commit()
}
fun <T : ViewModel> AppCompatActivity.obtainViewModel(viewModelClass: Class<T>) =
    ViewModelProviders.of(this, ViewModelFactory.getInstance(application)).get(viewModelClass)

fun AppCompatActivity.addFragmentToActivity(fragment: Fragment, tag: String) {
    supportFragmentManager.transact {
        addFragmentToActivity(fragment, tag)
    }
}

val Context.picasso: Picasso
    get() = Picasso.get()

fun ImageView.load(path: String, request: (RequestCreator) -> RequestCreator){
    request(context.picasso.load(path)).into(this)
}
@BindingAdapter("imageUrl")
fun loadImage(view: ImageView, url:String?) {
    if (url != null) {
        view.load(url) { requestCreator -> requestCreator.fit().centerCrop() }
    }
}
