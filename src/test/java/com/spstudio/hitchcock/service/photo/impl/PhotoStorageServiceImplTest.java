package com.spstudio.hitchcock.service.photo.impl;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.BDDMockito.given;

import java.util.Optional;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

import com.spstudio.hitchcock.entity.Photo;
import com.spstudio.hitchcock.entity.User;
import com.spstudio.hitchcock.entity.UserPhotoRef;
import com.spstudio.hitchcock.repository.PhotoRepository;
import com.spstudio.hitchcock.repository.UserPhotoRefRepository;
import com.spstudio.hitchcock.repository.UserRepository;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = { PhotoStorageServiceImpl.class }, webEnvironment = WebEnvironment.NONE)
class PhotoStorageServiceImplTest {

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
	PhotoStorageServiceImpl photoService;

	@MockBean
	UserRepository userRepository;

	@MockBean
	PhotoRepository photoRepository;

	@MockBean
	UserPhotoRefRepository userPhotoRefRepository;

	@Test
	void savePhotoForUserWithUserNotFound() {
		given(userRepository.findById(anyLong())).willReturn(Optional.empty());
		Optional<UserPhotoRef> optionalResult = photoService.savePhotoForUser(1L, new Photo());
		assertThat(optionalResult).isNotPresent();
	}

	@Test
	void savePhotoForUserWithHappyPath() {
		given(userRepository.findById(100L)).willReturn(Optional.of(new User()));

		Photo photo = new Photo();
		photo.setId(100L);
		photo.setFilename("profile.jpg");
		given(photoRepository.save(any(Photo.class))).willReturn(photo);

		given(userPhotoRefRepository.save(any(UserPhotoRef.class))).willReturn(new UserPhotoRef());

		Optional<UserPhotoRef> optionalResult = photoService.savePhotoForUser(100L, new Photo());
		assertThat(optionalResult).isPresent();
	}

}
