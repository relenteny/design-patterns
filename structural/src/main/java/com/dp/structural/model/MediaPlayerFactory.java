package com.dp.structural.model;

import com.dp.creational.model.Media;
import com.dp.creational.prototype.Album;
import com.dp.creational.prototype.Picture;
import com.dp.creational.prototype.Song;
import com.dp.creational.prototype.Video;
import com.dp.structural.prototype.AlbumPlayer;
import com.dp.structural.prototype.SongPlayer;
import com.dp.structural.prototype.VideoPlayer;

public class MediaPlayerFactory {
	private static MediaPlayerFactory mediaPlayerFactory = new MediaPlayerFactory();

	private DecoratorHandler decoratorHandler;

	private MediaPlayer albumPlayer;
	private MediaPlayer songPlayer;
	private MediaPlayer videoPlayer;
	private MediaPlayer pictureViewer;

	private MediaPlayerFactory() {
	}

	public static MediaPlayer getMediaPlayer(Media media) {
		switch (media.getType()) {
			case Album.TYPE:
				return mediaPlayerFactory.albumPlayer;
			case Song.TYPE:
				return mediaPlayerFactory.songPlayer;
			case Video.TYPE:
				return mediaPlayerFactory.videoPlayer;
			case Picture.TYPE:
				return mediaPlayerFactory.pictureViewer;
		}

		return null;
	}

	public static void initializeDecorators(DecoratorHandler decoratorHandler) {
		mediaPlayerFactory.decoratorHandler = decoratorHandler;

		mediaPlayerFactory.albumPlayer = mediaPlayerFactory.decorate(new AlbumPlayer());
		mediaPlayerFactory.songPlayer = mediaPlayerFactory.decorate(new SongPlayer());
		mediaPlayerFactory.videoPlayer = mediaPlayerFactory.decorate(new VideoPlayer());
	}

	protected MediaPlayer decorate(MediaPlayer mediaPlayer) {
		return decoratorHandler.decorate(mediaPlayer);
	}
}
