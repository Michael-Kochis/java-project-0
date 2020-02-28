package com.revature.test.model;

import static org.junit.Assert.*;

import org.junit.Test;

import com.revature.model.PHash;

public class PHashTest {
	private PHash ph = new PHash();

	@Test
	public void pwTest() {
		String s = "IppiYippiPtangWazoo";
		ph.setPassword(s);
		
		assertTrue(ph.checkPassword(s));
	}

	@Test
	public void pwTestFails() {
		String s = "IppiYippiPtangWazoo";
		String s2 = "IamTheGreatest";
		ph.setPassword(s);
		
		assertFalse(ph.checkPassword(s2));
	}
	
	@Test
	public void equalsWhenSame() {
		PHash ph2 = ph;
		
		assertTrue(ph.equals(ph2));
	}

	@Test
	public void NotEqualsWhenNull() {
		PHash ph2 = null;
		
		assertFalse(ph.equals(ph2));
	}

	@Test
	public void NotEqualsWhenHashDifferent() {
		PHash ph2 = new PHash();
		ph.setPassword("One");
		ph2.setPassword("two");
		
		assertFalse(ph.equals(ph2));
	}

	@Test
	public void equalsWhenHashMatch() {
		PHash ph2 = new PHash("Test");
		PHash ph3 = new PHash("Test");
		
		assertTrue(ph3.equals(ph2));
	}

	@Test
	public void Hashequals() {
		PHash ph2 = new PHash("Test");
		PHash ph3 = new PHash("Test");
		
		assertEquals(ph2.hashCode(), ph3.hashCode());
	}

	@Test
	public void toStringWorks() {
		PHash ph2 = new PHash("Test");
		System.out.println(ph2.toString());
		
		assertEquals("PHash [pwHash=Test]", ph2.toString());
	}

}
