package com.spstudio.hitchcock.service.extra;

import com.spstudio.hitchcock.entity.User;

public interface IUserIDCardAuthenticateService {

	public boolean isValidIdCard(User user);
}
