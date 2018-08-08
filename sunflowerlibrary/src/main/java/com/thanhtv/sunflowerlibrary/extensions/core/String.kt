package com.thanhtv.sunflowerlibrary.extensions.core

import com.thanhtv.sunflowerlibrary.extensions.Const
import com.thanhtv.sunflowerlibrary.extensions.Encoding
import java.io.File
import java.io.UnsupportedEncodingException
import java.net.URLDecoder
import java.util.*

/**
 * User: mcxiaoke
 * Date: 16/1/22
 * Time: 13:35
 */

fun String.quote(): String {
    return "'$this'"
}

fun CharSequence.isBlank(): Boolean {
    val len: Int = this.length
    if (len == 0) {
        return true
    }
    forEach { c ->
        if (!Character.isWhitespace(c)) {
            return false
        }
    }
    return true
}

fun String.toHexBytes(): ByteArray {
    val len = this.length
    val data = ByteArray(len / 2)
    var i = 0
    while (i < len) {
        data[i / 2] = ((Character.digit(this[i], 16) shl 4)
                + Character.digit(this[i + 1], 16)).toByte()
        i += 2
    }
    return data
}



fun String.withoutQuery(): String {
    return this.split("\\?".toRegex()).dropLastWhile { it.isEmpty() }.toTypedArray()[0]
}

fun String?.isNameSafe(): Boolean {
    // Note, we check whether it matches what's known to be safe,
    // rather than what's known to be unsafe.  Non-ASCII, control
    // characters, etc. are all unsafe by default.
    if (this == null) {
        return false
    }
    return Const.SAFE_FILENAME_PATTERN.matcher(this).matches()
}

fun String.toSafeFileName(): String {
    val size = this.length
    val builder = StringBuilder(size * 2)
    forEachIndexed { i, c ->
        var valid = c in 'a'..'z'
        valid = valid || c in 'A'..'Z'
        valid = valid || c in '0'..'9'
        valid = valid || c == '_' || c == '-' || c == '.'

        if (valid) {
            builder.append(c)
        } else {
            // Encode the character using hex notation
            builder.append('x')
            builder.append(Integer.toHexString(i))
        }
    }
    return builder.toString()
}

fun String.toQueries(): Map<String, String> {
    val map: Map<String, String> = mapOf()
    if (this.isEmpty()) {
        return map
    }
    try {
        val queries = HashMap<String, String>()
        for (param in this.split("&".toRegex()).dropLastWhile { it.isEmpty() }.toTypedArray()) {
            val pair = param.split("=".toRegex()).dropLastWhile { it.isEmpty() }.toTypedArray()
            val key = URLDecoder.decode(pair[0], Encoding.UTF_8)
            if (pair.size > 1) {
                val value = URLDecoder.decode(pair[1], Encoding.UTF_8)
                queries.put(key, value)
            }
        }
        return queries
    } catch (ex: UnsupportedEncodingException) {
        throw RuntimeException(ex)
    }

}

@JvmOverloads
fun String.toStringList(delimiters: String = "?",
                        trimTokens: Boolean = true,
                        ignoreEmptyTokens: Boolean = true): List<String> {
    val st = StringTokenizer(this, delimiters)
    val tokens = ArrayList<String>()
    while (st.hasMoreTokens()) {
        var token = st.nextToken()
        if (trimTokens) {
            token = token.trim { it <= ' ' }
        }
        if (!ignoreEmptyTokens || token.isNotEmpty()) {
            tokens.add(token)
        }
    }
    return tokens
}

@JvmOverloads
fun String.toStringArray(delimiters: String = "?",
                         trimTokens: Boolean = true,
                         ignoreEmptyTokens: Boolean = true): Array<String> {
    return toStringList(delimiters, trimTokens, ignoreEmptyTokens).toTypedArray()
}


fun String.trimLeadingCharacter(leadingCharacter: Char): String {
    if (this.isEmpty()) {
        return this
    }
    val sb = StringBuilder(this)
    while (sb.isNotEmpty() && sb[0] == leadingCharacter) {
        sb.deleteCharAt(0)
    }
    return sb.toString()
}

fun String.trimTrailingCharacter(trailingCharacter: Char): String {
    if (this.isEmpty()) {
        return this
    }
    val sb = StringBuilder(this)
    while (sb.isNotEmpty() && sb[sb.length - 1] == trailingCharacter) {
        sb.deleteCharAt(sb.length - 1)
    }
    return sb.toString()
}

fun String.trimAllWhitespace(): String {
    if (this.isEmpty()) {
        return this
    }
    val sb = StringBuilder(this)
    var index = 0
    while (sb.length > index) {
        if (Character.isWhitespace(sb[index])) {
            sb.deleteCharAt(index)
        } else {
            index++
        }
    }
    return sb.toString()
}

fun CharSequence.containsWhitespace(): Boolean {
    if (this.isEmpty()) {
        return false
    }
    forEach { c ->
        if (Character.isWhitespace(c)) {
            return true
        }
    }
    return false
}


fun String.fileNameWithoutExtension(): String {
    if (isEmpty()) {
        return this
    }

    var filePath = this
    val extenPosi = filePath.lastIndexOf(Const.FILE_EXTENSION_SEPARATOR)
    val filePosi = filePath.lastIndexOf(File.separator)
    if (filePosi == -1) {
        return if (extenPosi == -1) filePath else filePath.substring(0, extenPosi)
    }
    if (extenPosi == -1) {
        return filePath.substring(filePosi + 1)
    }
    return if (filePosi < extenPosi) filePath.substring(filePosi + 1, extenPosi)
    else filePath.substring(filePosi + 1)
}

fun String.fileName(): String {
    if (isEmpty()) {
        return this
    }

    var filePath = this
    val filePosi = filePath.lastIndexOf(File.separator)
    return if (filePosi == -1) filePath else filePath.substring(filePosi + 1)
}

fun String.fileExtension(): String {
    if (isEmpty()) {
        return this
    }
    var filePath = this
    val extenPosi = filePath.lastIndexOf(Const.FILE_EXTENSION_SEPARATOR)
    val filePosi = filePath.lastIndexOf(File.separator)
    if (extenPosi == -1) {
        return ""
    }
    return if (filePosi >= extenPosi) "" else filePath.substring(extenPosi + 1)
}
