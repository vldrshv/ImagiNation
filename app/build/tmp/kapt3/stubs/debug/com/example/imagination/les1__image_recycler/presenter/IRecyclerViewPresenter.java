package com.example.imagination.les1__image_recycler.presenter;

import java.lang.System;

@kotlin.Metadata(mv = {1, 1, 15}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&J\u0010\u0010\u0006\u001a\u00020\u00032\u0006\u0010\u0007\u001a\u00020\bH&J\b\u0010\t\u001a\u00020\bH&\u00a8\u0006\n"}, d2 = {"Lcom/example/imagination/les1__image_recycler/presenter/IRecyclerViewPresenter;", "", "bindView", "", "iViewHolder", "Lcom/example/imagination/les1__image_recycler/view/IViewHolder;", "clicked", "pos", "", "getItemCount", "app_debug"})
public abstract interface IRecyclerViewPresenter {
    
    public abstract void bindView(@org.jetbrains.annotations.NotNull()
    com.example.imagination.les1__image_recycler.view.IViewHolder iViewHolder);
    
    public abstract int getItemCount();
    
    public abstract void clicked(int pos);
}