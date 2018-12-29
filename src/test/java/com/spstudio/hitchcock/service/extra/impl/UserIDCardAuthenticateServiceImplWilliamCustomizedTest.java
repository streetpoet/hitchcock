package com.spstudio.hitchcock.service.extra.impl;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.web.client.RestTemplate;

import com.spstudio.hitchcock.service.extra.impl.annotation.WilliamBootTest;
import com.spstudio.hitchcock.service.extra.impl.annotation.WilliamBootTest.WebEnvironment;
import com.spstudio.hitchcock.service.extra.impl.bean.NoPurposeBean;

@RunWith(SpringRunner.class)
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
		noPurposeBean.printVersion();
	}

}
