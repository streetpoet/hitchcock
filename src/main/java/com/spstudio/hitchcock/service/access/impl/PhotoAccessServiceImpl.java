package com.spstudio.hitchcock.service.access.impl;

import java.util.Optional;

import org.springframework.stereotype.Service;

import com.spstudio.hitchcock.entity.Photo;
import com.spstudio.hitchcock.service.access.IPhotoAccessService;

@Service
public class PhotoAccessServiceImpl implements IPhotoAccessService{

	@Override
	public Optional<Photo> loadPhotoById(int id) {
		if (!(id < 100)) {
			return Optional.empty();
		}
		Photo mockPhoto = new Photo();
		mockPhoto.setId(id);
		return Optional.of(mockPhoto);
	}

}
