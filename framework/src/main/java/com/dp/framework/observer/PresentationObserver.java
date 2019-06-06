package com.dp.framework.observer;

import com.dp.behavioral.model.MediaPlayerObserver;
import com.dp.creational.model.Media;

import javax.inject.Named;
import javax.inject.Singleton;

@Singleton
@Named("PresentationObserver")
public class PresentationObserver implements MediaPlayerObserver {
	@Override
	public void mediaPlayEvent(Media media) {
		System.out.println("Display media: " + media.getName());
	}
}
