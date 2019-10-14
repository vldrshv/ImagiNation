package com.example.imagination.les2__async_task;

import java.lang.Override;
import java.util.ArrayList;
import java.util.List;
import moxy.MvpPresenter;
import moxy.PresenterBinder;
import moxy.presenter.PresenterField;

public class AsyncTaskActivity$$PresentersBinder extends PresenterBinder<AsyncTaskActivity> {
	@Override
	public List<PresenterField<AsyncTaskActivity>> getPresenterFields() {
		List<PresenterField<AsyncTaskActivity>> presenters = new ArrayList<>(1);
		presenters.add(new PresenterBinder());
		return presenters;
	}

	public class PresenterBinder extends PresenterField<AsyncTaskActivity> {
		public PresenterBinder() {
			super("presenter", null, AsyncPresenter.class);
		}

		@Override
		public void bind(AsyncTaskActivity target, MvpPresenter presenter) {
			target.presenter = (AsyncPresenter) presenter;
		}

		@Override
		public MvpPresenter<?> providePresenter(AsyncTaskActivity delegated) {
			return new AsyncPresenter();
		}
	}
}
