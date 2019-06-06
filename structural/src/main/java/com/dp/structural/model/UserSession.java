package com.dp.structural.model;

import com.dp.creational.model.MediaRating;

import java.util.HashSet;
import java.util.Set;

public class UserSession {
	private Set<MediaRating> forbiddenRatings = new HashSet<>();

	public void addForbiddenRatings(MediaRating... rating) {
		if (rating != null && rating.length > 0) {
			for (int r = 0; r < rating.length; r++) {
				forbiddenRatings.add(rating[r]);
			}
		}
	}

	public boolean isPermitted(MediaRating rating) {
		if (rating == null) {
			return true;
		}
		return !forbiddenRatings.contains(rating);
	}
}
