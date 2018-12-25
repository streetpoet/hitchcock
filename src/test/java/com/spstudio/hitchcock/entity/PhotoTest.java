package com.spstudio.hitchcock.entity;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.json.JsonTest;
import org.springframework.boot.test.json.JacksonTester;
import org.springframework.test.context.junit4.SpringRunner;

import com.fasterxml.jackson.databind.ObjectMapper;

@RunWith(SpringRunner.class)
@JsonTest
class PhotoTest {

	@BeforeAll
	static void setUpBeforeClass() throws Exception {
	}

	@AfterAll
	static void tearDownAfterClass() throws Exception {
	}

	@BeforeEach
	void setUp() throws Exception {
		ObjectMapper objectMapper = new ObjectMapper();
		JacksonTester.initFields(this, objectMapper);
	}

	@AfterEach
	void tearDown() throws Exception {
	}

	@Autowired
	JacksonTester<Photo> photoJsonTester;

	@Test
	void testPhoto() throws Exception {
		Photo photo = new Photo();
		photo.setFilename("profile.jpg");
		assertThat(photoJsonTester.write(photo)).hasJsonPathStringValue("@.filename");
		assertThat(photoJsonTester.write(photo)).extractingJsonPathStringValue("@.filename")
				.isEqualToIgnoringCase("PROFILE.JPG");
		assertThat(photoJsonTester.write(photo)).isEqualToJson("{\"filename\": \"profile.jpg\"}");
	}

}
