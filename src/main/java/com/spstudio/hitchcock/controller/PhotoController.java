package com.spstudio.hitchcock.controller;

import java.util.Iterator;
import java.util.Optional;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.spstudio.hitchcock.entity.Photo;
import com.spstudio.hitchcock.entity.User;
import com.spstudio.hitchcock.service.access.IPhotoCRUDService;
import com.spstudio.hitchcock.service.beauty.IPhotoBeautyService;

@RestController("/api/v1")
public class PhotoController {

	@Autowired
	Set<IPhotoBeautyService> photoBeautyServices;

	@Autowired
	IPhotoCRUDService photoAccessService;

	@GetMapping(path = "/photo/{id}", produces = { MediaType.APPLICATION_JSON_UTF8_VALUE })
	public ResponseEntity<Photo> getPhoto(@PathVariable("id") int id) {

		Optional<Photo> optionalPhoto = photoAccessService.loadPhotoById(id);
		if (!optionalPhoto.isPresent()) {
			return ResponseEntity.notFound().build();
		}

		Photo photo = optionalPhoto.get();
		Iterator<IPhotoBeautyService> photoBeautyServiceIterator = photoBeautyServices.iterator();
		while (photoBeautyServiceIterator.hasNext()) {
			photoBeautyServiceIterator.next().updatePhoto(photo);
		}

		return ResponseEntity.ok(photo);
	}

	@PostMapping(path = "/users", consumes = { MediaType.APPLICATION_JSON_UTF8_VALUE }, produces = {
			MediaType.APPLICATION_JSON_UTF8_VALUE })
	public ResponseEntity<?> createUser(@RequestBody User user) {
		return null;
	}

}
