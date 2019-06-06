package com.dp.framework.prototype;

import com.dp.creational.model.Media;
import com.dp.framework.model.MediaPlayer;

import javax.inject.Named;

@Named("picture-player")
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
