package com.dp.structural.prototype;

import com.dp.creational.model.Media;
import com.dp.structural.model.MediaPlayer;

public class VideoPlayer implements MediaPlayer {
	@Override
	public void play(Media media) {
		System.out.println("Playing video: " + media.getName());
	}

	@Override
	public void stop(Media media) {
		System.out.println("Stopping video: " + media.getName());
	}
}
