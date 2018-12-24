package com.spstudio.hitchcock.service.extra.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.spstudio.hitchcock.entity.User;
import com.spstudio.hitchcock.service.extra.IUserIDCardAuthenticateService;

@Service
public class UserIDCardAuthenticateServiceImpl implements IUserIDCardAuthenticateService {

	@Autowired
	RestTemplate template;

	@Override
	public boolean isValidIdCard(User user) {
		ResponseEntity<String> response = template.getForEntity("http://website/api/v1/idcheck/{username}",
				String.class, user.getUsername());
		return Boolean.valueOf(response.getBody());
	}

}
