package com.spstudio.hitchcock.service.access.impl;

import java.util.Optional;

import com.spstudio.hitchcock.entity.Photo;

public interface IPhotoCRUDService {

	public Optional<Photo> savePhoto(Photo photo);
	public Optional<Photo> loadPhotoById(long id);
}
