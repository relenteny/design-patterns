package com.dp.framework.demo;

import com.dp.creational.model.Media;
import com.dp.framework.ApplicationFramework;
import com.dp.framework.prototype.Album;

public class FrameworkDemo {
	public static void main(String[] args) {
		ApplicationFramework applicationFramework = new ApplicationFramework();
		applicationFramework.initialize("/guice-config.yaml");

		Media media = applicationFramework.getComponent(Media.class, Album.TYPE);
		System.out.println(media.getType());
	}
}
