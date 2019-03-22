package com.spstudio.hitchcock.integrationtest;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;

import com.spstudio.hitchcock.HitchcockApplication;
import com.spstudio.hitchcock.entity.Photo;
import com.spstudio.hitchcock.entity.User;

/**
 * SpringBootTest won't start real web server, be default is run with Mock mode
 * 
 * @author sp
 *
 */

@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
public class HitchcockIntegrationTest {

	@Autowired
	private TestRestTemplate restTemplate;

	@Test
	public void happyPath() throws Exception {

		// create user

		User user = new User();
		user.setUsername("william");
		ResponseEntity<User> userCreatedResponse = restTemplate.postForEntity("/api/v1/users", user, User.class);
		HttpHeaders headers = userCreatedResponse.getHeaders();
		User savedUser = userCreatedResponse.getBody();

		assertThat(headers.getContentType()).isEqualTo(MediaType.APPLICATION_JSON_UTF8);
		assertThat(userCreatedResponse.getStatusCode()).isEqualTo(HttpStatus.CREATED);
		assertThat(savedUser).hasFieldOrProperty("id");
		assertThat(savedUser).hasFieldOrProperty("username");
		assertThat(savedUser.getId()).isNotEqualTo(0L);
		assertThat(savedUser.getUsername()).isNotEmpty();

		// create photo belong to current user

		Photo photo = new Photo();
		photo.setFilename("photo.jpg");
		ResponseEntity<Photo> photoCreatedResponse = restTemplate.postForEntity("/api/v1/users/{userId}/photos", photo,
				Photo.class, savedUser.getId());
		headers = photoCreatedResponse.getHeaders();
		Photo savedPhoto = photoCreatedResponse.getBody();

		assertThat(headers.getContentType()).isEqualTo(MediaType.APPLICATION_JSON_UTF8);
		assertThat(userCreatedResponse.getStatusCode()).isEqualTo(HttpStatus.CREATED);
		assertThat(savedPhoto).hasFieldOrProperty("id");
		assertThat(savedPhoto).hasFieldOrProperty("filename");
		assertThat(savedPhoto.getId()).isNotEqualTo(0L);
		assertThat(savedPhoto.getFilename()).isNotEmpty();

		// beautify photo

		HttpHeaders requestHeaders = new HttpHeaders();
		requestHeaders.setContentType(MediaType.APPLICATION_JSON_UTF8);
		HttpEntity<Void> entity = new HttpEntity<>(null, requestHeaders);

		ResponseEntity<Photo> beautifiedPhotoResponse = restTemplate.exchange("/api/v1/photos/{photoId}/beauty",
				HttpMethod.PUT, entity, Photo.class, savedPhoto.getId());
		headers = beautifiedPhotoResponse.getHeaders();

		assertThat(headers.getContentType()).isEqualTo(MediaType.APPLICATION_JSON_UTF8);
		assertThat(beautifiedPhotoResponse.getStatusCode()).isEqualTo(HttpStatus.OK);
	}

	@Test
	void entrypoint() {
		HitchcockApplication.main(new String[]{});
	}
}
