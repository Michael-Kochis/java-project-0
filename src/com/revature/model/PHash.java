package com.revature.model;

public class PHash {
	String pwHash;
	
	public PHash() {
		super();
		this.pwHash = new String();
	}
	
	public PHash(String s) {
		this();
		this.pwHash = s;
	}
	
	public void setHash(String s) {
		this.pwHash = s;
	}
	
	public boolean checkPassword(String s) {
		return pwHash.equals(s);
	}
}
