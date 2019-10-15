package moxy;

import com.example.imagination.les1__image_recycler.presenter.RecyclerViewPresenter;
import com.example.imagination.les1__image_recycler.presenter.RecyclerViewPresenter$$ViewStateProvider;
import com.example.imagination.les1__image_recycler.view.PhotoViewActivity;
import com.example.imagination.les1__image_recycler.view.PhotoViewActivity$$PresentersBinder;
import com.example.imagination.les1__text_viewer.presenter.TextViewPresenter;
import com.example.imagination.les1__text_viewer.presenter.TextViewPresenter$$ViewStateProvider;
import com.example.imagination.les1__text_viewer.view.TextViewActivity;
import com.example.imagination.les1__text_viewer.view.TextViewActivity$$PresentersBinder;
import com.example.imagination.les2__async_task.AsyncPresenter;
import com.example.imagination.les2__async_task.AsyncPresenter$$ViewStateProvider;
import com.example.imagination.les2__async_task.AsyncTaskActivity;
import com.example.imagination.les2__async_task.AsyncTaskActivity$$PresentersBinder;
import java.lang.Class;
import java.lang.Object;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import moxy.viewstate.strategy.AddToEndSingleStrategy;
import moxy.viewstate.strategy.AddToEndStrategy;
import moxy.viewstate.strategy.SingleStateStrategy;

public final class MoxyReflector {
	private static Map<Class<?>, Object> sViewStateProviders;

	private static Map<Class<?>, List<Object>> sPresenterBinders;

	private static Map<Class<?>, Object> sStrategies;

	static {
		sViewStateProviders = new HashMap<>();
		sViewStateProviders.put(RecyclerViewPresenter.class, new RecyclerViewPresenter$$ViewStateProvider());
		sViewStateProviders.put(TextViewPresenter.class, new TextViewPresenter$$ViewStateProvider());
		sViewStateProviders.put(AsyncPresenter.class, new AsyncPresenter$$ViewStateProvider());
		sViewStateProviders.put(com.example.imagination.les3__image_recycler_extended.presenter.RecyclerViewPresenter.class, new com.example.imagination.les3__image_recycler_extended.presenter.RecyclerViewPresenter$$ViewStateProvider());

		sPresenterBinders = new HashMap<>();
		sPresenterBinders.put(PhotoViewActivity.class, Arrays.<Object>asList(new PhotoViewActivity$$PresentersBinder()));
		sPresenterBinders.put(TextViewActivity.class, Arrays.<Object>asList(new TextViewActivity$$PresentersBinder()));
		sPresenterBinders.put(AsyncTaskActivity.class, Arrays.<Object>asList(new AsyncTaskActivity$$PresentersBinder()));
		sPresenterBinders.put(com.example.imagination.les3__image_recycler_extended.view.PhotoViewActivity.class, Arrays.<Object>asList(new com.example.imagination.les3__image_recycler_extended.view.PhotoViewActivity$$PresentersBinder()));

		sStrategies = new HashMap<>();
		sStrategies.put(AddToEndSingleStrategy.class, new AddToEndSingleStrategy());
		sStrategies.put(AddToEndStrategy.class, new AddToEndStrategy());
		sStrategies.put(SingleStateStrategy.class, new SingleStateStrategy());
	}

	public static Object getViewState(Class<?> presenterClass) {
		ViewStateProvider viewStateProvider = (ViewStateProvider) sViewStateProviders.get(presenterClass);
		if (viewStateProvider == null) {
			return null;
		}

		return viewStateProvider.getViewState();
	}

	public static List<Object> getPresenterBinders(Class<?> delegated) {
		return sPresenterBinders.get(delegated);
	}

	public static Object getStrategy(Class<?> strategyClass) {
		return sStrategies.get(strategyClass);
	}
}
