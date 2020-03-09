package com.revature.test.service;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import com.revature.dao.AccountDAO;
import com.revature.model.Account;
import com.revature.model.BankID;
import com.revature.service.AccountService;
import com.revature.service.UserService;

public class AccountServiceTest {
	AccountService as = new AccountService();

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		BankID.setLastID(UserService.getMax());
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
	
	@Test
	public void testDeposit() {
		Account zero = AccountService.readByAccountUID(0);
		double balTest = zero.getBalance() + 5.0;
		
		AccountService.deposit(0, zero, 5.0);
		zero = AccountService.readByAccountUID(0);
		
		assertTrue(balTest == zero.getBalance());
	}
	
	@Test
	public void testWithdraw() {
		Account zero = AccountService.readByAccountUID(0);
		double balTest = zero.getBalance() - 5.0;
		
		AccountService.withdraw(0, zero, 5.0);
		zero = AccountService.readByAccountUID(0);
		
		assertTrue(balTest == zero.getBalance());
	}

}
