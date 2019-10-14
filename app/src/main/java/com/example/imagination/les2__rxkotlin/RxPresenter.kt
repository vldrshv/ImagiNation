package com.example.imagination.les2__rxkotlin

import android.util.Log
import io.reactivex.Observable
import io.reactivex.ObservableOnSubscribe
import io.reactivex.Observer
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.Disposable
import io.reactivex.schedulers.Schedulers

class RxPresenter (view: ActivityView) {
    private val CLASS_TAG = "RxPresenter"

    lateinit var disposable: Disposable
    private lateinit var observable: Observable<String>
    private var messageChannel: MessageChannel = MessageChannel()
    private lateinit var activityView: ActivityView

    init {
        observable = createObservable()
        this.activityView = view
    }

    fun subscribe() {
        observable.observeOn(AndroidSchedulers.mainThread()).subscribe (object: Observer<String> {
            override fun onSubscribe(d: Disposable) {
                this@RxPresenter.disposable = d
            }

            override fun onNext(it: String) {
                Log.i(CLASS_TAG, "onNext + $it")
                Log.d(CLASS_TAG, "onNext: " + Thread.currentThread().name);
                activityView.setText(it)
            }

            override fun onError(e: Throwable) {
                e.printStackTrace()
            }

            override fun onComplete() {
                Log.i(CLASS_TAG, "onComplete")
            }

        })
        Log.d(CLASS_TAG, "subscribe: end " + Thread.currentThread().getName());
    }

    fun unsubscribe() {
        disposable.dispose()
    }

    private fun createObservable() : Observable<String> {
        Log.i(CLASS_TAG, "create observable")
        return Observable.create(ObservableOnSubscribe<String>
            { emitter ->  messageChannel.words.forEach {
                    try {
                        emitter.onNext(it)
                        Thread.sleep(2000)
                    } catch (e: InterruptedException) {
                        Log.e(CLASS_TAG, "INTERRUPTED")
                    }
                }
            })
            .subscribeOn(Schedulers.io())
    }
}