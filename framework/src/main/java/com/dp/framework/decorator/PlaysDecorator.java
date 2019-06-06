package com.dp.framework.decorator;

import com.dp.creational.model.Media;
import com.dp.framework.model.Decorator;
import com.dp.framework.model.RecordPlays;
import com.dp.framework.singleton.PlaysMetrics;
import org.apache.commons.lang3.reflect.MethodUtils;

import javax.inject.Named;
import java.lang.reflect.Method;

@Named("PlaysDecorator")
public class PlaysDecorator implements Decorator {
	@Override
	public boolean decorates(Class<?> clazz) {
		Method[] methods = clazz.getMethods();
		for (Method method : methods) {
			if (MethodUtils.getAnnotation(method, RecordPlays.class, true, true) != null) {
				return true;
			}
		}

		return false;
	}

	@Override
	public int getPrecedence() {
		return 20;
	}

	@Override
	public void invoke(Method method, Object[] arguments) {
		Media media = (Media) arguments[0];
		PlaysMetrics.played(media);
	}
}
