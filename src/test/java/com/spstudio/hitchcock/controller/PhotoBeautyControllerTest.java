package com.spstudio.hitchcock.controller;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.BDDMockito.given;
import static org.mockito.BDDMockito.willDoNothing;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.Optional;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import com.spstudio.hitchcock.entity.Photo;
import com.spstudio.hitchcock.service.photo.impl.PhotoAutoLightBeautyService;
import com.spstudio.hitchcock.service.photo.impl.PhotoStorageServiceImpl;

@WebMvcTest(controllers = { PhotoBeautyController.class })
class PhotoBeautyControllerTest {

	@BeforeAll
	static void setUpBeforeClass() throws Exception {
	}

	@AfterAll
	static void tearDownAfterClass() throws Exception {
	}

	@BeforeEach
	void setUp() throws Exception {
	}

	@AfterEach
	void tearDown() throws Exception {
	}

	@Autowired
	MockMvc mvc;

	@MockBean
	PhotoAutoLightBeautyService autoLightBeautyService;

	@MockBean
	PhotoStorageServiceImpl photoStorageService;

	@Test
	void beautifyPhotoWithNotFound() throws Exception {
		given(photoStorageService.loadPhotoById(1L)).willReturn(Optional.empty());

		mvc.perform(put("/api/v1/photos/{photoId}/beauty", 1).contentType(MediaType.APPLICATION_JSON_UTF8_VALUE)
				.accept(MediaType.APPLICATION_JSON_UTF8_VALUE)).andExpect(status().isNotFound());
	}

	@Test
	void beautifyPhotoWithHappyPath() throws Exception {
		given(photoStorageService.loadPhotoById(1L)).willReturn(Optional.of(new Photo()));
		willDoNothing().given(autoLightBeautyService).beautifyPhoto(any(Photo.class));

		mvc.perform(put("/api/v1/photos/{photoId}/beauty", 1).contentType(MediaType.APPLICATION_JSON_UTF8_VALUE)
				.accept(MediaType.APPLICATION_JSON_UTF8_VALUE)).andExpect(status().isOk());
	}

}
