package com.spstudio.hitchcock.service.beauty.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.spstudio.hitchcock.entity.Photo;
import com.spstudio.hitchcock.service.beauty.IPhotoBeautyService;

@Service
public class PhotoAutoLightService implements IPhotoBeautyService{

	Logger logger = LoggerFactory.getLogger(PhotoAutoLightService.class);
	
	@Override
	public void updatePhoto(Photo photo) {
		logger.info("-- auto light is effective");
	}

}
