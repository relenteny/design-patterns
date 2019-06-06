package com.dp.structural.singleton;

import com.dp.creational.model.Media;

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
		System.out.println();
		System.out.println("Media play metrics.");
		System.out.println();

		playsMetrics.plays.forEach((id, nPlays) -> {
			Media media = MediaServer.getMediaServer().getMedia(id);

			System.out.println(media.getName() + ": " + nPlays + " plays.");
		});
	}
}
