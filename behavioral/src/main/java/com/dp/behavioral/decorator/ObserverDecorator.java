package com.dp.behavioral.decorator;

import com.dp.behavioral.model.MediaPlayerObserver;
import com.dp.behavioral.observer.LoggingObserver;
import com.dp.behavioral.observer.PresentationObserver;
import com.dp.creational.model.Media;
import com.dp.structural.model.MediaPlayer;

import java.util.ArrayList;
import java.util.List;

public class ObserverDecorator implements MediaPlayer {
	private MediaPlayer next;
	private List<MediaPlayerObserver> observers = new ArrayList<>();

	public ObserverDecorator(MediaPlayer next) {
		this.next = next;
		observers.add(new LoggingObserver());
		observers.add(new PresentationObserver());
	}

	@Override
	public void play(Media media) {
		observers.forEach(observer -> observer.mediaPlayEvent(media));
		next.play(media);
	}

	@Override
	public void stop(Media media) {
		next.stop(media);
	}
}
