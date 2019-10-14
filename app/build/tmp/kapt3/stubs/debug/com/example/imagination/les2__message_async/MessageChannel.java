package com.example.imagination.les2__message_async;

import java.lang.System;

@kotlin.Metadata(mv = {1, 1, 15}, bv = {1, 0, 3}, k = 1, d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002J\b\u0010\u0013\u001a\u00020\u0014H\u0002J\b\u0010\u0015\u001a\u00020\u0014H\u0016J\u0010\u0010\u0016\u001a\u00020\u00142\u0006\u0010\u0017\u001a\u00020\fH\u0016J\u0010\u0010\u0018\u001a\u00020\u00142\u0006\u0010\u0017\u001a\u00020\fH\u0016R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082D\u00a2\u0006\u0002\n\u0000R\u001a\u0010\u0005\u001a\u00020\u0004X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR\u001e\u0010\n\u001a\u0012\u0012\u0004\u0012\u00020\f0\u000bj\b\u0012\u0004\u0012\u00020\f`\rX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u000fX\u0082\u000e\u00a2\u0006\u0002\n\u0000R!\u0010\u0010\u001a\u0012\u0012\u0004\u0012\u00020\u00040\u000bj\b\u0012\u0004\u0012\u00020\u0004`\r\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012\u00a8\u0006\u0019"}, d2 = {"Lcom/example/imagination/les2__message_async/MessageChannel;", "Lcom/example/imagination/les2__message_async/Observable;", "()V", "CLASS_TAG", "", "message", "getMessage", "()Ljava/lang/String;", "setMessage", "(Ljava/lang/String;)V", "observers", "Ljava/util/ArrayList;", "Lcom/example/imagination/les2__message_async/Observer;", "Lkotlin/collections/ArrayList;", "thread", "Ljava/lang/Thread;", "words", "getWords", "()Ljava/util/ArrayList;", "generateMessage", "", "notifyAllObservers", "subscribe", "observer", "unsubscribe", "app_debug"})
public final class MessageChannel implements com.example.imagination.les2__message_async.Observable {
    private final java.lang.String CLASS_TAG = "MessageChannel";
    @org.jetbrains.annotations.NotNull()
    private final java.util.ArrayList<java.lang.String> words = null;
    @org.jetbrains.annotations.NotNull()
    private java.lang.String message;
    private java.util.ArrayList<com.example.imagination.les2__message_async.Observer> observers;
    private java.lang.Thread thread;
    
    @org.jetbrains.annotations.NotNull()
    public final java.util.ArrayList<java.lang.String> getWords() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String getMessage() {
        return null;
    }
    
    public final void setMessage(@org.jetbrains.annotations.NotNull()
    java.lang.String p0) {
    }
    
    private final void generateMessage() {
    }
    
    @java.lang.Override()
    public void subscribe(@org.jetbrains.annotations.NotNull()
    com.example.imagination.les2__message_async.Observer observer) {
    }
    
    @java.lang.Override()
    public void unsubscribe(@org.jetbrains.annotations.NotNull()
    com.example.imagination.les2__message_async.Observer observer) {
    }
    
    @java.lang.Override()
    public void notifyAllObservers() {
    }
    
    public MessageChannel() {
        super();
    }
}