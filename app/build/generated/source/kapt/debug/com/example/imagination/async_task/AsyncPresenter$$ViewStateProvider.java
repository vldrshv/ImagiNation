package com.example.imagination.async_task;

import java.lang.Override;
import moxy.MvpView;
import moxy.ViewStateProvider;
import moxy.viewstate.MvpViewState;

public class AsyncPresenter$$ViewStateProvider extends ViewStateProvider {
	@Override
	public MvpViewState<? extends MvpView> getViewState() {
		return new IAsyncView$$State();
	}
}
