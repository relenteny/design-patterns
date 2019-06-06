package com.dp.framework.model;

import com.dp.creational.model.BasicMediaServer;
import com.dp.creational.model.Media;

public interface PlayerMediaServer extends BasicMediaServer {
	void play(Media media);

	void stop(Media media);
}
