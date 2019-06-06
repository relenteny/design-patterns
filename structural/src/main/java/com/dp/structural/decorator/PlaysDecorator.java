package com.dp.structural.decorator;

import com.dp.creational.model.Media;
import com.dp.structural.model.MediaPlayer;
import com.dp.structural.singleton.PlaysMetrics;

public class PlaysDecorator implements MediaPlayer {
	private MediaPlayer next;

	public PlaysDecorator(MediaPlayer next) {
		this.next = next;
	}

	@Override
	public void play(Media media) {
		PlaysMetrics.played(media);
		next.play(media);
	}

	@Override
	public void stop(Media media) {
		next.stop(media);
	}
}
