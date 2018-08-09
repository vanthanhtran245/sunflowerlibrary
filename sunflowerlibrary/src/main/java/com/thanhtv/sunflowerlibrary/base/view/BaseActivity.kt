package com.thanhtv.sunflowerlibrary.base.view

import android.app.ProgressDialog
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.widget.Toast
import com.thanhtv.sunflowerlibrary.utils.CommonUtil
import com.valdesekamdem.library.mdtoast.MDToast
import dagger.android.AndroidInjection

/**
 * Created by thanhtv on 04/01/18.
 */
abstract class BaseActivity : AppCompatActivity(), MVPView {

    private var progressDialog: ProgressDialog? = null
    protected var fragmentCallBack: BaseFragment.CallBack? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        performDI()
    }

    override fun hideProgress() {
        progressDialog?.let { if (it.isShowing) it.cancel() }
    }

    override fun showProgress() {
        hideProgress()
        progressDialog = CommonUtil.showLoadingDialog(this)
    }

    private fun performDI() = AndroidInjection.inject(this)


    fun showSuccessMessage(msg: String) {
        MDToast.makeText(this, msg, Toast.LENGTH_LONG, MDToast.TYPE_SUCCESS).show()
    }

    fun showWarningMessage(msg: String) {
        MDToast.makeText(this, msg, Toast.LENGTH_LONG, MDToast.TYPE_WARNING).show()
    }

    fun showErrorgMessage(msg: String) {
        MDToast.makeText(this, msg, Toast.LENGTH_LONG, MDToast.TYPE_ERROR).show()
    }
}