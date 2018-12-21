package com.spstudio.hitchcock.service.access;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.spstudio.hitchcock.service.access.impl.IPhotoCRUDService;
import com.spstudio.hitchcock.service.access.impl.PhotoCRUDServiceImpl;

@RunWith(SpringRunner.class)
@WebMvcTest(controllers = {PhotoCRUDServiceImpl.class})
class PhotoAccessServiceImplTest {

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
	IPhotoCRUDService service;

	@Test
	void test() {
		assertThat(service.loadPhotoById(1)).isPresent();
		assertThat(service.loadPhotoById(100)).isNotPresent();
	}

}
