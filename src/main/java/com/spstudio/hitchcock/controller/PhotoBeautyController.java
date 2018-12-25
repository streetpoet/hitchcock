package com.spstudio.hitchcock.controller;

import java.util.Iterator;
import java.util.Optional;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.spstudio.hitchcock.entity.Photo;
import com.spstudio.hitchcock.service.photo.IPhotoBeautyService;
import com.spstudio.hitchcock.service.photo.IPhotoStorageService;

@RestController
@RequestMapping(path = "/api/v1", produces = { MediaType.APPLICATION_JSON_UTF8_VALUE })
public class PhotoBeautyController {

	@Autowired
	Set<IPhotoBeautyService> photoBeautyServices;

	@Autowired
	IPhotoStorageService photoStorageService;

	@PutMapping(path = "/photos/{photoId}/beauty")
	public ResponseEntity<Photo> beautifyPhoto(@PathVariable("photoId") long photoId) {
		Optional<Photo> optionalPhoto = photoStorageService.loadPhotoById(photoId);
		if (!optionalPhoto.isPresent()) {
			return ResponseEntity.notFound().build();
		}
		Photo photo = optionalPhoto.get();
		Iterator<IPhotoBeautyService> photoBeautyServiceIterator = photoBeautyServices.iterator();
		while (photoBeautyServiceIterator.hasNext()) {
			photoBeautyServiceIterator.next().beautifyPhoto(photo);
		}
		return ResponseEntity.ok(photo);
	}

}
