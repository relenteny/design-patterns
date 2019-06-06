package com.dp.structural.singleton;

import com.dp.creational.model.AbstractMediaServer;
import com.dp.creational.model.Media;
import com.dp.structural.model.MediaPlayerFactory;
import com.dp.structural.model.PlayerMediaServer;

import java.util.HashMap;
import java.util.Map;

public class MediaServer extends AbstractMediaServer implements PlayerMediaServer {
	private static MediaServer mediaServer = new MediaServer();

	private Map<String, Media> playing = new HashMap<>();

	public static MediaServer getMediaServer() {
		return mediaServer;
	}

	public void play(Media media) {
		MediaPlayerFactory.getMediaPlayer(media).play(media);
		playing.put(media.getId(), media);
	}

	public void stop(Media media) {
		MediaPlayerFactory.getMediaPlayer(media).stop(media);
		playing.remove(media.getId());
	}
}
