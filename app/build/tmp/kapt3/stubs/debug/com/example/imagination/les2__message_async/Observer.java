package com.example.imagination.les2__message_async;

import java.lang.System;

@kotlin.Metadata(mv = {1, 1, 15}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\bf\u0018\u00002\u00020\u0001J\u0010\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000bH&R\u0018\u0010\u0002\u001a\u00020\u0003X\u00a6\u000e\u00a2\u0006\f\u001a\u0004\b\u0004\u0010\u0005\"\u0004\b\u0006\u0010\u0007\u00a8\u0006\f"}, d2 = {"Lcom/example/imagination/les2__message_async/Observer;", "", "spamEnabled", "", "getSpamEnabled", "()Z", "setSpamEnabled", "(Z)V", "updateData", "", "s", "", "app_debug"})
public abstract interface Observer {
    
    public abstract boolean getSpamEnabled();
    
    public abstract void setSpamEnabled(boolean p0);
    
    public abstract void updateData(@org.jetbrains.annotations.NotNull()
    java.lang.String s);
}