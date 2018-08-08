package com.thanhtv.sunflowerlibrary

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import com.thanhtv.sunflowerlibrary.extensions.core.restart

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        this.restart()
    }
}
