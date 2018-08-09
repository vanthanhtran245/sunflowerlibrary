package com.thanhtv.sunflowerlibrary

import android.os.Bundle
import com.thanhtv.sunflowerlibrary.base.view.BaseActivity
import com.thanhtv.sunflowerlibrary.extensions.core.restart

class MainActivity : BaseActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }
}
