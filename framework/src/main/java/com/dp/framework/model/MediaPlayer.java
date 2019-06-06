package com.dp.framework.model;

import com.dp.creational.model.Media;

public interface MediaPlayer {
	@MediaAuthorized
	@RecordPlays
	@MediaObservers
	void play(Media media);

	void stop(Media media);
}
