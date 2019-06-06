package com.dp.framework.decorator;

import com.dp.behavioral.model.MediaPlayerObserver;
import com.dp.creational.model.Media;
import com.dp.framework.ApplicationFramework;
import com.dp.framework.model.Decorator;
import com.dp.framework.model.MediaObservers;
import org.apache.commons.lang3.reflect.MethodUtils;

import javax.inject.Named;
import java.lang.reflect.Method;
import java.util.Map;

@Named("ObserverDecorator")
public class ObserverDecorator implements Decorator {
	@Override
	public boolean decorates(Class<?> clazz) {
		Method[] methods = clazz.getMethods();
		for (Method method : methods) {
			if (MethodUtils.getAnnotation(method, MediaObservers.class, true, true) != null) {
				return true;
			}
		}

		return false;
	}

	@Override
	public int getPrecedence() {
		return 30;
	}

	@Override
	public void invoke(Method method, Object[] arguments) {
		Media media = (Media) arguments[0];
		ApplicationFramework applicationFramework = new ApplicationFramework();
		Map<String, MediaPlayerObserver> observers = applicationFramework.getComponentsByType(MediaPlayerObserver.class);
		if (observers != null && !observers.isEmpty()) {
			observers.values().forEach(mediaPlayerObserver -> {
				mediaPlayerObserver.mediaPlayEvent(media);
			});
		}
	}
}
