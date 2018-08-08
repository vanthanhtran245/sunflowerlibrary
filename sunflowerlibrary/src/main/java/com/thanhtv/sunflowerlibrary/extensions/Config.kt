package com.thanhtv.sunflowerlibrary.extensions

import android.util.Log
import java.nio.charset.Charset
import java.util.regex.Pattern

/**
 * Created by thanhtran on 11/21/17.
 */

object Encoding {

    const val ISO_8859_1 = "ISO-8859-1"
    const val US_ASCII = "US-ASCII"
    const val UTF_16 = "UTF-16"
    const val UTF_16BE = "UTF-16BE"
    const val UTF_16LE = "UTF-16LE"
    const val UTF_8 = "UTF-8"
    val CHARSET_ISO_8859_1: Charset = Charset.forName(ISO_8859_1)
    val CHARSET_US_ASCII: Charset = Charset.forName(US_ASCII)
    val CHARSET_UTF_16: Charset = Charset.forName(UTF_16)
    val CHARSET_UTF_16BE: Charset = Charset.forName(UTF_16BE)
    val CHARSET_UTF_16LE: Charset = Charset.forName(UTF_16LE)
    val CHARSET_UTF_8: Charset = Charset.forName(UTF_8)
}

object UserDefault {
    const val KEY_LANGUAGE = "key_language"
    const val ACCESS_TOKEN = "accessToken"
    const val X_USER_NAME = "xusername"
}

object GlobalDefine {
    const val ENGLISH_LANGUAGE = "en"
    const val KHMER_LANGUAGE = "km"
}


object Const {
    const val FILENAME_NOMEDIA = ".nomedia"
    const val HEAP_SIZE_LARGE = 48 * 1024 * 1024
    const val LINE_SEPARATOR = "\n"
    const val FILE_EXTENSION_SEPARATOR = "."
    const val RESERVED_CHARS = "|\\?*<\":>+[]/'"
    @JvmField
    val HEX_DIGITS = "0123456789ABCDEF".toCharArray()
    @JvmField
    val SAFE_FILENAME_PATTERN: Pattern = Pattern.compile("[\\w%+,./=_-]+")
}

class LogLevel {
    companion object {
        var logLevel = Log.ASSERT
        var logEnabled: Boolean
            get() {
                return logLevel < Log.ASSERT
            }
            set(value) {
                logLevel = if (value) Log.VERBOSE else Log.ASSERT
            }
    }
}


fun threadName(): String = Thread.currentThread().name

inline fun doIf(condition: Boolean?, action: () -> Unit) {
    if (condition == true) action()
}

inline fun doIf(condition: () -> Boolean?, action: () -> Unit) {
    if (condition() == true) action()
}

inline fun doIf(any: Any?, action: () -> Unit) {
    if (any != null) action()
}

inline fun stringEmpty(): String {
    return ""
}