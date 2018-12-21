package com.spstudio.hitchcock.service.user;

import java.util.Optional;

import com.spstudio.hitchcock.entity.User;

public interface IUserAccountService {

	public Optional<User> createUserAccount(User user);
}
