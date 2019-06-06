package com.dp.structural.prototype;

import com.dp.creational.model.Media;
import com.dp.structural.model.MediaPlayer;

public class AlbumPlayer implements MediaPlayer {
	@Override
	public void play(Media media) {
		System.out.println("Playing album: " + media.getName());
	}

	@Override
	public void stop(Media media) {
		System.out.println("Stopping album: " + media.getName());
	}
}
