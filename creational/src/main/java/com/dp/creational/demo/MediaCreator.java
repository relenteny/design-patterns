package com.dp.creational.demo;

import com.dp.creational.model.BasicMediaServer;
import com.dp.creational.model.MediaFactory;
import com.dp.creational.model.MediaRating;
import com.dp.creational.prototype.Album;
import com.dp.creational.prototype.Picture;
import com.dp.creational.prototype.Song;
import com.dp.creational.prototype.Video;

import java.time.LocalDate;

public class MediaCreator {
	public void buildDatabase(BasicMediaServer mediaServer) {
		addPictures(mediaServer);
		addVideos(mediaServer);
		addAlbums(mediaServer);
	}

	private void addPictures(BasicMediaServer mediaServer) {
		Picture picture = MediaFactory.createMedia(Picture.TYPE);
		picture.setName("Family");
		picture.setDescription("The whole family together");
		picture.setLocation("Atlanta, GA");
		picture.setDateTaken(LocalDate.of(2018, 11, 24));
		mediaServer.addToCatalog(picture);

		picture = MediaFactory.createMedia(Picture.TYPE);
		picture.setName("Picnic");
		picture.setDescription("Lots of food!");
		picture.setLocation("Stone Mountain, GA");
		picture.setDateTaken(LocalDate.of(2019, 6, 1));
		mediaServer.addToCatalog(picture);

		picture = MediaFactory.createMedia(Picture.TYPE);
		picture.setName("Home visit");
		picture.setDescription("Family reunion");
		picture.setLocation("Chicago, IL");
		picture.setDateTaken(LocalDate.of(2018, 7, 13));
		mediaServer.addToCatalog(picture);
	}

	private void addVideos(BasicMediaServer mediaServer) {
		Video video = MediaFactory.createMedia(Video.TYPE);
		video.setName("Star Trek II: The Wrath of Khan");
		video.setDescription("With the assistance of the Enterprise crew, Admiral Kirk must stop an old nemesis, Khan Noonien Singh, from using the life-generating Genesis Device as the ultimate weapon.");
		video.setMediaRating(MediaRating.PG);
		video.setRating("7.7");
		video.setYear("1982");
		mediaServer.addToCatalog(video);

		video = MediaFactory.createMedia(Video.TYPE);
		video.setName("Star Wars: Episode IV - A New Hope");
		video.setDescription("Luke Skywalker joins forces with a Jedi Knight, a cocky pilot, a Wookiee and two droids to save the galaxy from the Empire's world-destroying battle station, while also attempting to rescue Princess Leia from the mysterious Darth Vader.");
		video.setMediaRating(MediaRating.PG);
		video.setRating("8.6");
		video.setYear("1977");
		mediaServer.addToCatalog(video);

		video = MediaFactory.createMedia(Video.TYPE);
		video.setName("2001: A Space Odyssey");
		video.setDescription("After discovering a mysterious artifact buried beneath the Lunar surface, mankind sets off on a quest to find its origins with help from intelligent supercomputer H.A.L. 9000.");
		video.setMediaRating(MediaRating.G);
		video.setRating("8.3");
		video.setYear("1968");
		mediaServer.addToCatalog(video);

		video = MediaFactory.createMedia(Video.TYPE);
		video.setName("Inception");
		video.setDescription("A thief who steals corporate secrets through the use of dream-sharing technology is given the inverse task of planting an idea into the mind of a C.E.O.");
		video.setMediaRating(MediaRating.PG_13);
		video.setRating("8.8");
		video.setYear("2010");
		mediaServer.addToCatalog(video);
	}

