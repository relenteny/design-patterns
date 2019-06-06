package com.dp.framework.singleton;

import com.dp.creational.model.Media;
import com.dp.framework.ApplicationFramework;
import com.dp.framework.model.PlayerMediaServer;

import java.util.HashMap;
import java.util.Map;

public class PlaysMetrics {
	private static PlaysMetrics playsMetrics = new PlaysMetrics();

	Map<String, Integer> plays = new HashMap<>();

	private PlaysMetrics() {
	}

	public static void played(Media media) {
		Integer nPlays = playsMetrics.plays.get(media.getId());
		if (nPlays == null) {
			playsMetrics.plays.put(media.getId(), 1);
		} else {
			playsMetrics.plays.put(media.getId(), nPlays + 1);
		}
	}

	public static void reportPlays() {
		ApplicationFramework applicationFramework = new ApplicationFramework();
		PlayerMediaServer mediaServer = applicationFramework.getComponent(PlayerMediaServer.class);

		System.out.println();
		System.out.println("Media play metrics.");
		System.out.println();

		playsMetrics.plays.forEach((id, nPlays) -> {
			Media media = mediaServer.getMedia(id);

			System.out.println(media.getName() + ": " + nPlays + " plays.");
		});
	}
}
