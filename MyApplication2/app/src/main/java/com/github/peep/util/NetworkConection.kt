package com.peep.githubapitest.util

import android.content.Context
import android.net.ConnectivityManager

class NetworkConection {

    companion object {
        fun isNetworkConnected(context: Context): Boolean {

            var connectionManager = context.getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager
            val activeNetworkInfo = connectionManager.activeNetworkInfo

            return activeNetworkInfo != null && activeNetworkInfo.isConnectedOrConnecting
        }
    }
}