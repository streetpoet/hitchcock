package com.spstudio.hitchcock.service.access.impl;

import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spstudio.hitchcock.entity.Photo;
import com.spstudio.hitchcock.repository.PhotoRepository;

@Service
public class PhotoCRUDServiceImpl implements IPhotoCRUDService{

	@Autowired
	PhotoRepository photoRepository;
	
	@Override
	public Optional<Photo> loadPhotoById(long id) {
		if (!(id < 100)) {
			return Optional.empty();
		}
		Photo mockPhoto = new Photo();
		mockPhoto.setId(id);
		return Optional.of(mockPhoto);
	}

	@Transactional
	@Override
	public Optional<Photo> savePhoto(Photo photo) {
		if (photoRepository.findById(photo.getId()).isPresent()) {
			return Optional.empty();
		}
		return Optional.ofNullable(photoRepository.save(photo));
	}

}
