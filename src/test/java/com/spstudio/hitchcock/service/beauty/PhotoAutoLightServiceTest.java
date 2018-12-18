package com.spstudio.hitchcock.service.beauty;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.spstudio.hitchcock.service.beauty.impl.PhotoAutoLightService;

@RunWith(SpringRunner.class)
@WebMvcTest(controllers = {PhotoAutoLightService.class})
class PhotoAutoLightServiceTest {

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
	IPhotoBeautyService service;
	
	@Test
	void testUpdatePhoto() {
		service.updatePhoto(null);
	}

}
