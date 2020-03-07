package com.revature.test.service;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import com.revature.dao.AccountDAO;
import com.revature.service.AccountService;

public class AccountServiceTest {
	AccountService as = new AccountService();

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testExists() {
		assertNotNull(as);
	}

	@Test
	public void testInstantiate() {
		AccountDAO ad = new AccountDAO();
		as = new AccountService(ad);
		
		assertNotNull(as);
	}

}
