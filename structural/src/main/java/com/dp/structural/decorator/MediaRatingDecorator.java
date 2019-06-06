package com.dp.structural.decorator;

import com.dp.creational.model.Media;
import com.dp.structural.model.MediaPlayer;
import com.dp.structural.model.UserSession;
import com.dp.structural.singleton.SessionManager;

public class MediaRatingDecorator implements MediaPlayer {
	private MediaPlayer next;

	public MediaRatingDecorator(MediaPlayer next) {
		this.next = next;
	}

	@Override
	public void play(Media media) {
		UserSession userSession = SessionManager.getUserSession();

		if (userSession != null) {
			if (userSession.isPermitted(media.getMediaRating())) {
				next.play(media);
			} else {
				throw new IllegalAccessError();
			}
		} else {
			next.play(media);
		}
	}

	@Override
	public void stop(Media media) {
		next.stop(media);
	}
}
