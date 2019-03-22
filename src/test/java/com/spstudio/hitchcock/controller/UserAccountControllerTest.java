package com.spstudio.hitchcock.controller;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.BDDMockito.given;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
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
import com.spstudio.hitchcock.entity.User;
import com.spstudio.hitchcock.service.photo.IPhotoStorageService;
import com.spstudio.hitchcock.service.user.IUserAccountService;
import com.spstudio.hitchcock.testutil.UserInstanceFactory;

@WebMvcTest(controllers = { UserAccountController.class })
class UserAccountControllerTest {

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
	IUserAccountService userAccountService;

	@MockBean
	IPhotoStorageService photoStorageService;

	@Test
	void createUserWithUserExist() throws Exception {
		given(userAccountService.createUserAccount(any(User.class))).willReturn(Optional.empty());

		// @formatter:off
		mvc.perform(post("/api/v1/users")
				.content("{\"username\": \"william\"}")
				.contentType(MediaType.APPLICATION_JSON_UTF8_VALUE)
				.accept(MediaType.APPLICATION_JSON_UTF8_VALUE))
				.andExpect(status().isConflict());
		// @formatter:on
	}

	@Test
	void createUserWithHappyPath() throws Exception {
		given(userAccountService.createUserAccount(any(User.class)))
				.willReturn(Optional.of(UserInstanceFactory.createUserInstanceWithUsername("william")));

		// @formatter:off
		mvc.perform(post("/api/v1/users")
				.content("{\"username\": \"william\"}")
				.contentType(MediaType.APPLICATION_JSON_UTF8_VALUE)
				.accept(MediaType.APPLICATION_JSON_UTF8_VALUE))
				.andExpect(status().isCreated())
				.andExpect(content().contentType(MediaType.APPLICATION_JSON_UTF8_VALUE))
				.andExpect(content().json("{\"username\": \"william\"}", false));
		// @formatter:on
	}

	@Test
	void createPhotoWithPhotoNotFound() throws Exception {
		given(photoStorageService.savePhotoForUser(eq(1L), any(Photo.class))).willReturn(Optional.empty());
		// @formatter:off
		mvc.perform(post("/api/v1/users/{userId}/photos", 1L)
				.content("{\"filename\": \"profile.jpg\"}")
				.contentType(MediaType.APPLICATION_JSON_UTF8_VALUE)
				.accept(MediaType.APPLICATION_JSON_UTF8_VALUE))
				.andExpect(status().isNotFound());
		// @formatter:on
	}

	@Test
	void createPhotoWithHappyPath() throws Exception {
		Photo mockedPhoto = new Photo();
		mockedPhoto.setFilename("profile.jpg");
		given(photoStorageService.savePhotoForUser(anyLong(), any(Photo.class))).willReturn(Optional.of(mockedPhoto));
		// @formatter:off
		mvc.perform(post("/api/v1/users/{userId}/photos", 1L)
				.content("{\"filename\": \"profile.jpg\"}")
				.contentType(MediaType.APPLICATION_JSON_UTF8_VALUE)
				.accept(MediaType.APPLICATION_JSON_UTF8_VALUE))
				.andExpect(status().isCreated())
				.andExpect(content().json("{\"filename\": \"profile.jpg\"}", false));
		// @formatter:on
	}

}
