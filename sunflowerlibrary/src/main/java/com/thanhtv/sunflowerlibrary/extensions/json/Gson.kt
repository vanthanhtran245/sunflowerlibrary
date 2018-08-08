package com.thanhtv.sunflowerlibrary.extensions.json

import com.google.gson.Gson
import com.google.gson.JsonElement
import com.google.gson.TypeAdapter
import com.google.gson.reflect.TypeToken
import com.google.gson.stream.JsonReader
import com.google.gson.stream.JsonWriter
import java.io.Reader

/**
 * User: mcxiaoke
 * Date: 16/1/30
 * Time: 11:43
 */

inline fun <reified T : Any> Gson.getAdapter(): TypeAdapter<T>
        = this.getAdapter(object : TypeToken<T>() {})

inline fun <reified T : Any> Gson.fromJson(json: Reader): T
        = this.fromJson(json, typeToken<T>())

inline fun <reified T : Any> Gson.fromJson(json: JsonReader): T
        = this.fromJson(json, typeToken<T>())

inline fun <reified T : Any> Gson.fromJson(json: JsonElement): T
        = this.fromJson(json, typeToken<T>())

inline fun <reified T : Any> Gson.toJson(src: Any): String
        = this.toJson(src, typeToken<T>())

inline fun <reified T : Any> Gson.toJson(src: Any, writer: Appendable): Unit
        = this.toJson(src, typeToken<T>(), writer)

inline fun <reified T : Any> Gson.toJson(src: Any, writer: JsonWriter): Unit
        = this.toJson(src, typeToken<T>(), writer)