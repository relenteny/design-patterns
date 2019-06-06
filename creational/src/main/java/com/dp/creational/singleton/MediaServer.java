package com.dp.creational.singleton;

import com.dp.creational.model.AbstractMediaServer;

public class MediaServer extends AbstractMediaServer {
	private static MediaServer mediaServer = new MediaServer();

	public static MediaServer getMediaServer() {
		return mediaServer;
	}
}
