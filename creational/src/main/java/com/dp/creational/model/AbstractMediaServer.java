package com.dp.creational.model;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

public class AbstractMediaServer implements BasicMediaServer {
	private Map<String, Media> catalog = new HashMap<>();

	protected AbstractMediaServer() {
	}

	public Collection<Media> getCatalog() {
		return catalog.values();
	}

	public void addToCatalog(Media media) {
		catalog.put(media.getId(), media);
	}

	@SuppressWarnings("unchecked")
	public <T extends Media> T getMedia(String mediaId) {
		return (T) catalog.get(mediaId);
	}

	@SuppressWarnings("unchecked")
	public <T extends Media> T getMediaByTitle(String title) {

		for (Media media : catalog.values()) {
			if (media.getName().equals(title)) {
				return (T) media;
			}
		}

		return null;
	}

	public void displayCatalog() {
		System.out.println();
		System.out.println("Catalog:");
		System.out.println();

		getCatalog().forEach(media -> {
			media.getInformation().forEach(mediaInfo -> {
				System.out.println(mediaInfo);
			});
			System.out.println();
		});

		System.out.println("Catalog size: " + getCatalog().size());
	}
}
