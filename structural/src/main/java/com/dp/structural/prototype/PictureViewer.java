package com.dp.structural.prototype;

import com.dp.creational.model.Media;
import com.dp.structural.model.MediaPlayer;

public class PictureViewer implements MediaPlayer {
	@Override
	public void play(Media media) {
		System.out.println("Viewing picture: " + media.getName());
	}

	@Override
	public void stop(Media media) {
		System.out.println("Stop viewing picture: " + media.getName());
	}
}
