package com.dp.framework.demo;

import com.dp.framework.ApplicationFramework;
import com.dp.framework.model.PlayerMediaServer;

public class SingletonDemo {
	public static void main(String[] args) {
		ApplicationFramework applicationFramework = new ApplicationFramework();
		applicationFramework.initialize("/guice-config.yaml");

		PlayerMediaServer mediaServer = applicationFramework.getComponent(PlayerMediaServer.class);

		System.out.println("Media catalog size: " + mediaServer.getCatalog().size());

		MediaCreator mediaCreator = new MediaCreator(applicationFramework);
		mediaCreator.buildDatabase(mediaServer);

		System.out.println("Media catalog size: " + mediaServer.getCatalog().size());

		mediaServer = applicationFramework.getComponent(PlayerMediaServer.class);
		System.out.println("Media catalog size: " + mediaServer.getCatalog().size());

		mediaServer.displayCatalog();
	}
}
