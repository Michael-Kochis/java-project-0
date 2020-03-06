package com.revature.model;

public class User {
	private long bankID;
	private String name;
	private PHash password;
	
	public User() {
		super();
		this.bankID = BankID.getNextBankID();
	}
	
	public User(String name) {
		this();
		this.setName(name);
	}
	
	public User(long uid, String nName, PHash passwd) {
		this(nName);
		this.bankID = uid;
		this.password = passwd;
	}

	public long getBankID() {
		return this.bankID;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	public boolean checkPassword(String s) {
		return this.password.checkPassword(s);
	}
	
	/** Hatred for this method, exists only due to persistence. */
	public PHash getHash() {
		return this.password;
	}

	public void setPassword(String s) {
		if ((this.password) == null) {
			this.password = new PHash(s);
		} else {
		    this.password.setPassword(s);
		}
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + (int) (bankID ^ (bankID >>> 32));
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		result = prime * result + ((password == null) ? 0 : password.hashCode());
		return result;
	}

	/* NOTE: for safety reasons, password is NOT compared. */
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (this.getClass() != obj.getClass())
			return false;
		User other = (User) obj;
		if (bankID != other.bankID)
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		
		return true;
	}

	/* TODO: Use a StringBuilder for this, why overload String Pool? */
	@Override
	public String toString() {
		return "User [bankID=" + bankID + ", name=" + name + "]";
	}
	

}
