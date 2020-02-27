package com.revature.test;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import com.revature.model.BankID;
import com.revature.model.PHash;
import com.revature.model.User;

public class UserTest {
	private User user = new User();

	/* Suite setup, before tests instantiated. */
	@BeforeClass
	public static void setupBeforeClass() throws Exception {
		
	}
	
	@AfterClass
	public static void tearDownAfterClass() throws Exception {
		
	}
	
	/* Individual test case setup*/
	@Before
	public void setUp() {

	}
	
	/* Close individual test. */
	@After
	public void tearDown() {
		
	}
	
	@Test
	public void testUserDefaultInit() {
		assertNotNull(user);
	}
	
	@Test
	public void testUserInitName() {
		String tName = "Kaiser Soze";
		user = new User(tName);
		
		assertEquals(tName, user.getName());
	}
	
	@Test
	public void testUserSetGetName() {
		String tName = "Kaiser Soze";
		
		user.setName(tName);
		
		assertEquals(tName, user.getName());		
	}

	@Test
	public void testUserSetGetBankID() {
		long testID = BankID.getNextBankID() + 1;
		User user2 = new User();
		
		assertEquals(testID, user2.getBankID());		
	}
	
	/* TODO: Insert User method tests here. */

	@Test
	public void testUserPassword() {
		String pwString = "onomotopaiea";
		
		user.setPassword(pwString);
		
		assertTrue(user.checkPassword(pwString));		
	}
	
	@Test
	public void testUserPasswordCase2() {
		String pwString = "onomotopaiea";
		String pwString2 = "beehive";
		
		user.setPassword(pwString2);
		user.setPassword(pwString);
		
		assertTrue(user.checkPassword(pwString));		
		
	}
	
	@Test
	public void testUserHashCode() {
		assertEquals(user.hashCode(), user.hashCode());
	}

	@Test
	public void testUserEquals() {
		User user2 = user;
		assertTrue(user.equals(user2));		
	}
	
	@Test
	public void testUserNotEqualNull() {
		assertFalse(user.equals(null));
	}
	
	@SuppressWarnings("unlikely-arg-type")
	@Test
	public void testUserNotEqualWrongClass() {
		PHash ptest = new PHash();
		
		assertFalse(user.equals(ptest));
	}
	
	@Test
	public void testUserNotEqualBankID() {
		User user2 = new User(user.getName());
		
		assertFalse(user.equals(user2));
	}

	@Test
	public void testUserToString() {
		String testString = "User [bankID=2, name=null]";
		
		assertEquals(testString, user.toString());		
	}

}
