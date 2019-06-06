package com.dp.framework.prototype;

import com.dp.creational.model.AbstractMedia;
import com.dp.framework.model.PlayerMediaServer;

import javax.inject.Inject;
import javax.inject.Named;
import java.util.*;

@Named(Album.TYPE)
public class Album extends AbstractMedia {
	public final static String TYPE = "album";

	private PlayerMediaServer mediaServer;
	private String year;
	private String genre;

	@Inject
	public Album(PlayerMediaServer mediaServer) {
		super();
		setType(TYPE);
		this.mediaServer = mediaServer;
	}

	public String getYear() {
		return year;
	}

	public void setYear(String year) {
		this.year = year;
	}

	public String getGenre() {
		return genre;
	}

	public void setGenre(String genre) {
		this.genre = genre;
	}

	public Set<Song> getSongs() {
		Set<Song> songs = new TreeSet<>(Comparator.comparingInt(Song::getTrack));

		mediaServer.getCatalog().forEach(media -> {
			if (media.getType().equals(Song.TYPE) && getId().equals(((Song) media).getAlbumId())) {
				songs.add((Song) media);
			}
		});

		return songs;
	}

	@Override
	public List<String> getInformation() {
		List<String> information = new ArrayList<>();

		information.addAll(super.getInformation());
		information.add("Year: " + getYear());
		information.add("Genre: " + getGenre());

		Set<Song> songs = getSongs();
		songs.forEach(song -> {
			song.getInformation().forEach(songInfo -> {
				information.add("   " + songInfo);
			});
		});

		return information;
	}
}
