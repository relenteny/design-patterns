package com.dp.creational.prototype;

import com.dp.creational.model.AbstractMedia;
import com.dp.creational.singleton.MediaServer;

import java.util.ArrayList;
import java.util.List;

public class Song extends AbstractMedia {
	public final static String TYPE = "song";

	private String albumId;
	private int track;

	public Song() {
		super();
		setType(TYPE);
	}

	public String getAlbumId() {
		return albumId;
	}

	public void setAlbumId(String albumId) {
		this.albumId = albumId;
	}

	public int getTrack() {
		return track;
	}

	public void setTrack(int track) {
		this.track = track;
	}

	@Override
	public List<String> getInformation() {
		List<String> information = new ArrayList<>();

		information.addAll(super.getInformation());
		Album album = MediaServer.getMediaServer().getMedia(getAlbumId());
		information.add("Album: " + album.getName());
		information.add("Track: " + getTrack());

		return information;
	}
}
