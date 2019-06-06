package com.dp.behavioral.observer;

import com.dp.behavioral.model.MediaPlayerObserver;
import com.dp.creational.model.Media;

public class PresentationObserver implements MediaPlayerObserver {
	@Override
	public void mediaPlayEvent(Media media) {
		System.out.println("Display media: " + media.getName());
	}
}
