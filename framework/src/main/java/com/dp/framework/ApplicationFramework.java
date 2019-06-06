package com.dp.framework;

import com.dp.framework.guice.GuiceApplicationModule;
import com.google.inject.*;
import com.google.inject.name.Names;

import javax.inject.Named;
import java.util.HashMap;
import java.util.Map;

public class ApplicationFramework {
	private static Injector injector;

	public void initialize(String configurationPath) {
		GuiceApplicationModule guiceApplicationModule = new GuiceApplicationModule(configurationPath);

		injector = Guice.createInjector(guiceApplicationModule);
	}

	public <T> T getComponent(Class<T> type) {
		try {
			return injector.getInstance(type);
		} catch (ConfigurationException e) {
			System.err.println("Type not found: " + type.getName());
		}

		return null;
	}

	public <T> T getComponent(Class<T> type, String name) {
		try {
			return injector.getInstance(Key.get(type, Names.named(name)));
		} catch (ConfigurationException e) {
			System.err.println("Type not found: " + type.getName());
		}

		return null;
	}

	public <T> Map<String, T> getComponentsByType(Class<T> type) {
		Map<String, T> namedBindings = new HashMap<>();

		Map<Key<?>, Binding<?>> bindings = injector.getBindings();
		if (bindings != null && !bindings.isEmpty()) {
			for (Map.Entry<Key<?>, Binding<?>> entry : bindings.entrySet()) {
				Key<?> key = entry.getKey();

				if (key.getTypeLiteral().getRawType().isAssignableFrom(type)) {
					@SuppressWarnings("unchecked") T component = (T) injector.getInstance(key);
					String name = component.getClass().getName();
					Named annotation = (Named) component.getClass().getAnnotation(Named.class);
					if (annotation != null) {
						name = annotation.value();
					}
					namedBindings.put(name, component);
				}
			}
		}

		return namedBindings;
	}
}
