package com.spstudio.hitchcock.service.user.impl;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spstudio.hitchcock.entity.User;
import com.spstudio.hitchcock.repository.UserRepository;
import com.spstudio.hitchcock.service.user.IUserAccountService;

@Service
public class UserAccountServiceImpl implements IUserAccountService {

	@Autowired
	UserRepository userRepository;
	
	@Override
	public Optional<User> createUserAccount(User user) {
		if (userRepository.findByUsername(user.getUsername()).isPresent()) {
			return Optional.empty();
		}
		return Optional.ofNullable(userRepository.save(user));
	}

	@Override
	public Optional<User> loadUserById(long userId) {
		return userRepository.findById(userId);
	}

}
