package com.example.imagination.image_recycler.view;

import java.lang.Override;
import java.lang.String;
import moxy.viewstate.MvpViewState;
import moxy.viewstate.ViewCommand;
import moxy.viewstate.strategy.SingleStateStrategy;

public class PhotoView$$State extends MvpViewState<PhotoView> implements PhotoView {
	@Override
	public void showToast(String s) {
		ShowToastCommand showToastCommand = new ShowToastCommand(s);
		mViewCommands.beforeApply(showToastCommand);

		if (hasNotView()) {
			return;
		}

		for (PhotoView view : mViews) {
			view.showToast(s);
		}

		mViewCommands.afterApply(showToastCommand);
	}

	public class ShowToastCommand extends ViewCommand<PhotoView> {
		public final String s;

		ShowToastCommand(String s) {
			super("showToast", SingleStateStrategy.class);

			this.s = s;
		}

		@Override
		public void apply(PhotoView mvpView) {
			mvpView.showToast(s);
		}
	}
}
