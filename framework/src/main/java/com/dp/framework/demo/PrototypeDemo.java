package com.dp.framework.demo;

import com.dp.creational.model.Media;
import com.dp.creational.prototype.Song;
import com.dp.creational.prototype.Video;
import com.dp.framework.ApplicationFramework;

public class PrototypeDemo {
	public static void main(String[] args) {
		ApplicationFramework applicationFramework = new ApplicationFramework();
		applicationFramework.initialize("/guice-config.yaml");

		Media media = applicationFramework.getComponent(Media.class, Song.TYPE);
		System.out.println("Media type: " + media.getType());
		System.out.println("Media id: " + media.getId());

		media = applicationFramework.getComponent(Media.class, Song.TYPE);
		System.out.println("Media type: " + media.getType());
		System.out.println("Media id: " + media.getId());

		media = applicationFramework.getComponent(Media.class, Video.TYPE);
		System.out.println("Media type: " + media.getType());
		System.out.println("Media id: " + media.getId());

		media = applicationFramework.getComponent(Media.class, Video.TYPE);
		System.out.println("Media type: " + media.getType());
		System.out.println("Media id: " + media.getId());
	}
}
