package com.spstudio.hitchcock.testutil;

import org.junit.jupiter.api.Disabled;

import com.spstudio.hitchcock.entity.User;

@Disabled
public class UserInstanceFactory {

	public static User createUserInstanceWithUsername(String username) {
		User user = new User();
		user.setUsername(username);
		return user;
	}
}
