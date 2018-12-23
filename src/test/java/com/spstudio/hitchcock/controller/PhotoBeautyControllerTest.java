package com.spstudio.hitchcock.controller;

import static org.mockito.BDDMockito.given;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.Optional;
import java.util.Set;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import com.spstudio.hitchcock.service.photo.IPhotoBeautyService;
import com.spstudio.hitchcock.service.photo.impl.PhotoStorageServiceImpl;

@RunWith(SpringRunner.class)
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
	Set<IPhotoBeautyService> photoBeautyServices;

	@MockBean
	PhotoStorageServiceImpl photoStorageService;

	@Test
	void beautifyPhotoWithNotFound() throws Exception {
		given(photoStorageService.loadPhotoById(1L)).willReturn(Optional.empty());
//		given(photoBeautyServices.iterator()).willReturn(Collections.<IPhotoBeautyService>emptySet().iterator());

		mvc.perform(put("/api/v1/photos/{photoId}/beauty", 1)
				.contentType(MediaType.APPLICATION_JSON_UTF8_VALUE)
				.accept(MediaType.APPLICATION_JSON_UTF8_VALUE))
				.andExpect(status().isNotFound());
	}

}
