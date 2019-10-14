package com.example.imagination.les2__async_task

import android.os.AsyncTask
import android.util.Log
import moxy.InjectViewState
import moxy.MvpPresenter
import java.lang.Exception
import java.util.*

@InjectViewState
class AsyncPresenter : MvpPresenter<IAsyncView>() {

    lateinit var task: MyAsyncTask
    var logList : LogList = LogList()

    fun stopAsyncTask() {
        Log.i("ASYNC", "presenter <- click()")
        task.cancel(true)
    }

    private fun getLog(): String {
        var s = "";
        logList.forEach{ s += it }

        return s
    }

    fun execute() {
        if(!::task.isInitialized || task.status != AsyncTask.Status.RUNNING) {
            task = MyAsyncTask()
            task.execute(logList)
            logList.add("<b>Task starts pending, saving log</b>")
            logList.add("<br>")
            viewState.setText(getLog())
        } else {
            stopAsyncTask()
            logList.add("<b>Task stopped pending, log loaded</b>")
            logList.add("<br>")
            viewState.setText(getLog())
        }
    }


    class MyAsyncTask : AsyncTask<LogList, String, Unit>() {
        override fun doInBackground(vararg params: LogList?) {
            Log.i("TASK", "-> begin")
            while(true) {
                try {
                    if (isCancelled)
                        break

                    publishProgress("Start sleeping")
                    Thread.sleep(1000)
                    publishProgress("Stop sleeping")
                    for (i in 0..5) {
                        val log = "--- $i ${Thread.currentThread().name} --- " + GregorianCalendar().time.toString() + "\n"
                        publishProgress(log)
                        params[0]!!.add(log)
                    }
                } catch (e: Exception) {
                    e.printStackTrace()
                }
            }
        }
        override fun onProgressUpdate(vararg text: String?) {
            Log.i("TASK", text[0])
        }
    }
}