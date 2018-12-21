package com.spstudio.hitchcock.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.spstudio.hitchcock.entity.Photo;
import com.spstudio.hitchcock.entity.User;
import com.spstudio.hitchcock.service.user.IUserAccountService;

@RestController
@RequestMapping(path = "/api/v1", 
	consumes = { MediaType.APPLICATION_JSON_UTF8_VALUE }, 
	produces = { MediaType.APPLICATION_JSON_UTF8_VALUE })
public class UserAccountController {

	@Autowired
	IUserAccountService userAccountService;

	@PostMapping(path = "/users")
	public ResponseEntity<User> createUserAccount(@RequestBody @Validated User user){
		Optional<User> optionalUser = userAccountService.createUserAccount(user);
		if (optionalUser.isPresent()) {
			return ResponseEntity.status(HttpStatus.CREATED).body(optionalUser.get());
		}else {
			return ResponseEntity.status(HttpStatus.CONFLICT).build();
		}
	}
	
	@GetMapping(path = "/users/{userId}/photos/{photoId}}")
	public ResponseEntity<Photo> retrievePhoto(@PathVariable("userId") long userId,
			@PathVariable("photoId") long photoId) {
		
		return null;
	}
}
