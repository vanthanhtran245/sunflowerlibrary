package com.thanhtv.sunflowerlibrary.base.presenter

import com.thanhtv.sunflowerlibrary.base.interactor.MVPInteractor
import com.thanhtv.sunflowerlibrary.base.view.MVPView

/**
 * Created by thanhtv on 04/01/18.
 */
interface MVPPresenter<V : MVPView, I : MVPInteractor> {

    fun onAttach(view: V?)

    fun onDetach()

    fun getView(): V?

}