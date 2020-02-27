package com.revature.model;

public class PHash {
	private String salt;
	private String pwHash;
	
	public PHash() {
		super();
		this.pwHash = new String();
	}
	
	public PHash(String s) {
		this();
		this.setHash(s);
	}
	
	public PHash(String s, String h) {
		this(s);
		this.setHash(h);
	}
	
	public void setHash(String s) {
		this.pwHash = s;
	}
	
	public boolean checkPassword(String s) {
		return pwHash.equals(s);
	}
	
	public void setSalt(String s) {
		this.salt = "";
		this.salt.concat(s);
	}
	
	public String getSalt() {
		return this.salt;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((pwHash == null) ? 0 : pwHash.hashCode());
		result = prime * result + ((salt == null) ? 0 : salt.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		PHash other = (PHash) obj;
		if (pwHash == null) {
			if (other.pwHash != null)
				return false;
		} else if (!pwHash.equals(other.pwHash))
			return false;
		if (salt == null) {
			if (other.salt != null)
				return false;
		} else if (!salt.equals(other.salt))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "PHash [salt=" + salt + ", pwHash=" + pwHash + "]";
	}
}
