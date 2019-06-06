package com.dp.framework.guice;

import java.util.List;

public class IocBinding {
	private String bind;
	private List<String> to;
	private boolean decorate;

	public String getBind() {
		return bind;
	}

	public void setBind(String bind) {
		this.bind = bind;
	}

	public List<String> getTo() {
		return to;
	}

	public void setTo(List<String> to) {
		this.to = to;
	}

	public boolean isDecorate() {
		return decorate;
	}

	public void setDecorate(boolean decorate) {
		this.decorate = decorate;
	}
}
