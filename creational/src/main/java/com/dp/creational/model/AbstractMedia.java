package com.dp.creational.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.UUID;

public abstract class AbstractMedia implements Media {
	private String id;
	private String name;
	private String description;
	private String type;
	private MediaRating rating;

	public AbstractMedia() {
		setId(UUID.randomUUID().toString());
	}

	@Override
	public String getId() {
		return id;
	}

	@Override
	public void setId(String id) {
		this.id = id;
	}

	@Override
	public String getName() {
		return name;
	}

	@Override
	public void setName(String name) {
		this.name = name;
	}

	@Override
	public String getDescription() {
		return description;
	}

	@Override
	public void setDescription(String description) {
		this.description = description;
	}

	@Override
	public String getType() {
		return type;
	}

	protected void setType(String type) {
		this.type = type;
	}

	@Override
	public MediaRating getMediaRating() {
		return rating;
	}

	@Override
	public void setMediaRating(MediaRating rating) {
		this.rating = rating;
	}

	@Override
	public List<String> getInformation() {
		List<String> information = new ArrayList<>();

		information.add("Type: " + getType());
		information.add("Name: " + getName());
		if (getDescription() != null) {
			information.add("Description: " + getDescription());
		}
		if (getMediaRating() != null) {
			information.add("Media rating: " + getMediaRating());
		}

		return information;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (obj == null || getClass() != obj.getClass()) {
			return false;
		}

		AbstractMedia media = (AbstractMedia) obj;
		return id.equals(media.id) &&
				name.equals(media.name) &&
				Objects.equals(description, media.description);
	}

	@Override
	public int hashCode() {
		return Objects.hash(id, name, description);
	}
}
