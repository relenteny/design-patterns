package com.dp.creational.demo;

import com.dp.creational.singleton.MediaServer;

public class SingletonDemo {
	public static void main(String[] args) {
		MediaServer mediaServer = MediaServer.getMediaServer();

		System.out.println("Media catalog size: " + mediaServer.getCatalog().size());

		MediaCreator mediaCreator = new MediaCreator();
		mediaCreator.buildDatabase(mediaServer);

		System.out.println("Media catalog size: " + mediaServer.getCatalog().size());

		mediaServer = MediaServer.getMediaServer();

		System.out.println("Media catalog size: " + mediaServer.getCatalog().size());

		mediaServer.displayCatalog();
	}
}
