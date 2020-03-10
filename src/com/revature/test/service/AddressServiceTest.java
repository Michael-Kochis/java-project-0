package com.revature.test.service;

import static org.junit.Assert.*;

import java.util.TreeSet;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import com.revature.dao.AddressDAO;
import com.revature.model.Address;
import com.revature.model.BankID;
import com.revature.service.AddressService;
import com.revature.service.UserService;

public class AddressServiceTest {
	private AddressService as = new AddressService();

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
	public void testInstantiates() {
		AddressDAO ad = new AddressDAO();
		as = new AddressService(ad);
		
		assertNotNull(as);
	}
	
	@Test
	public void testCreate() {
		Address addr = new Address(0,
				"4 BigMoney Blvd", "", 
				"New York City", "NY",
				10006);
		
		as.create(addr);
		as.createUserAddress(0L, 0L);
		
		assertTrue(addr.equals(as.readByUID(0L)));
	}

	@Test
	public void testReadAll() {
		TreeSet<Address> addr = as.readAll();
		
		assertNotNull(addr);
	}
	
	@Test
	public void testReadByUID() {
		Address addr = as.readByUID(0L);
		
		assertNotNull(addr);
	}
	
	@Test 
	public void testReadByUserUID() {
		TreeSet<Address> addr = as.readAllByUserUID(0L);
		
		assertNotNull(addr);
	}
	
	@Test
	public void testUpdate( ) {
		String suite = "Suite 42";
		Address addr = as.readByUID(0L);
		addr.setStreet2(suite);
		
		as.update(addr);
		addr = as.readByUID(0L);
		
		assertTrue(suite.equalsIgnoreCase(addr.getStreet2()));		
	}
}
