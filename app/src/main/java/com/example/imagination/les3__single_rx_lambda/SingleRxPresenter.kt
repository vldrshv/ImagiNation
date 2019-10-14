package com.example.imagination.les3__single_rx_lambda

import android.util.Log
import com.example.imagination.les2__rxkotlin.ActivityView
import io.reactivex.Observable
import io.reactivex.ObservableOnSubscribe
import io.reactivex.Single
import io.reactivex.SingleOnSubscribe
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.Disposable
import io.reactivex.observers.DisposableSingleObserver
import io.reactivex.schedulers.Schedulers

class SingleRxPresenter(activityView: ActivityView) {
    private val CLASS_TAG = "SingleRxPresenter"
    private val words: ArrayList<String> = arrayListOf<String>(
        " many", " people", " like", " coding", " but", " not", " all",
        " do", " it", " in", " clean", " way")

    private var _activityView: ActivityView = activityView
    private lateinit var single: Single<String>
    private var message = ""
    private var messageThread = Thread(Runnable {
        while (true) {
            message = generateMessage()
            Log.d(CLASS_TAG, "THREAD generated message: \"$message\"")
            Thread.sleep(1000)
        }
    })
    private var observable: Observable<String>
    private lateinit var disposable: Disposable

    init {
        observable = createObservable()
        messageThread.start()
    }

    fun getMessage() {
        disposable = observable.subscribe(
            {it: String -> _activityView.setText(it)},
            {t: Throwable? ->  t!!.printStackTrace()},
            {Log.i(CLASS_TAG, "onComplete()")})
    }

    private fun createObservable(): Observable<String> {
        return Observable.create(
            ObservableOnSubscribe<String> {
                    emitter ->
                try {
//                    while (!emitter.isDisposed) {
                        emitter.onNext(message + "\n")
                        Thread.sleep(1000)
//                    }
                } catch (e: InterruptedException) {
                    e.printStackTrace()
                } }
        ).subscribeOn(Schedulers.io())
    }

    private fun generateMessage(): String {
        var randInd: Int
        var s = ""
        for (i in 0..(words.size/2)) {
            randInd = (Math.random() * 100 % words.size).toInt()
            s += words[randInd]
        }

        return s
    }
}