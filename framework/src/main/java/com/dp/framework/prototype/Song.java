package com.dp.framework.prototype;

import com.dp.creational.model.AbstractMedia;
import com.dp.framework.model.PlayerMediaServer;

import javax.inject.Inject;
import javax.inject.Named;
import java.util.ArrayList;
import java.util.List;

@Named(Song.TYPE)
public class Song extends AbstractMedia {
	public final static String TYPE = "song";

	private PlayerMediaServer mediaServer;
	private String albumId;
	private int track;

	@Inject
	public Song(PlayerMediaServer mediaServer) {
		super();
		setType(TYPE);
		this.mediaServer = mediaServer;
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
		Album album = mediaServer.getMedia(getAlbumId());
		information.add("Album: " + album.getName());
		information.add("Track: " + getTrack());

		return information;
	}
}
