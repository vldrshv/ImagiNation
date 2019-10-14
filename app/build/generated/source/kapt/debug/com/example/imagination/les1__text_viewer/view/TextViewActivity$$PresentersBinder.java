package com.example.imagination.les1__text_viewer.view;

import com.example.imagination.les1__text_viewer.presenter.TextViewPresenter;
import java.lang.Override;
import java.util.ArrayList;
import java.util.List;
import moxy.MvpPresenter;
import moxy.PresenterBinder;
import moxy.presenter.PresenterField;

public class TextViewActivity$$PresentersBinder extends PresenterBinder<TextViewActivity> {
	@Override
	public List<PresenterField<TextViewActivity>> getPresenterFields() {
		List<PresenterField<TextViewActivity>> presenters = new ArrayList<>(1);
		presenters.add(new TextViewPresenterBinder());
		return presenters;
	}

	public class TextViewPresenterBinder extends PresenterField<TextViewActivity> {
		public TextViewPresenterBinder() {
			super("textViewPresenter", null, TextViewPresenter.class);
		}

		@Override
		public void bind(TextViewActivity target, MvpPresenter presenter) {
			target.textViewPresenter = (TextViewPresenter) presenter;
		}

		@Override
		public MvpPresenter<?> providePresenter(TextViewActivity delegated) {
			return new TextViewPresenter();
		}
	}
}
