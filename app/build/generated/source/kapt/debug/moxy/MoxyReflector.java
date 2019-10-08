package moxy;

import com.example.imagination.image_recycler.presenter.RecyclerViewPresenter;
import com.example.imagination.image_recycler.presenter.RecyclerViewPresenter$$ViewStateProvider;
import com.example.imagination.image_recycler.view.PhotoViewActivity;
import com.example.imagination.image_recycler.view.PhotoViewActivity$$PresentersBinder;
import com.example.imagination.text_viewer.presenter.TextViewPresenter;
import com.example.imagination.text_viewer.presenter.TextViewPresenter$$ViewStateProvider;
import com.example.imagination.text_viewer.view.TextViewActivity;
import com.example.imagination.text_viewer.view.TextViewActivity$$PresentersBinder;
import java.lang.Class;
import java.lang.Object;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
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

		sPresenterBinders = new HashMap<>();
		sPresenterBinders.put(PhotoViewActivity.class, Arrays.<Object>asList(new PhotoViewActivity$$PresentersBinder()));
		sPresenterBinders.put(TextViewActivity.class, Arrays.<Object>asList(new TextViewActivity$$PresentersBinder()));

		sStrategies = new HashMap<>();
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
