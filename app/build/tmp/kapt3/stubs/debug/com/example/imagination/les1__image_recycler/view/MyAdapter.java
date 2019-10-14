package com.example.imagination.les1__image_recycler.view;

import java.lang.System;

@kotlin.Metadata(mv = {1, 1, 15}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001\u0013B\r\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u00a2\u0006\u0002\u0010\u0005J\b\u0010\t\u001a\u00020\nH\u0016J\u0018\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u00022\u0006\u0010\u000e\u001a\u00020\nH\u0017J\u0018\u0010\u000f\u001a\u00020\u00022\u0006\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\nH\u0016R\u001a\u0010\u0003\u001a\u00020\u0004X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\u0005\u00a8\u0006\u0014"}, d2 = {"Lcom/example/imagination/les1__image_recycler/view/MyAdapter;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Lcom/example/imagination/les1__image_recycler/view/MyAdapter$MyViewHolder;", "recyclerViewPresenter", "Lcom/example/imagination/les1__image_recycler/presenter/RecyclerViewPresenter;", "(Lcom/example/imagination/les1__image_recycler/presenter/RecyclerViewPresenter;)V", "getRecyclerViewPresenter", "()Lcom/example/imagination/les1__image_recycler/presenter/RecyclerViewPresenter;", "setRecyclerViewPresenter", "getItemCount", "", "onBindViewHolder", "", "holder", "position", "onCreateViewHolder", "parent", "Landroid/view/ViewGroup;", "viewType", "MyViewHolder", "app_debug"})
public final class MyAdapter extends androidx.recyclerview.widget.RecyclerView.Adapter<com.example.imagination.les1__image_recycler.view.MyAdapter.MyViewHolder> {
    @org.jetbrains.annotations.NotNull()
    private com.example.imagination.les1__image_recycler.presenter.RecyclerViewPresenter recyclerViewPresenter;
    
    @org.jetbrains.annotations.NotNull()
    @java.lang.Override()
    public com.example.imagination.les1__image_recycler.view.MyAdapter.MyViewHolder onCreateViewHolder(@org.jetbrains.annotations.NotNull()
    android.view.ViewGroup parent, int viewType) {
        return null;
    }
    
    @java.lang.Override()
    public int getItemCount() {
        return 0;
    }
    
    @java.lang.Override()
    @moxy.viewstate.strategy.StateStrategyType(value = moxy.viewstate.strategy.SingleStateStrategy.class)
    public void onBindViewHolder(@org.jetbrains.annotations.NotNull()
    com.example.imagination.les1__image_recycler.view.MyAdapter.MyViewHolder holder, int position) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final com.example.imagination.les1__image_recycler.presenter.RecyclerViewPresenter getRecyclerViewPresenter() {
        return null;
    }
    
    public final void setRecyclerViewPresenter(@org.jetbrains.annotations.NotNull()
    com.example.imagination.les1__image_recycler.presenter.RecyclerViewPresenter p0) {
    }
    
    public MyAdapter(@org.jetbrains.annotations.NotNull()
    com.example.imagination.les1__image_recycler.presenter.RecyclerViewPresenter recyclerViewPresenter) {
        super();
    }
    
    @kotlin.Metadata(mv = {1, 1, 15}, bv = {1, 0, 3}, k = 1, d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u00012\u00020\u00022\u00020\u0003B\u0015\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u00a2\u0006\u0002\u0010\bJ\b\u0010\u000f\u001a\u00020\u0010H\u0016J\u0012\u0010\u0011\u001a\u00020\u00122\b\u0010\u0013\u001a\u0004\u0018\u00010\u0005H\u0016J\b\u0010\u0014\u001a\u00020\u0012H\u0016J\u0010\u0010\u0015\u001a\u00020\u00122\u0006\u0010\u0016\u001a\u00020\u0010H\u0016R\u000e\u0010\t\u001a\u00020\nX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u001a\u0010\u0006\u001a\u00020\u0007X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000e\u00a8\u0006\u0017"}, d2 = {"Lcom/example/imagination/les1__image_recycler/view/MyAdapter$MyViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "Lcom/example/imagination/les1__image_recycler/view/IViewHolder;", "Landroid/view/View$OnClickListener;", "itemView", "Landroid/view/View;", "presenter", "Lcom/example/imagination/les1__image_recycler/presenter/RecyclerViewPresenter;", "(Landroid/view/View;Lcom/example/imagination/les1__image_recycler/presenter/RecyclerViewPresenter;)V", "image", "Landroid/widget/ImageView;", "getPresenter", "()Lcom/example/imagination/les1__image_recycler/presenter/RecyclerViewPresenter;", "setPresenter", "(Lcom/example/imagination/les1__image_recycler/presenter/RecyclerViewPresenter;)V", "getPos", "", "onClick", "", "v", "setGrayBackground", "setImageOne", "imageId", "app_debug"})
    public static final class MyViewHolder extends androidx.recyclerview.widget.RecyclerView.ViewHolder implements com.example.imagination.les1__image_recycler.view.IViewHolder, android.view.View.OnClickListener {
        private android.widget.ImageView image;
        @org.jetbrains.annotations.NotNull()
        private com.example.imagination.les1__image_recycler.presenter.RecyclerViewPresenter presenter;
        
        @java.lang.Override()
        public void setImageOne(int imageId) {
        }
        
        @java.lang.Override()
        public void setGrayBackground() {
        }
        
        @java.lang.Override()
        public int getPos() {
            return 0;
        }
        
        @java.lang.Override()
        public void onClick(@org.jetbrains.annotations.Nullable()
        android.view.View v) {
        }
        
        @org.jetbrains.annotations.NotNull()
        public final com.example.imagination.les1__image_recycler.presenter.RecyclerViewPresenter getPresenter() {
            return null;
        }
        
        public final void setPresenter(@org.jetbrains.annotations.NotNull()
        com.example.imagination.les1__image_recycler.presenter.RecyclerViewPresenter p0) {
        }
        
        public MyViewHolder(@org.jetbrains.annotations.NotNull()
        android.view.View itemView, @org.jetbrains.annotations.NotNull()
        com.example.imagination.les1__image_recycler.presenter.RecyclerViewPresenter presenter) {
            super(null);
        }
    }
}