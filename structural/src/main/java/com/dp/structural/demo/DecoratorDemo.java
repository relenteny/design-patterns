package com.dp.structural.demo;

import com.dp.creational.demo.MediaCreator;
import com.dp.creational.model.Media;
import com.dp.creational.model.MediaRating;
import com.dp.creational.prototype.Video;
import com.dp.structural.model.MediaDecoratorHandler;
import com.dp.structural.model.MediaPlayerFactory;
import com.dp.structural.model.UserSession;
import com.dp.structural.singleton.MediaServer;
import com.dp.structural.singleton.PlaysMetrics;
import com.dp.structural.singleton.SessionManager;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class DecoratorDemo {
	public static void main(String[] args) {
		MediaServer mediaServer = MediaServer.getMediaServer();
		MediaPlayerFactory.initializeDecorators(new MediaDecoratorHandler());

		MediaCreator mediaCreator = new MediaCreator();
		mediaCreator.buildDatabase(mediaServer);

		UserSession userSession = new UserSession();
		userSession.addForbiddenRatings(MediaRating.PG_13);

		SessionManager.setUserSession(userSession);

		playVideos();
	}

	private static void playVideos() {
		Random random = new Random();
		MediaServer mediaServer = MediaServer.getMediaServer();
		List<Media> playableMedia = new ArrayList<>();
		mediaServer.getCatalog().forEach(media -> {
			if (media.getType().equals(Video.TYPE)) {
				playableMedia.add(media);
			}
		});
		int playableSize = playableMedia.size();
		Media[] playable = playableMedia.toArray(new Media[playableSize]);

		int nPlays = random.nextInt(20);
		for (int p = 0; p < nPlays; p++) {
			int entry = random.nextInt(playableSize);
			Media media = playable[entry];
			try {
				mediaServer.play(media);
			} catch (IllegalAccessError e) {
				System.err.println("Unable to play " + media.getName() + '.');
			}
		}

		PlaysMetrics.reportPlays();
	}
}
