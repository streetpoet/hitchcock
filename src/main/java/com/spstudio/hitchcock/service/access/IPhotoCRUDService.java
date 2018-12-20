package com.spstudio.hitchcock.service.access;

import java.util.Optional;

import com.spstudio.hitchcock.entity.Photo;

public interface IPhotoCRUDService {

	public Optional<Photo> loadPhotoById(int id);
}
