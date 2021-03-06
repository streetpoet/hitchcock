package com.spstudio.hitchcock.service.extra.impl;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.web.client.RestTemplate;

import com.spstudio.hitchcock.service.extra.impl.annotation.WilliamBootTest;
import com.spstudio.hitchcock.service.extra.impl.annotation.WilliamBootTest.WebEnvironment;
import com.spstudio.hitchcock.service.extra.impl.bean.NoPurposeBean;

@WilliamBootTest(classes = { UserIDCardAuthenticateServiceImpl.class }, webEnvironment = WebEnvironment.NONE)
class UserIDCardAuthenticateServiceImplWilliamCustomizedTest {

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

	@MockBean
	RestTemplate template;
	
	@Autowired
	NoPurposeBean noPurposeBean;
	
	@Test
	void test() {
		assertThat(noPurposeBean.printVersion()).isEqualToIgnoringCase("v1.0");
	}

}
