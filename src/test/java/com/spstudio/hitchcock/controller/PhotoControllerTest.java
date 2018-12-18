package com.spstudio.hitchcock.controller;

import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.BDDMockito.given;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.Collections;
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

import com.spstudio.hitchcock.controller.PhotoController;
import com.spstudio.hitchcock.entity.Photo;
import com.spstudio.hitchcock.service.access.IPhotoAccessService;
import com.spstudio.hitchcock.service.beauty.IPhotoBeautyService;

@RunWith(SpringRunner.class)
@WebMvcTest(controllers = {PhotoController.class})
class PhotoControllerTest {

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

	@MockBean
	Set<IPhotoBeautyService> photoBeautyServices;

	@MockBean
	IPhotoAccessService photoAccessService;
	
	@Autowired
	MockMvc mvc;
	
	@Test
	void testGetPhotoWithStatusOk() throws Exception {
		
		given(photoAccessService.loadPhotoById(anyInt()))
			.willReturn(Optional.of(new Photo()));
		given(photoBeautyServices.iterator())
			.willReturn(Collections.<IPhotoBeautyService>emptySet().iterator());
		
		mvc.perform(
				get("/api/photo/{id}", 0)
				.accept(MediaType.APPLICATION_JSON_UTF8)
				.header("key1", "value1")
				.param("p1", "v1"))
			.andExpect(status().isOk())
			.andExpect(content().contentType(MediaType.APPLICATION_JSON_UTF8))
			.andExpect(content().json("{\"id\":0}", false));
		
	}
	
	@Test
	void testGetPhotoWithStatusNotFound() throws Exception {
		given(photoAccessService.loadPhotoById(anyInt()))
			.willReturn(Optional.empty());
		given(photoBeautyServices.iterator())
			.willReturn(Collections.<IPhotoBeautyService>emptySet().iterator());
	
	mvc.perform(
			get("/api/photo/{id}", 0)
			.accept(MediaType.APPLICATION_JSON_UTF8)
			.header("key1", "value1")
			.param("p1", "v1"))
		.andExpect(status().isNotFound());
	}

}
