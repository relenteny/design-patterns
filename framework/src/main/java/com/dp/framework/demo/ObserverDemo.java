package com.dp.framework.demo;

import com.dp.creational.model.Media;
import com.dp.creational.model.MediaRating;
import com.dp.creational.prototype.Video;
import com.dp.framework.ApplicationFramework;
import com.dp.framework.model.PlayerMediaServer;
import com.dp.framework.singleton.PlaysMetrics;
import com.dp.structural.model.UserSession;
import com.dp.structural.singleton.SessionManager;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@SuppressWarnings("Duplicates")
public class ObserverDemo {
	public static void main(String[] args) {
		ApplicationFramework applicationFramework = new ApplicationFramework();
		applicationFramework.initialize("/guice-observer.yaml");

		PlayerMediaServer mediaServer = applicationFramework.getComponent(PlayerMediaServer.class);

		MediaCreator mediaCreator = new MediaCreator(applicationFramework);
		mediaCreator.buildDatabase(mediaServer);

		UserSession userSession = new UserSession();
		userSession.addForbiddenRatings(MediaRating.PG_13);

		SessionManager.setUserSession(userSession);

		playVideos(mediaServer);
	}

	private static void playVideos(PlayerMediaServer mediaServer) {
		Random random = new Random();
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
