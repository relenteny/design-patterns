package com.dp.creational.prototype;

import com.dp.creational.model.AbstractMedia;

import java.util.ArrayList;
import java.util.List;

public class Video extends AbstractMedia {
	public final static String TYPE = "video";

	private String year;
	private String rating;

	public Video() {
		super();
		setType(TYPE);
	}

	public String getYear() {
		return year;
	}

	public void setYear(String year) {
		this.year = year;
	}

	public String getRating() {
		return rating;
	}

	public void setRating(String rating) {
		this.rating = rating;
	}

	@Override
	public List<String> getInformation() {
		List<String> information = new ArrayList<>();

		information.addAll(super.getInformation());
		information.add("Year: " + getYear());
		information.add("Rating: " + getRating());

		return information;
	}
}
