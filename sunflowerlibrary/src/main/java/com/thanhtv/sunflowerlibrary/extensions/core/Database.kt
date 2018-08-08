package com.thanhtv.sunflowerlibrary.extensions.core

import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper


inline fun SQLiteOpenHelper.transaction(action: SQLiteDatabase.() -> Unit) {
    writableDatabase.transaction(action)
}

inline fun SQLiteDatabase.transaction(action: SQLiteDatabase.() -> Unit) {
    beginTransaction()
    try {
        action(this)
        setTransactionSuccessful()
    } finally {
        endTransaction()
    }
}