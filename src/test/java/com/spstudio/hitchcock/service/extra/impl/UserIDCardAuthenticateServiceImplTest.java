package com.spstudio.hitchcock.service.extra.impl;

import static org.assertj.core.api.Assertions.assertThat;
import static org.springframework.test.web.client.ExpectedCount.once;
import static org.springframework.test.web.client.match.MockRestRequestMatchers.requestTo;
import static org.springframework.test.web.client.response.MockRestResponseCreators.withSuccess;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.client.AutoConfigureWebClient;
import org.springframework.boot.test.autoconfigure.web.client.RestClientTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.client.MockRestServiceServer;

import com.spstudio.hitchcock.entity.User;
import com.spstudio.hitchcock.testutil.UserInstanceFactory;

@RunWith(SpringRunner.class)
@RestClientTest(UserIDCardAuthenticateServiceImpl.class)
@AutoConfigureWebClient(registerRestTemplate = true)
class UserIDCardAuthenticateServiceImplTest {

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
	MockRestServiceServer mockRemoteServer;

	@Autowired
	UserIDCardAuthenticateServiceImpl service;

	@Test
	void test() {
		mockRemoteServer.expect(once(), requestTo("http://website/api/v1/idcheck/william"))
				.andRespond(withSuccess("true", MediaType.TEXT_PLAIN));
		User user = UserInstanceFactory.createUserInstanceWithUsername("william");
		user.setId(1L);
		boolean result = service.isValidIdCard(user);
		assertThat(result).isTrue();
		mockRemoteServer.verify();
	}

}
