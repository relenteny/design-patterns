package com.dp.creational.demo;

import com.dp.creational.model.MediaFactory;
import com.dp.creational.prototype.Song;
import com.dp.creational.prototype.Video;

public class PrototypeDemo {
	public static void main(String[] args) {
		Song song = MediaFactory.createMedia(Song.TYPE);
		System.out.println("Media type: " + song.getType());
		System.out.println("Media id: " + song.getId());

		song = MediaFactory.createMedia(Song.TYPE);
		System.out.println("Media type: " + song.getType());
		System.out.println("Media id: " + song.getId());

		Video video = MediaFactory.createMedia(Video.TYPE);
		System.out.println("Media type: " + video.getType());
		System.out.println("Media id: " + video.getId());

		video = MediaFactory.createMedia(Video.TYPE);
		System.out.println("Media type: " + video.getType());
		System.out.println("Media id: " + video.getId());
	}
}
