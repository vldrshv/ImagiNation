package moxy;

import com.example.imagination.core.presenter.LikedPhotoPresenter;
import com.example.imagination.core.presenter.LikedPhotoPresenter$$ViewStateProvider;
import com.example.imagination.core.presenter.RecyclerViewPresenter;
import com.example.imagination.core.presenter.RecyclerViewPresenter$$ViewStateProvider;
import com.example.imagination.core.view.activities.ui.dashboard.LikedGalleryFragment;
import com.example.imagination.core.view.activities.ui.dashboard.LikedGalleryFragment$$PresentersBinder;
import com.example.imagination.core.view.activities.ui.gallery.GalleryFragment;
import com.example.imagination.core.view.activities.ui.gallery.GalleryFragment$$PresentersBinder;
import com.example.imagination.les5__room.UserPresenter;
import com.example.imagination.les5__room.UserPresenter$$ViewStateProvider;
import com.example.imagination.les5__room.view.RoomActivity;
import com.example.imagination.les5__room.view.RoomActivity$$PresentersBinder;
import java.lang.Class;
import java.lang.Object;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import moxy.viewstate.strategy.SingleStateStrategy;
import moxy.viewstate.strategy.SkipStrategy;

public final class MoxyReflector {
	private static Map<Class<?>, Object> sViewStateProviders;

	private static Map<Class<?>, List<Object>> sPresenterBinders;

	private static Map<Class<?>, Object> sStrategies;

	static {
		sViewStateProviders = new HashMap<>();
		sViewStateProviders.put(LikedPhotoPresenter.class, new LikedPhotoPresenter$$ViewStateProvider());
		sViewStateProviders.put(RecyclerViewPresenter.class, new RecyclerViewPresenter$$ViewStateProvider());
		sViewStateProviders.put(UserPresenter.class, new UserPresenter$$ViewStateProvider());

		sPresenterBinders = new HashMap<>();
		sPresenterBinders.put(LikedGalleryFragment.class, Arrays.<Object>asList(new LikedGalleryFragment$$PresentersBinder()));
		sPresenterBinders.put(GalleryFragment.class, Arrays.<Object>asList(new GalleryFragment$$PresentersBinder()));
		sPresenterBinders.put(RoomActivity.class, Arrays.<Object>asList(new RoomActivity$$PresentersBinder()));

		sStrategies = new HashMap<>();
		sStrategies.put(SingleStateStrategy.class, new SingleStateStrategy());
		sStrategies.put(SkipStrategy.class, new SkipStrategy());
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
