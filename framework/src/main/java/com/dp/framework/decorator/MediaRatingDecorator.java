package com.dp.framework.decorator;

import com.dp.creational.model.Media;
import com.dp.framework.model.Decorator;
import com.dp.framework.model.MediaAuthorized;
import com.dp.structural.model.UserSession;
import com.dp.structural.singleton.SessionManager;
import org.apache.commons.lang3.reflect.MethodUtils;

import javax.inject.Named;
import java.lang.annotation.Annotation;
import java.lang.reflect.Method;

@Named("MediaRatingDecorator")
public class MediaRatingDecorator implements Decorator {
	@Override
	public boolean decorates(Class<?> clazz) {
		Method[] methods = clazz.getMethods();
		for (Method method : methods) {
			if (MethodUtils.getAnnotation(method, MediaAuthorized.class, true, true) != null) {
				return true;
			}
		}

		return false;
	}

	@Override
	public void invoke(Method method, Object[] arguments) {
		Annotation annotation = MethodUtils.getAnnotation(method, MediaAuthorized.class, true, true);
		if (annotation != null) {
			Media media = (Media) arguments[0];
			UserSession userSession = SessionManager.getUserSession();

			if (userSession != null) {
				if (!userSession.isPermitted(media.getMediaRating())) {
					throw new IllegalAccessError();
				}
			}
		}
	}

	@Override
	public int getPrecedence() {
		return 10;
	}
}
