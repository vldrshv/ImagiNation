package com.example.imagination.async_task;

import java.lang.Override;
import java.lang.String;
import moxy.viewstate.MvpViewState;
import moxy.viewstate.ViewCommand;
import moxy.viewstate.strategy.AddToEndSingleStrategy;

public class IAsyncView$$State extends MvpViewState<IAsyncView> implements IAsyncView {
	@Override
	public void setText(String s) {
		SetTextCommand setTextCommand = new SetTextCommand(s);
		mViewCommands.beforeApply(setTextCommand);

		if (hasNotView()) {
			return;
		}

		for (IAsyncView view : mViews) {
			view.setText(s);
		}

		mViewCommands.afterApply(setTextCommand);
	}

	public class SetTextCommand extends ViewCommand<IAsyncView> {
		public final String s;

		SetTextCommand(String s) {
			super("setText", AddToEndSingleStrategy.class);

			this.s = s;
		}

		@Override
		public void apply(IAsyncView mvpView) {
			mvpView.setText(s);
		}
	}
}
