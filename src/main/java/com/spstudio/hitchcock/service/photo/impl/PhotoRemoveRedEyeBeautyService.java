package com.spstudio.hitchcock.service.photo.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.spstudio.hitchcock.entity.Photo;
import com.spstudio.hitchcock.service.photo.IPhotoBeautyService;

@Service
public class PhotoRemoveRedEyeBeautyService implements IPhotoBeautyService {

	Logger logger = LoggerFactory.getLogger(PhotoRemoveRedEyeBeautyService.class);

	@Override
	public void beautifyPhoto(Photo photo) {
		logger.info("remove red eye applied");
	}

}
