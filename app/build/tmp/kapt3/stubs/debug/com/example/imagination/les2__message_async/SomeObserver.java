package com.example.imagination.les2__message_async;

import java.lang.System;

@kotlin.Metadata(mv = {1, 1, 15}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002J\u0006\u0010\f\u001a\u00020\rJ\u0010\u0010\u000e\u001a\u00020\r2\u0006\u0010\u000f\u001a\u00020\u0004H\u0016R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082D\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u001a\u0010\u0006\u001a\u00020\u0007X\u0096\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\b\u0010\t\"\u0004\b\n\u0010\u000b\u00a8\u0006\u0010"}, d2 = {"Lcom/example/imagination/les2__message_async/SomeObserver;", "Lcom/example/imagination/les2__message_async/Observer;", "()V", "CLASS_TAG", "", "message", "spamEnabled", "", "getSpamEnabled", "()Z", "setSpamEnabled", "(Z)V", "changeSpamStatus", "", "updateData", "s", "app_debug"})
public final class SomeObserver implements com.example.imagination.les2__message_async.Observer {
    private final java.lang.String CLASS_TAG = "SomeObserver";
    private java.lang.String message;
    private boolean spamEnabled;
    
    @java.lang.Override()
    public boolean getSpamEnabled() {
        return false;
    }
    
    @java.lang.Override()
    public void setSpamEnabled(boolean p0) {
    }
    
    @java.lang.Override()
    public void updateData(@org.jetbrains.annotations.NotNull()
    java.lang.String s) {
    }
    
    public final void changeSpamStatus() {
    }
    
    public SomeObserver() {
        super();
    }
}