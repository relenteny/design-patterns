package com.dp.creational.model;

import java.util.List;

public interface Media {
	String getId();

	void setId(String id);

	String getType();

	String getName();

	void setName(String name);

	String getDescription();

	void setDescription(String description);

	MediaRating getMediaRating();

	void setMediaRating(MediaRating rating);

	List<String> getInformation();
}
