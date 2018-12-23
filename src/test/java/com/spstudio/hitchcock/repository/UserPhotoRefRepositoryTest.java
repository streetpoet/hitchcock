package com.spstudio.hitchcock.repository;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.Optional;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.junit4.SpringRunner;

import com.spstudio.hitchcock.entity.UserPhotoPK;
import com.spstudio.hitchcock.entity.UserPhotoRef;

@RunWith(SpringRunner.class)
@DataJpaTest
class UserPhotoRefRepositoryTest {

	@Autowired
	private TestEntityManager entityManager;

	@Autowired
	UserPhotoRefRepository userPhotoRefRepository;

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

	@Test
	void test() {
		UserPhotoRef ref = new UserPhotoRef();
		ref.setEnabled(true);
		UserPhotoPK primaryKey = new UserPhotoPK();
		primaryKey.setUserId(1L);
		primaryKey.setPhotoId(1L);
		ref.setId(primaryKey);
		
		UserPhotoRef savedRef = userPhotoRefRepository.save(ref);
		assertThat(savedRef).isNotNull();
		
		Optional<UserPhotoRef> optionalRef = userPhotoRefRepository.findById(primaryKey);
		assertThat(optionalRef).isPresent();
		assertThat(optionalRef.get()).hasFieldOrPropertyWithValue("enabled", true);
	}

}
