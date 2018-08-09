package com.thanhtv.sunflowerlibrary.base.presenter

import com.thanhtv.sunflowerlibrary.utils.SchedulerProvider
import com.thanhtv.sunflowerlibrary.base.interactor.MVPInteractor
import com.thanhtv.sunflowerlibrary.base.view.MVPView
import io.reactivex.disposables.CompositeDisposable

/**
 * Created by thanhtv on 04/01/18.
 */
abstract class BasePresenter<V : MVPView, I : MVPInteractor> internal constructor(protected var interactor: I?, protected val schedulerProvider: SchedulerProvider, protected val compositeDisposable: CompositeDisposable) : MVPPresenter<V, I> {

    private var view: V? = null
    private val isViewAttached: Boolean get() = view != null

    override fun onAttach(view: V?) {
        this.view = view
    }

    override fun getView(): V? = view

    override fun onDetach() {
        compositeDisposable.dispose()
        view = null
        interactor = null
    }

}