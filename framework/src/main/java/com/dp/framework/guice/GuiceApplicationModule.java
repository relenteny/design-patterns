package com.dp.framework.guice;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.yaml.YAMLFactory;
import com.google.inject.AbstractModule;
import com.google.inject.matcher.Matchers;
import com.google.inject.name.Names;
import org.aopalliance.intercept.MethodInterceptor;

import javax.inject.Named;
import java.io.IOException;
import java.io.InputStream;
import java.lang.annotation.Annotation;

public class GuiceApplicationModule extends AbstractModule {
	String configurationPath;
	GuiceConfiguration configuration;

	public GuiceApplicationModule(String configurationPath) {
		this.configurationPath = configurationPath;
	}

	@Override
	protected void configure() {
		try (InputStream inputStream = this.getClass().getResourceAsStream(configurationPath)) {
			ObjectMapper objectMapper = new ObjectMapper(new YAMLFactory());
			configuration = objectMapper.readValue(inputStream, GuiceConfiguration.class);
		} catch (IOException e) {
			System.err.println("Error loading configuration: " + e.toString());
		}

		for (IocBinding iocBinding : configuration.getIoc().getBindings()) {
			try {
				Class bindClass = Class.forName(iocBinding.getBind());
				for (String className : iocBinding.getTo()) {
					Class toClass = Class.forName(className);
					addBinding(bindClass, toClass);
				}

				if (iocBinding.isDecorate()) {
					bindInterceptor(Matchers.subclassesOf(bindClass), Matchers.any(), new GuiceMethodInterceptor());
				}
			} catch (ClassNotFoundException e) {
				System.err.println("Error binding " + iocBinding.getBind() + ": " + e.toString());
			}

		}

	}

	private void addBinding(Class bindClass, Class toClass) {
		Named annotation = (Named) toClass.getAnnotation(Named.class);
		String name = null;
		if (annotation != null) {
			name = annotation.value();
		}

		if (name != null && name.length() > 0) {
			bind(bindClass).annotatedWith(Names.named(name)).to(toClass);
		} else {
			bind(bindClass).to(toClass);
		}
	}

	private void addDecorator(Class<? extends Annotation> annotation, Class interceptor) {
		try {
			bindInterceptor(Matchers.any(), Matchers.annotatedWith(annotation), (MethodInterceptor) interceptor.newInstance());
		} catch (IllegalAccessException | InstantiationException e) {
			System.err.println("Error configuring decorator: " + e.toString());
		}
	}
}
