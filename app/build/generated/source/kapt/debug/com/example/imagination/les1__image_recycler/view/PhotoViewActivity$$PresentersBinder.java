package com.example.imagination.les1__image_recycler.view;

import com.example.imagination.les1__image_recycler.presenter.RecyclerViewPresenter;
import java.lang.Override;
import java.util.ArrayList;
import java.util.List;
import moxy.MvpPresenter;
import moxy.PresenterBinder;
import moxy.presenter.PresenterField;

public class PhotoViewActivity$$PresentersBinder extends PresenterBinder<PhotoViewActivity> {
	@Override
	public List<PresenterField<PhotoViewActivity>> getPresenterFields() {
		List<PresenterField<PhotoViewActivity>> presenters = new ArrayList<>(1);
		presenters.add(new RecyclerViewPresenterBinder());
		return presenters;
	}

	public class RecyclerViewPresenterBinder extends PresenterField<PhotoViewActivity> {
		public RecyclerViewPresenterBinder() {
			super("recyclerViewPresenter", null, RecyclerViewPresenter.class);
		}

		@Override
		public void bind(PhotoViewActivity target, MvpPresenter presenter) {
			target.recyclerViewPresenter = (RecyclerViewPresenter) presenter;
		}

		@Override
		public MvpPresenter<?> providePresenter(PhotoViewActivity delegated) {
			return new RecyclerViewPresenter();
		}
	}
}
