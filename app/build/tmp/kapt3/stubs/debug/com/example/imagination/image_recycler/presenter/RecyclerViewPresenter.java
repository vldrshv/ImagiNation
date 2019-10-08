package com.example.imagination.image_recycler.presenter;

import java.lang.System;

@kotlin.Metadata(mv = {1, 1, 15}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001:\u0001\u0006B\u0005\u00a2\u0006\u0002\u0010\u0002J\u0006\u0010\u0005\u001a\u00020\u0004R\u0010\u0010\u0003\u001a\u0004\u0018\u00010\u0004X\u0082\u000e\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0007"}, d2 = {"Lcom/example/imagination/image_recycler/presenter/RecyclerViewPresenter;", "", "()V", "presenter", "Lcom/example/imagination/image_recycler/presenter/RecyclerViewPresenter$MainPresenter;", "getPresenter", "MainPresenter", "app_debug"})
public final class RecyclerViewPresenter {
    private com.example.imagination.image_recycler.presenter.RecyclerViewPresenter.MainPresenter presenter;
    
    @org.jetbrains.annotations.NotNull()
    public final com.example.imagination.image_recycler.presenter.RecyclerViewPresenter.MainPresenter getPresenter() {
        return null;
    }
    
    public RecyclerViewPresenter() {
        super();
    }
    
    @kotlin.Metadata(mv = {1, 1, 15}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002J\u0010\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000bH\u0016J\b\u0010\f\u001a\u00020\rH\u0016R\u0014\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u000e"}, d2 = {"Lcom/example/imagination/image_recycler/presenter/RecyclerViewPresenter$MainPresenter;", "Lcom/example/imagination/image_recycler/presenter/IRecyclerViewPresenter;", "()V", "photoList", "", "Lcom/example/imagination/image_recycler/model/PhotoModel;", "photoPresenter", "Lcom/example/imagination/image_recycler/presenter/PhotoPresenter;", "bindView", "", "iViewHolder", "Lcom/example/imagination/image_recycler/view/IViewHolder;", "getItemCount", "", "app_debug"})
    public static final class MainPresenter implements com.example.imagination.image_recycler.presenter.IRecyclerViewPresenter {
        private final com.example.imagination.image_recycler.presenter.PhotoPresenter photoPresenter = null;
        private final java.util.List<com.example.imagination.image_recycler.model.PhotoModel> photoList = null;
        
        @java.lang.Override()
        public void bindView(@org.jetbrains.annotations.NotNull()
        com.example.imagination.image_recycler.view.IViewHolder iViewHolder) {
        }
        
        @java.lang.Override()
        public int getItemCount() {
            return 0;
        }
        
        public MainPresenter() {
            super();
        }
    }
}