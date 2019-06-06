package com.dp.framework.guice;

import java.util.List;

public class IoC {
	private List<IocBinding> bindings;

	public List<IocBinding> getBindings() {
		return bindings;
	}

	public void setBindings(List<IocBinding> bindings) {
		this.bindings = bindings;
	}
}
