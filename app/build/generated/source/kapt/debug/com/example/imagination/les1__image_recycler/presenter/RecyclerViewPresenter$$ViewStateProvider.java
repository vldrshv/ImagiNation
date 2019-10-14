package com.example.imagination.les1__image_recycler.presenter;

import com.example.imagination.les1__image_recycler.view.PhotoView$$State;
import java.lang.Override;
import moxy.MvpView;
import moxy.ViewStateProvider;
import moxy.viewstate.MvpViewState;

public class RecyclerViewPresenter$$ViewStateProvider extends ViewStateProvider {
	@Override
	public MvpViewState<? extends MvpView> getViewState() {
		return new PhotoView$$State();
	}
}
