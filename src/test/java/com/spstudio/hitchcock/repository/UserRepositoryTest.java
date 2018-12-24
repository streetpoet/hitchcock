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

import com.spstudio.hitchcock.entity.User;
import com.spstudio.hitchcock.testutil.UserInstanceFactory;

@RunWith(SpringRunner.class)
@DataJpaTest
class UserRepositoryTest {

	@Autowired
	private TestEntityManager entityManager;

	@Autowired
	UserRepository userRepository;

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
	void testFindByUsername() {
		Optional<User> optionalUser = userRepository.findByUsername("william");
		assertThat(optionalUser).isNotPresent();

		userRepository.save(UserInstanceFactory.createUserInstanceWithUsername("william"));
		optionalUser = userRepository.findByUsername("william");
		assertThat(optionalUser).isPresent();
		assertThat(optionalUser.get()).hasFieldOrPropertyWithValue("username", "william");

		entityManager.remove(optionalUser.get());
		optionalUser = userRepository.findByUsername("william");
		assertThat(optionalUser).isNotPresent();
	}

}
