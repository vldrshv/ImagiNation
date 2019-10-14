package com.example.imagination.les1__text_viewer;

import java.lang.Override;
import java.lang.String;
import moxy.viewstate.MvpViewState;
import moxy.viewstate.ViewCommand;
import moxy.viewstate.strategy.AddToEndStrategy;

public class IView$$State extends MvpViewState<IView> implements IView {
	@Override
	public void setText(String text) {
		SetTextCommand setTextCommand = new SetTextCommand(text);
		mViewCommands.beforeApply(setTextCommand);

		if (hasNotView()) {
			return;
		}

		for (IView view : mViews) {
			view.setText(text);
		}

		mViewCommands.afterApply(setTextCommand);
	}

	public class SetTextCommand extends ViewCommand<IView> {
		public final String text;

		SetTextCommand(String text) {
			super("setText", AddToEndStrategy.class);

			this.text = text;
		}

		@Override
		public void apply(IView mvpView) {
			mvpView.setText(text);
		}
	}
}
