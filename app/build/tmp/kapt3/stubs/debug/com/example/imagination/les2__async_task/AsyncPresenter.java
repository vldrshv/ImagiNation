package com.example.imagination.les2__async_task;

import java.lang.System;

@kotlin.Metadata(mv = {1, 1, 15}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\b\u0007\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001\u0015B\u0005\u00a2\u0006\u0002\u0010\u0003J\u0006\u0010\u0010\u001a\u00020\u0011J\b\u0010\u0012\u001a\u00020\u0013H\u0002J\u0006\u0010\u0014\u001a\u00020\u0011R\u001a\u0010\u0004\u001a\u00020\u0005X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR\u001a\u0010\n\u001a\u00020\u000bX\u0086.\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000f\u00a8\u0006\u0016"}, d2 = {"Lcom/example/imagination/les2__async_task/AsyncPresenter;", "Lmoxy/MvpPresenter;", "Lcom/example/imagination/les2__async_task/IAsyncView;", "()V", "logList", "Lcom/example/imagination/les2__async_task/LogList;", "getLogList", "()Lcom/example/imagination/les2__async_task/LogList;", "setLogList", "(Lcom/example/imagination/les2__async_task/LogList;)V", "task", "Lcom/example/imagination/les2__async_task/AsyncPresenter$MyAsyncTask;", "getTask", "()Lcom/example/imagination/les2__async_task/AsyncPresenter$MyAsyncTask;", "setTask", "(Lcom/example/imagination/les2__async_task/AsyncPresenter$MyAsyncTask;)V", "execute", "", "getLog", "", "stopAsyncTask", "MyAsyncTask", "app_debug"})
@moxy.InjectViewState()
public final class AsyncPresenter extends moxy.MvpPresenter<com.example.imagination.les2__async_task.IAsyncView> {
    @org.jetbrains.annotations.NotNull()
    public com.example.imagination.les2__async_task.AsyncPresenter.MyAsyncTask task;
    @org.jetbrains.annotations.NotNull()
    private com.example.imagination.les2__async_task.LogList logList;
    
    @org.jetbrains.annotations.NotNull()
    public final com.example.imagination.les2__async_task.AsyncPresenter.MyAsyncTask getTask() {
        return null;
    }
    
    public final void setTask(@org.jetbrains.annotations.NotNull()
    com.example.imagination.les2__async_task.AsyncPresenter.MyAsyncTask p0) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final com.example.imagination.les2__async_task.LogList getLogList() {
        return null;
    }
    
    public final void setLogList(@org.jetbrains.annotations.NotNull()
    com.example.imagination.les2__async_task.LogList p0) {
    }
    
    public final void stopAsyncTask() {
    }
    
    private final java.lang.String getLog() {
        return null;
    }
    
    public final void execute() {
    }
    
    public AsyncPresenter() {
        super();
    }
    
    @kotlin.Metadata(mv = {1, 1, 15}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\u0011\n\u0002\b\u0005\u0018\u00002\u0014\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00040\u0001B\u0005\u00a2\u0006\u0002\u0010\u0005J%\u0010\u0006\u001a\u00020\u00042\u0016\u0010\u0007\u001a\f\u0012\b\b\u0001\u0012\u0004\u0018\u00010\u00020\b\"\u0004\u0018\u00010\u0002H\u0014\u00a2\u0006\u0002\u0010\tJ%\u0010\n\u001a\u00020\u00042\u0016\u0010\u000b\u001a\f\u0012\b\b\u0001\u0012\u0004\u0018\u00010\u00030\b\"\u0004\u0018\u00010\u0003H\u0014\u00a2\u0006\u0002\u0010\f\u00a8\u0006\r"}, d2 = {"Lcom/example/imagination/les2__async_task/AsyncPresenter$MyAsyncTask;", "Landroid/os/AsyncTask;", "Lcom/example/imagination/les2__async_task/LogList;", "", "", "()V", "doInBackground", "params", "", "([Lcom/example/imagination/les2__async_task/LogList;)V", "onProgressUpdate", "text", "([Ljava/lang/String;)V", "app_debug"})
    public static final class MyAsyncTask extends android.os.AsyncTask<com.example.imagination.les2__async_task.LogList, java.lang.String, kotlin.Unit> {
        
        @java.lang.Override()
        protected void doInBackground(@org.jetbrains.annotations.NotNull()
        com.example.imagination.les2__async_task.LogList... params) {
        }
        
        @java.lang.Override()
        protected void onProgressUpdate(@org.jetbrains.annotations.NotNull()
        java.lang.String... text) {
        }
        
        public MyAsyncTask() {
            super();
        }
    }
}