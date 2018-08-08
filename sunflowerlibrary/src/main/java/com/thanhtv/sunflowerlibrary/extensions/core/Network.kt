package com.thanhtv.sunflowerlibrary.extensions.core

import android.content.Context
import android.net.ConnectivityManager


enum class NetworkType {
    WIFI, MOBILE, OTHER, NONE
}

fun Context.networkTypeName(): String {
    var result = "(No Network)"
    try {
        val cm = this.getConnectivityManager()
        val info = cm.activeNetworkInfo
        if (info == null || !info.isConnectedOrConnecting) {
            return result
        }
        result = info.typeName
        if (info.type == ConnectivityManager.TYPE_MOBILE) {
            result += info.subtypeName
        }
    } catch (ignored: Throwable) {
    }
    return result
}

fun Context.networkOperator(): String {
    val tm = this.getTelephonyManager()
    return tm.networkOperator
}

fun Context.networkType(): NetworkType {
    val cm = this.getConnectivityManager()
    val info = cm.activeNetworkInfo
    if (info == null || !info.isConnectedOrConnecting) {
        return NetworkType.NONE
    }
    val type = info.type
    if (ConnectivityManager.TYPE_WIFI == type) {
        return NetworkType.WIFI
    } else if (ConnectivityManager.TYPE_MOBILE == type) {
        return NetworkType.MOBILE
    } else {
        return NetworkType.OTHER
    }
}

fun Context.isWifi(): Boolean {
    return networkType() == NetworkType.WIFI
}

fun Context.isMobile(): Boolean {
    return networkType() == NetworkType.MOBILE
}

fun Context.isConnected(): Boolean {
    val cm = this.getConnectivityManager()
    val info = cm.activeNetworkInfo
    return info != null && info.isConnectedOrConnecting
}
