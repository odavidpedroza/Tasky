package com.tasky.session

import android.content.Context
import android.content.SharedPreferences
import com.tasky.R

class SessionManager(context: Context): ISessionManager {
    private var prefs: SharedPreferences = context.getSharedPreferences(context.getString(R.string.app_name), Context.MODE_PRIVATE)

    private companion object {
        const val USER_TOKEN = "user_token"
    }

    override fun saveAuthToken(token: String) {
        val editor = prefs.edit()
        editor.putString(USER_TOKEN, token)
        editor.apply()
    }

    override fun fetchAuthToken(): String? {
        return prefs.getString(USER_TOKEN, null)
    }

    override fun clearToken() {
        prefs.edit().clear().apply()
    }
}