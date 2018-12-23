package com.spstudio.hitchcock.service.photo.impl;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.test.context.junit4.SpringRunner;

import com.spstudio.hitchcock.entity.Photo;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = { PhotoRemoveRedEyeBeautyService.class }, webEnvironment = WebEnvironment.NONE)
class PhotoRemoveRedEyeBeautyServiceTest {

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
	PhotoRemoveRedEyeBeautyService service;
	
	@Test
	void test() {
		service.beautifyPhoto(new Photo());
	}

}
