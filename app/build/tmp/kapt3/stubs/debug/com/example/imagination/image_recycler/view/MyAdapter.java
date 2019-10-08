package com.example.imagination.image_recycler.view;

import java.lang.System;

@kotlin.Metadata(mv = {1, 1, 15}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001\u0010B\r\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u00a2\u0006\u0002\u0010\u0005J\b\u0010\u0006\u001a\u00020\u0007H\u0016J\u0018\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u00022\u0006\u0010\u000b\u001a\u00020\u0007H\u0016J\u0018\u0010\f\u001a\u00020\u00022\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u0007H\u0016R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u000e\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0011"}, d2 = {"Lcom/example/imagination/image_recycler/view/MyAdapter;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Lcom/example/imagination/image_recycler/view/MyAdapter$MyViewHolder;", "iRecyclerMainPresenter", "Lcom/example/imagination/image_recycler/presenter/IRecyclerViewPresenter;", "(Lcom/example/imagination/image_recycler/presenter/IRecyclerViewPresenter;)V", "getItemCount", "", "onBindViewHolder", "", "holder", "position", "onCreateViewHolder", "parent", "Landroid/view/ViewGroup;", "viewType", "MyViewHolder", "app_debug"})
public final class MyAdapter extends androidx.recyclerview.widget.RecyclerView.Adapter<com.example.imagination.image_recycler.view.MyAdapter.MyViewHolder> {
    private com.example.imagination.image_recycler.presenter.IRecyclerViewPresenter iRecyclerMainPresenter;
    
    @org.jetbrains.annotations.NotNull()
    @java.lang.Override()
    public com.example.imagination.image_recycler.view.MyAdapter.MyViewHolder onCreateViewHolder(@org.jetbrains.annotations.NotNull()
    android.view.ViewGroup parent, int viewType) {
        return null;
    }
    
    @java.lang.Override()
    public int getItemCount() {
        return 0;
    }
    
    @java.lang.Override()
    public void onBindViewHolder(@org.jetbrains.annotations.NotNull()
    com.example.imagination.image_recycler.view.MyAdapter.MyViewHolder holder, int position) {
    }
    
    public MyAdapter(@org.jetbrains.annotations.NotNull()
    com.example.imagination.image_recycler.presenter.IRecyclerViewPresenter iRecyclerMainPresenter) {
        super();
    }
    
    @kotlin.Metadata(mv = {1, 1, 15}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u00012\u00020\u0002B\r\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u00a2\u0006\u0002\u0010\u0005J\b\u0010\b\u001a\u00020\tH\u0016J\u0010\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\tH\u0016R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u000e\u00a2\u0006\u0002\n\u0000\u00a8\u0006\r"}, d2 = {"Lcom/example/imagination/image_recycler/view/MyAdapter$MyViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "Lcom/example/imagination/image_recycler/view/IViewHolder;", "itemView", "Landroid/view/View;", "(Landroid/view/View;)V", "image", "Landroid/widget/ImageView;", "getPos", "", "setImageOne", "", "imageId", "app_debug"})
    public static final class MyViewHolder extends androidx.recyclerview.widget.RecyclerView.ViewHolder implements com.example.imagination.image_recycler.view.IViewHolder {
        private android.widget.ImageView image;
        
        @java.lang.Override()
        public void setImageOne(int imageId) {
        }
        
        @java.lang.Override()
        public int getPos() {
            return 0;
        }
        
        public MyViewHolder(@org.jetbrains.annotations.NotNull()
        android.view.View itemView) {
            super(null);
        }
    }
}