	@SuppressWarnings("Duplicates")
	private void addAlbums(BasicMediaServer mediaServer) {
		// Dark Side of the Moon
		Album album = MediaFactory.createMedia(Album.TYPE);
		album.setName("Pink Floyd - The Dark Side Of The Moon");
		album.setDescription("The Dark Side of the Moon is the eighth studio album by English rock band Pink Floyd, released on 1 March 1973 by Harvest Records. Primarily developed during live performances, the band premiered an early version of the record several months before recording began. New material was recorded in two sessions in 1972 and 1973 at Abbey Road Studios in London.");
		album.setGenre("Rock");
		album.setYear("1973");
		mediaServer.addToCatalog(album);

		Song song = MediaFactory.createMedia(Song.TYPE);
		song.setAlbumId(album.getId());
		song.setName("Speak To Me");
		song.setTrack(1);
		mediaServer.addToCatalog(song);

		song = MediaFactory.createMedia(Song.TYPE);
		song.setAlbumId(album.getId());
		song.setName("Breathe");
		song.setTrack(2);
		mediaServer.addToCatalog(song);

		song = MediaFactory.createMedia(Song.TYPE);
		song.setAlbumId(album.getId());
		song.setName("One The Run");
		song.setTrack(3);
		mediaServer.addToCatalog(song);

		song = MediaFactory.createMedia(Song.TYPE);
		song.setAlbumId(album.getId());
		song.setName("Time");
		song.setTrack(4);
		mediaServer.addToCatalog(song);

		song = MediaFactory.createMedia(Song.TYPE);
		song.setAlbumId(album.getId());
		song.setName("The Great Gig In The Sky");
		song.setTrack(5);
		mediaServer.addToCatalog(song);

		song = MediaFactory.createMedia(Song.TYPE);
		song.setAlbumId(album.getId());
		song.setName("Money");
		song.setTrack(6);
		mediaServer.addToCatalog(song);

		song = MediaFactory.createMedia(Song.TYPE);
		song.setAlbumId(album.getId());
		song.setName("Use And Them");
		song.setTrack(7);
		mediaServer.addToCatalog(song);

		song = MediaFactory.createMedia(Song.TYPE);
		song.setAlbumId(album.getId());
		song.setName("Any Colour You Like");
		song.setTrack(8);
		mediaServer.addToCatalog(song);

		song = MediaFactory.createMedia(Song.TYPE);
		song.setAlbumId(album.getId());
		song.setName("Brain Damage");
		song.setTrack(9);
		mediaServer.addToCatalog(song);

		song = MediaFactory.createMedia(Song.TYPE);
		song.setAlbumId(album.getId());
		song.setName("Eclipse");
		song.setTrack(10);
		mediaServer.addToCatalog(song);

		// Aja
		album = MediaFactory.createMedia(Album.TYPE);
		album.setName("Steely Dan - Aja");
		album.setDescription("Aja, pronounced Asia) is the sixth studio album by the jazz rock band Steely Dan.");
		album.setGenre("Jazz, Rock");
		album.setYear("1977");
		mediaServer.addToCatalog(album);

		song = MediaFactory.createMedia(Song.TYPE);
		song.setAlbumId(album.getId());
		song.setName("Black Cow");
		song.setTrack(1);
		mediaServer.addToCatalog(song);

		song = MediaFactory.createMedia(Song.TYPE);
		song.setAlbumId(album.getId());
		song.setName("Aja");
		song.setTrack(2);
		mediaServer.addToCatalog(song);

		song = MediaFactory.createMedia(Song.TYPE);
		song.setAlbumId(album.getId());
		song.setName("Deacon Blues");
		song.setTrack(3);
		mediaServer.addToCatalog(song);

		song = MediaFactory.createMedia(Song.TYPE);
		song.setAlbumId(album.getId());
		song.setName("Peg");
		song.setTrack(4);
		mediaServer.addToCatalog(song);

		song = MediaFactory.createMedia(Song.TYPE);
		song.setAlbumId(album.getId());
		song.setName("Home At Last");
		song.setTrack(5);
		mediaServer.addToCatalog(song);

		song = MediaFactory.createMedia(Song.TYPE);
		song.setAlbumId(album.getId());
		song.setName("I Got The News");
		song.setTrack(6);
		mediaServer.addToCatalog(song);

		// Sgt. Peppers
		album = MediaFactory.createMedia(Album.TYPE);
		album.setName("The Beatles ‎– Sgt. Pepper's Lonely Hearts Club Band");
		album.setDescription("Sgt. Pepper's Lonely Hearts Club Band is the eighth studio album by the English rock band the Beatles.");
		album.setGenre("Rock");
		album.setYear("1967");
		mediaServer.addToCatalog(album);

		song = MediaFactory.createMedia(Song.TYPE);
		song.setAlbumId(album.getId());
		song.setName("Sgt. Peppers Lonely Hearts Club Band");
		song.setTrack(1);
		mediaServer.addToCatalog(song);

		song = MediaFactory.createMedia(Song.TYPE);
		song.setAlbumId(album.getId());
		song.setName("With A Little Help From My Friends");
		song.setTrack(2);
		mediaServer.addToCatalog(song);

		song = MediaFactory.createMedia(Song.TYPE);
		song.setAlbumId(album.getId());
		song.setName("Lucy In The Sky With Diamonds");
		song.setTrack(3);
		mediaServer.addToCatalog(song);

		song = MediaFactory.createMedia(Song.TYPE);
		song.setAlbumId(album.getId());
		song.setName("Getting Better");
		song.setTrack(4);
		mediaServer.addToCatalog(song);

		song = MediaFactory.createMedia(Song.TYPE);
		song.setAlbumId(album.getId());
		song.setName("Fixing A Hole");
		song.setTrack(5);
		mediaServer.addToCatalog(song);

		song = MediaFactory.createMedia(Song.TYPE);
		song.setAlbumId(album.getId());
		song.setName("She's Leaving Home");
		song.setTrack(6);
		mediaServer.addToCatalog(song);

		song = MediaFactory.createMedia(Song.TYPE);
		song.setAlbumId(album.getId());
		song.setName("Being For The Benefit Of Mr. Kite!");
		song.setTrack(7);
		mediaServer.addToCatalog(song);

		song = MediaFactory.createMedia(Song.TYPE);
		song.setAlbumId(album.getId());
		song.setName("Within You Without You");
		song.setTrack(8);
		mediaServer.addToCatalog(song);

		song = MediaFactory.createMedia(Song.TYPE);
		song.setAlbumId(album.getId());
		song.setName("When I'm Sixty-Four");
		song.setTrack(9);
		mediaServer.addToCatalog(song);

		song = MediaFactory.createMedia(Song.TYPE);
		song.setAlbumId(album.getId());
		song.setName("Lovely Rita");
		song.setTrack(10);
		mediaServer.addToCatalog(song);

		song = MediaFactory.createMedia(Song.TYPE);
		song.setAlbumId(album.getId());
		song.setName("Good Morning Good Morning");
		song.setTrack(11);
		mediaServer.addToCatalog(song);

		song = MediaFactory.createMedia(Song.TYPE);
		song.setAlbumId(album.getId());
		song.setName("Sgt. Peppers Lonely Hearts Club Band (Reprise)");
		song.setTrack(12);
		mediaServer.addToCatalog(song);

		song = MediaFactory.createMedia(Song.TYPE);
		song.setAlbumId(album.getId());
		song.setName("A Day In The Life");
		song.setTrack(13);
		mediaServer.addToCatalog(song);
	}
}
