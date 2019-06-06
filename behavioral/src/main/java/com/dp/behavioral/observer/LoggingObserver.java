package com.dp.behavioral.observer;

import com.dp.behavioral.model.MediaPlayerObserver;
import com.dp.creational.model.Media;

public class LoggingObserver implements MediaPlayerObserver {
	@Override
	public void mediaPlayEvent(Media media) {
		System.out.println("Logging play of " + media.getName());

		media.getInformation().forEach(info -> {
			System.out.println("     " + info);
		});

	}
}
