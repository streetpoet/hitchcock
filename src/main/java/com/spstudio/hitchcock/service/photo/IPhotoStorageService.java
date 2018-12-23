package com.spstudio.hitchcock.service.photo;

import java.util.Optional;

import com.spstudio.hitchcock.entity.Photo;
import com.spstudio.hitchcock.entity.UserPhotoRef;

public interface IPhotoStorageService {

	public Optional<UserPhotoRef> savePhotoForUser(long userId, Photo photo);
	public Optional<Photo> loadPhotoById(long photoId);
}
