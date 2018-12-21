package com.spstudio.hitchcock.service.photo;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.spstudio.hitchcock.entity.Photo;
import com.spstudio.hitchcock.entity.User;
import com.spstudio.hitchcock.entity.UserPhotoPK;
import com.spstudio.hitchcock.entity.UserPhotoRef;
import com.spstudio.hitchcock.repository.PhotoRepository;
import com.spstudio.hitchcock.repository.UserPhotoRefRepository;
import com.spstudio.hitchcock.repository.UserRepository;

@Service
public class UserPhotoServiceImpl implements IUserPhotoService {

	@Autowired
	UserRepository userRepository;

	@Autowired
	PhotoRepository photoRepository;

	@Autowired
	UserPhotoRefRepository userPhotoRefRepository;

	@Transactional
	@Override
	public Optional<UserPhotoRef> savePhotoForUser(long userId, Photo photo) {
		Optional<User> optionalUser = userRepository.findById(userId);
		if (optionalUser.isPresent()) {
			return Optional.empty();
		}
		Photo savedPhoto = photoRepository.save(photo);
		UserPhotoRef userPhotoRef = new UserPhotoRef();
		userPhotoRef.setEnabled(true);
		userPhotoRef.setId(new UserPhotoPK(userId, savedPhoto.getId()));
		return Optional.ofNullable(userPhotoRefRepository.save(userPhotoRef));
	}

}
