package com.dp.framework.guice;

import com.dp.framework.ApplicationFramework;
import com.dp.framework.model.Decorator;
import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Map;

public class GuiceMethodInterceptor implements MethodInterceptor {
	private List<Decorator> decorators;

	@Override
	public Object invoke(MethodInvocation methodInvocation) throws Throwable {
		getDecorators(methodInvocation).forEach(decorator -> {
			decorator.invoke(methodInvocation.getMethod(), methodInvocation.getArguments());
		});
		return methodInvocation.proceed();
	}

	private List<Decorator> getDecorators(MethodInvocation methodInvocation) {
		if (decorators == null) {
			decorators = new ArrayList<>();
			ApplicationFramework applicationFramework = new ApplicationFramework();

			Map<String, Decorator> boundDecorators = applicationFramework.getComponentsByType(Decorator.class);
			if (boundDecorators != null && !boundDecorators.isEmpty()) {
				Class<?> clazz = methodInvocation.getThis().getClass();
				boundDecorators.values().forEach(decorator -> {
					if (decorator.decorates(clazz)) {
						decorators.add(decorator);
					}
				});
			}

			decorators.sort(Comparator.comparing(Decorator::getPrecedence));
		}

		return decorators;
	}
}