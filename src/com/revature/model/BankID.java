package com.revature.model;

public class BankID {
	public static long lastID;
	
	public static void setLastID() {
		
	}
	
	public static long getNextBankID() {
		lastID++;
		return lastID;
	}
}
