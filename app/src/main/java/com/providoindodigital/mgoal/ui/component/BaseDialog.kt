package com.providoindodigital.mgoal.ui.component

import android.app.Dialog
import android.content.Context
import android.os.Build
import android.view.Window
import java.lang.Exception


open class BaseDialog(paramContext: Context) :
    Dialog(paramContext) {
    protected var mContext: Context

    init {
        mContext = paramContext
        try {
            if (Build.VERSION.SDK_INT >= 21) {
                val window: Window? = window
                window?.decorView?.systemUiVisibility = 1280
                window?.addFlags(-2147483648)
                window?.statusBarColor = 0
            }
            window!!.addFlags(67108864)
        } catch (exception: Exception) {
            exception.printStackTrace()
        }
    }

//    override fun dismiss() {
//        super.dismiss()
//        if (BaseApplication.getSpUtil().getBoolean("SOUND", true)) SoundUtils.playSoundShort(
//            mContext,
//            2131623937
//        )
//    }
}
