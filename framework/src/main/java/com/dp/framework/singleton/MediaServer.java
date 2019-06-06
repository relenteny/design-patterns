package com.dp.framework.singleton;

import com.dp.creational.model.AbstractMediaServer;
import com.dp.creational.model.Media;
import com.dp.framework.ApplicationFramework;
import com.dp.framework.model.MediaPlayer;
import com.dp.framework.model.PlayerMediaServer;

import javax.inject.Singleton;
import java.util.HashMap;
import java.util.Map;

@Singleton
public class MediaServer extends AbstractMediaServer implements PlayerMediaServer {
	private Map<String, Media> playing = new HashMap<>();
	private ApplicationFramework applicationFramework = new ApplicationFramework();

	public void play(Media media) {
		MediaPlayer mediaPlayer = applicationFramework.getComponent(MediaPlayer.class, media.getType() + "-player");
		mediaPlayer.play(media);
		playing.put(media.getId(), media);
	}

	public void stop(Media media) {
		MediaPlayer mediaPlayer = applicationFramework.getComponent(MediaPlayer.class, media.getType() + "-player");
		mediaPlayer.stop(media);
		playing.remove(media.getId());
	}
}
