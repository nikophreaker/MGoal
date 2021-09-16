package com.providoindodigital.mgoal.utils

import android.content.Context
import java.util.*

object SessionManagerUtil {
    private const val SESSION_PREFERENCES =
        "com.providoindodigital.mgoal.session_manager.SESSION_PREFERENCES"
    private const val SESSION_EXPIRY_TIME =
        "com.providoindodigital.mgoal.session_manager.SESSION_EXPIRY_TIME"
    private const val SESSION_TOKEN = "com.providoindodigital.mgoal.session_manager.SESSION_TOKEN"
    private const val SESSION_EMAIL = "com.providoindodigital.mgoal.session_manager.SESSION_EMAIL"
    private const val SESSION_PWD = "com.providoindodigital.mgoal.session_manager.SESSION_PWD"

    fun startUserSession(context: Context, expiresIn: Int) {
        val calendar = Calendar.getInstance()
        val userLoggedInTime = calendar.time
        calendar.time = userLoggedInTime
        calendar.add(Calendar.SECOND, expiresIn)
        val expiryTime = calendar.time
        val tokenSharedPreferences = context.getSharedPreferences(SESSION_PREFERENCES, 0)
        val editor = tokenSharedPreferences.edit()
        editor.putLong(SESSION_EXPIRY_TIME, expiryTime.time)
        editor.apply()
    }

    fun isSessionActive(currentTime: Date, context: Context): Boolean {
        val sessionExpiresAt = Date(getExpiryDateFromPreferences(context)!!)
        return !currentTime.after(sessionExpiresAt)
    }

    private fun getExpiryDateFromPreferences(context: Context): Long? {
        return context.getSharedPreferences(SESSION_PREFERENCES, 0).getLong(SESSION_EXPIRY_TIME, 0)
    }

    fun storeUserToken(context: Context, token: String) {
        val tokenEditor = context.getSharedPreferences(SESSION_PREFERENCES, 0).edit()
        tokenEditor.putString(SESSION_TOKEN, token)
        tokenEditor.apply()
    }

    fun storeUserEmail(context: Context, email: String) {
        val emailEditor = context.getSharedPreferences(SESSION_PREFERENCES, 0).edit()
        emailEditor.putString(SESSION_EMAIL, email)
        emailEditor.apply()
    }

    fun storeUserPwd(context: Context, pwd: String) {
        val pwdEditor = context.getSharedPreferences(SESSION_PREFERENCES, 0).edit()
        pwdEditor.putString(SESSION_PWD, pwd)
        pwdEditor.apply()
    }

    fun getUserToken(context: Context): String? {
        return context.getSharedPreferences(SESSION_PREFERENCES, 0).getString(SESSION_TOKEN, "")
    }

    fun getUserEmail(context: Context): String? {
        return context.getSharedPreferences(SESSION_PREFERENCES, 0).getString(SESSION_EMAIL, "")
    }

    fun getUserPwd(context: Context): String? {
        return context.getSharedPreferences(SESSION_PREFERENCES, 0).getString(SESSION_PWD, "")
    }

    fun endUserSession(context: Context) {
        clearStoredData(context)
    }

    private fun clearStoredData(context: Context) {
        val editor = context.getSharedPreferences(SESSION_PREFERENCES, 0).edit()
        editor.clear()
        editor.apply()
    }

}