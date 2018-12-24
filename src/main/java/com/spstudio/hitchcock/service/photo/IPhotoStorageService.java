package com.spstudio.hitchcock.service.photo;

import java.util.Optional;

import com.spstudio.hitchcock.entity.Photo;

public interface IPhotoStorageService {

	public Optional<Photo> savePhotoForUser(long userId, Photo photo);

	public Optional<Photo> loadPhotoById(long photoId);
}
