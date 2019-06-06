package com.dp.creational.model;

import java.util.Collection;

public interface BasicMediaServer {
	Collection<Media> getCatalog();

	void addToCatalog(Media media);

	<T extends Media> T getMedia(String mediaId);

	<T extends Media> T getMediaByTitle(String title);

	public void displayCatalog();
}
