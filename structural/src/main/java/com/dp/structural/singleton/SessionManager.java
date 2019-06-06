package com.dp.structural.singleton;

import com.dp.structural.model.UserSession;

public class SessionManager {
	private static InheritableThreadLocal<UserSession> userSession = new InheritableThreadLocal<>();

	public static UserSession getUserSession() {
		return userSession.get();
	}

	public static void setUserSession(UserSession session) {
		SessionManager.userSession.set(session);
	}

	public static void clearUserSession() {
		userSession.remove();
	}
}
