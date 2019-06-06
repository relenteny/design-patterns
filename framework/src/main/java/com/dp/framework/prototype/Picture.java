package com.dp.framework.prototype;

import com.dp.creational.model.AbstractMedia;

import javax.inject.Named;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Named(Picture.TYPE)
public class Picture extends AbstractMedia {
	public final static String TYPE = "picture";

	private LocalDate dateTaken;
	private String location;

	public Picture() {
		super();
		setType(TYPE);
	}

	public LocalDate getDateTaken() {
		return dateTaken;
	}

	public void setDateTaken(LocalDate dateTaken) {
		this.dateTaken = dateTaken;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	@Override
	public List<String> getInformation() {
		List<String> information = new ArrayList<>();

		information.addAll(super.getInformation());
		information.add("Date: " + getDateTaken());
		information.add("Location: " + getLocation());

		return information;
	}
}
