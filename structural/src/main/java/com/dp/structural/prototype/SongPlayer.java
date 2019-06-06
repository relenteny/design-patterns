package com.dp.structural.prototype;

import com.dp.creational.model.Media;
import com.dp.structural.model.MediaPlayer;

public class SongPlayer implements MediaPlayer {
	@Override
	public void play(Media media) {
		System.out.println("Playing song: " + media.getName());
	}

	@Override
	public void stop(Media media) {
		System.out.println("Stopping song: " + media.getName());
	}
}
