package com.dp.framework.model;

import java.lang.reflect.Method;

public interface Decorator {
	boolean decorates(Class<?> clazz);

	int getPrecedence();

	void invoke(Method method, Object[] arguments);
}
