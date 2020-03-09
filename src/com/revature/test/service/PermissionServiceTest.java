package com.revature.test.service;

import static org.junit.Assert.*;

import java.util.TreeSet;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import com.revature.dao.PermissionsDAO;
import com.revature.enums.PermissionType;
import com.revature.model.Permission;
import com.revature.service.PermissionService;

public class PermissionServiceTest {
	private static PermissionService ps = new PermissionService();

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
		assertNotNull(ps);
	}
	
	@Test
	public void testReadPermission() {
		TreeSet<Permission> tp = ps.readPermissionsByUID(1);
		
		assertTrue(tp.size() == 0);
	}

	@Test
	public void testAddPermission() {
		ps.createPermission(1, PermissionType.PERM_EMP);
		TreeSet<Permission> tp = ps.readPermissionsByUID(1);
		
		assertTrue(tp.size() == 1);
	}

	@Test
	public void testRevokePermission() {
		ps.createPermission(1, PermissionType.PERM_EMP);
		ps.removeAllPermissionsByUserUID(1);
		TreeSet<Permission> tp = ps.readPermissionsByUID(1);
		
		assertTrue(tp.size() == 0);
	}

}
