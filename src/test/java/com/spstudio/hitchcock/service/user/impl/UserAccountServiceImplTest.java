package com.spstudio.hitchcock.service.user.impl;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.BDDMockito.given;

import java.util.Optional;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.test.mock.mockito.MockBean;

import com.spstudio.hitchcock.entity.User;
import com.spstudio.hitchcock.repository.UserRepository;
import com.spstudio.hitchcock.testutil.UserInstanceFactory;

@SpringBootTest(classes = { UserAccountServiceImpl.class }, webEnvironment = WebEnvironment.NONE)
class UserAccountServiceImplTest {

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
	UserAccountServiceImpl userAccountService;

	@MockBean
	UserRepository userRepository;

	@Test
	void createUserAccountWithUserExist() {
		given(userRepository.findByUsername(eq("william"))).willReturn(Optional.of(new User()));
		Optional<User> optionalUser = userAccountService
				.createUserAccount(UserInstanceFactory.createUserInstanceWithUsername("william"));
		assertThat(optionalUser).isNotPresent();
	}

	@Test
	void createUserAccountWithHappyPath() {
		given(userRepository.findByUsername(eq("william"))).willReturn(Optional.empty());
		given(userRepository.save(any(User.class))).willReturn(new User());

		Optional<User> optionalUser = userAccountService
				.createUserAccount(UserInstanceFactory.createUserInstanceWithUsername("william"));
		assertThat(optionalUser).isPresent();
	}

	@Test
	void loadUserByIdWithHappyPath() {
		given(userRepository.findById(anyLong())).willReturn(Optional.of(new User()));
		Optional<User> optionalUser = userAccountService.loadUserById(1L);
		assertThat(optionalUser).isPresent();
	}
}
