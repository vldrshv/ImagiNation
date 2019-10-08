package com.example.imagination.image_recycler.presenter;

import java.lang.System;

@kotlin.Metadata(mv = {1, 1, 15}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\b\u0007\u0018\u00002\u00020\u00012\b\u0012\u0004\u0012\u00020\u00030\u0002B\u0005\u00a2\u0006\u0002\u0010\u0004J\u0010\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000eH\u0016J\u0010\u0010\u000f\u001a\u00020\f2\u0006\u0010\u0010\u001a\u00020\u0011H\u0016J\b\u0010\u0012\u001a\u00020\u0011H\u0016J\u0010\u0010\u0013\u001a\u00020\f2\u0006\u0010\u0010\u001a\u00020\u0011H\u0002R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u001e\u0010\u0007\u001a\u0012\u0012\u0004\u0012\u00020\t0\bj\b\u0012\u0004\u0012\u00020\t`\nX\u0082\u000e\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0014"}, d2 = {"Lcom/example/imagination/image_recycler/presenter/RecyclerViewPresenter;", "Lcom/example/imagination/image_recycler/presenter/IRecyclerViewPresenter;", "Lmoxy/MvpPresenter;", "Lcom/example/imagination/image_recycler/view/PhotoView;", "()V", "clickedPhoto", "Lcom/example/imagination/image_recycler/model/ClickedPhoto;", "photoList", "Ljava/util/ArrayList;", "Lcom/example/imagination/image_recycler/model/PhotoModel;", "Lkotlin/collections/ArrayList;", "bindView", "", "iViewHolder", "Lcom/example/imagination/image_recycler/view/IViewHolder;", "clicked", "pos", "", "getItemCount", "setPosition", "app_debug"})
@moxy.InjectViewState()
public final class RecyclerViewPresenter extends moxy.MvpPresenter<com.example.imagination.image_recycler.view.PhotoView> implements com.example.imagination.image_recycler.presenter.IRecyclerViewPresenter {
    private java.util.ArrayList<com.example.imagination.image_recycler.model.PhotoModel> photoList;
    private com.example.imagination.image_recycler.model.ClickedPhoto clickedPhoto;
    
    @java.lang.Override()
    public void bindView(@org.jetbrains.annotations.NotNull()
    com.example.imagination.image_recycler.view.IViewHolder iViewHolder) {
    }
    
    @java.lang.Override()
    public int getItemCount() {
        return 0;
    }
    
    private final void setPosition(int pos) {
    }
    
    @java.lang.Override()
    public void clicked(int pos) {
    }
    
    public RecyclerViewPresenter() {
        super();
    }
}