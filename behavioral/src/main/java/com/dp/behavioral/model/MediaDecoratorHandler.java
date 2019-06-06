package com.dp.behavioral.model;

import com.dp.behavioral.decorator.ObserverDecorator;
import com.dp.structural.decorator.MediaRatingDecorator;
import com.dp.structural.decorator.PlaysDecorator;
import com.dp.structural.model.DecoratorHandler;
import com.dp.structural.model.MediaPlayer;

public class MediaDecoratorHandler implements DecoratorHandler {
	public MediaPlayer decorate(MediaPlayer mediaPlayer) {
		ObserverDecorator observerDecorator = new ObserverDecorator(mediaPlayer);
		PlaysDecorator playsDecorator = new PlaysDecorator(observerDecorator);
		MediaRatingDecorator ratingDecorator = new MediaRatingDecorator(playsDecorator);

		return ratingDecorator;
	}
}
