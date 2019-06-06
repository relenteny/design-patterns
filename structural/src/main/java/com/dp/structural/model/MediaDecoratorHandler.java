package com.dp.structural.model;

import com.dp.structural.decorator.MediaRatingDecorator;
import com.dp.structural.decorator.PlaysDecorator;

public class MediaDecoratorHandler implements DecoratorHandler {
	public MediaPlayer decorate(MediaPlayer mediaPlayer) {
		PlaysDecorator playsDecorator = new PlaysDecorator(mediaPlayer);
		MediaRatingDecorator ratingDecorator = new MediaRatingDecorator(playsDecorator);

		return ratingDecorator;
	}
}
