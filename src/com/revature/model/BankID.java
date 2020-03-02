package com.revature.model;

public class BankID {
	public static long lastID;
	
	public static void setLastID(long neoID) {
		BankID.lastID = neoID;
	}
	
	public static long getNextBankID() {
		lastID++;
		return lastID;
	}
	
	public String toString() {
		return String.valueOf(lastID);
	}
}
