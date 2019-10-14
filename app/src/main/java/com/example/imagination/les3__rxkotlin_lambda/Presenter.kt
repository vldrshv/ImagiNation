package com.example.imagination.les3__rxkotlin_lambda

import android.annotation.SuppressLint
import android.util.Log
import com.example.imagination.les2__rxkotlin.ActivityView
import io.reactivex.Observable
import io.reactivex.ObservableOnSubscribe
import io.reactivex.Observer
import io.reactivex.Scheduler
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.Disposable
import io.reactivex.observers.DisposableObserver
import io.reactivex.schedulers.Schedulers

class Presenter (activityView: ActivityView){
    private val CLASS_TAG = "Presenter"
    private val words: ArrayList<String> = arrayListOf<String>(
        " many", " people", " like", " coding", " but", " not", " all",
        " do", " it", " in", " clean", " way")

    private var _activityView: ActivityView = activityView
    private var observable: Observable<String>
    private lateinit var disposable: Disposable
    private var message = ""
    private var messageThread = Thread(Runnable {
        while (true) {
            message = generateMessage()
            Log.d(CLASS_TAG, "THREAD generated message: \"$message\"")
            Thread.sleep(1000)
        }
    })

    init {
        observable = createObservable()
        messageThread.start()
    }

    @SuppressLint("CheckResult")
    fun subscribe() {
        observable.observeOn(AndroidSchedulers.mainThread()).subscribe(
            { it: String -> _activityView.setText(it) },
            {t: Throwable? ->  t!!.printStackTrace()},
            { Log.i(CLASS_TAG, "COMPLETED")},
            {t: Disposable? ->  this@Presenter.disposable = t!!}
        )
    }

//    SUBSCRIBE на стероидах сверху (лямбды), ниже нативное переопределение
//
//    fun subscribe() {
//    observable.observeOn(AndroidSchedulers.mainThread()).subscribe (object: Observer<String> {
//        override fun onSubscribe(d: Disposable) {
//            this@Presenter.disposable = d
//        }
//
//        override fun onNext(it: String) {
//            Log.i(CLASS_TAG, "onNext + $it")
//            Log.d(CLASS_TAG, "onNext: " + Thread.currentThread().name);
//            _activityView.setText(it)
//        }
//
//        override fun onError(e: Throwable) {
//            e.printStackTrace()
//        }
//
//        override fun onComplete() {
//            Log.i(CLASS_TAG, "onComplete")
//        }
//
//    })
//    Log.d(CLASS_TAG, "subscribe: end " + Thread.currentThread().getName());
//}

    fun unsubscribe() {
        disposable.dispose()
    }

    private fun createObservable(): Observable<String> {
        return Observable.create(
            ObservableOnSubscribe<String> {
                    emitter ->
                try {
                    while (!emitter.isDisposed) {
                        emitter.onNext(message)
                        Thread.sleep(1000)
                    }
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