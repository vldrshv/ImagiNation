package com.example.imagination.text_viewer.view;

import java.lang.System;

@kotlin.Metadata(mv = {1, 1, 15}, bv = {1, 0, 3}, k = 1, d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u00012\u00020\u00022\u00020\u0003B\u0005\u00a2\u0006\u0002\u0010\u0004J\u0012\u0010\r\u001a\u00020\u000e2\b\u0010\u000f\u001a\u0004\u0018\u00010\u0010H\u0016J\u0012\u0010\u0011\u001a\u00020\u000e2\b\u0010\u0012\u001a\u0004\u0018\u00010\u0013H\u0014J\u0010\u0010\u0014\u001a\u00020\u000e2\u0006\u0010\u0015\u001a\u00020\u0006H\u0016R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082D\u00a2\u0006\u0002\n\u0000R\u001e\u0010\u0007\u001a\u00020\b8\u0006@\u0006X\u0087.\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\t\u0010\n\"\u0004\b\u000b\u0010\f\u00a8\u0006\u0016"}, d2 = {"Lcom/example/imagination/text_viewer/view/TextViewActivity;", "Lmoxy/MvpAppCompatActivity;", "Landroid/view/View$OnClickListener;", "Lcom/example/imagination/text_viewer/IView;", "()V", "CLASS_TAG", "", "textViewPresenter", "Lcom/example/imagination/text_viewer/presenter/TextViewPresenter;", "getTextViewPresenter", "()Lcom/example/imagination/text_viewer/presenter/TextViewPresenter;", "setTextViewPresenter", "(Lcom/example/imagination/text_viewer/presenter/TextViewPresenter;)V", "onClick", "", "v", "Landroid/view/View;", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "setText", "text", "app_debug"})
public final class TextViewActivity extends moxy.MvpAppCompatActivity implements android.view.View.OnClickListener, com.example.imagination.text_viewer.IView {
    private final java.lang.String CLASS_TAG = "TextViewActivity";
    @org.jetbrains.annotations.NotNull()
    @moxy.presenter.InjectPresenter()
    public com.example.imagination.text_viewer.presenter.TextViewPresenter textViewPresenter;
    private java.util.HashMap _$_findViewCache;
    
    @org.jetbrains.annotations.NotNull()
    public final com.example.imagination.text_viewer.presenter.TextViewPresenter getTextViewPresenter() {
        return null;
    }
    
    public final void setTextViewPresenter(@org.jetbrains.annotations.NotNull()
    com.example.imagination.text_viewer.presenter.TextViewPresenter p0) {
    }
    
    @java.lang.Override()
    protected void onCreate(@org.jetbrains.annotations.Nullable()
    android.os.Bundle savedInstanceState) {
    }
    
    @java.lang.Override()
    public void onClick(@org.jetbrains.annotations.Nullable()
    android.view.View v) {
    }
    
    @java.lang.Override()
    public void setText(@org.jetbrains.annotations.NotNull()
    java.lang.String text) {
    }
    
    public TextViewActivity() {
        super();
    }
}