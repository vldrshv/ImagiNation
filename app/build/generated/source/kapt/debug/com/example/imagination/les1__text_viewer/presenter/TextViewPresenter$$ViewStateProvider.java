package com.example.imagination.les1__text_viewer.presenter;

import com.example.imagination.les1__text_viewer.IView$$State;
import java.lang.Override;
import moxy.MvpView;
import moxy.ViewStateProvider;
import moxy.viewstate.MvpViewState;

public class TextViewPresenter$$ViewStateProvider extends ViewStateProvider {
	@Override
	public MvpViewState<? extends MvpView> getViewState() {
		return new IView$$State();
	}
}
