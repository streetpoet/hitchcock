package com.spstudio.hitchcock.testutil;

import com.spstudio.hitchcock.entity.User;

public class UserInstanceFactory {

	public static User createUserInstanceWithUsername(String username) {
		User user = new User();
		user.setUsername(username);
		return user;
	}
}
