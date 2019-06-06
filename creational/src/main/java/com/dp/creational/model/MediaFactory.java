package com.dp.creational.model;

import com.dp.creational.prototype.Album;
import com.dp.creational.prototype.Picture;
import com.dp.creational.prototype.Song;
import com.dp.creational.prototype.Video;

public class MediaFactory {
	private MediaFactory() {
	}

	@SuppressWarnings("unchecked")
	public static <T> T createMedia(String type) {
		switch (type) {
			case Album.TYPE:
				return (T) new Album();
			case Song.TYPE:
				return (T) new Song();
			case Video.TYPE:
				return (T) new Video();
			case Picture.TYPE:
				return (T) new Picture();
		}

		return null;
	}
}
