package com.example.imagination.les2__message_async;

import java.lang.System;

@kotlin.Metadata(mv = {1, 1, 15}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H&J\u0010\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0005\u001a\u00020\u0006H&J\u0010\u0010\u0007\u001a\u00020\u00032\u0006\u0010\u0005\u001a\u00020\u0006H&\u00a8\u0006\b"}, d2 = {"Lcom/example/imagination/les2__message_async/Observable;", "", "notifyAllObservers", "", "subscribe", "observer", "Lcom/example/imagination/les2__message_async/Observer;", "unsubscribe", "app_debug"})
public abstract interface Observable {
    
    public abstract void subscribe(@org.jetbrains.annotations.NotNull()
    com.example.imagination.les2__message_async.Observer observer);
    
    public abstract void unsubscribe(@org.jetbrains.annotations.NotNull()
    com.example.imagination.les2__message_async.Observer observer);
    
    public abstract void notifyAllObservers();
}