package com.revature.model;

import com.revature.enums.AccountType;

public class Account {
	private long accountNumber;
	private AccountType type;
	private double balance;
	
	public Account() {
		super();
	}
	
	public Account(long accountNumber, AccountType type, double balance) {
		this();
		this.setAccountNumber(accountNumber);
		this.setType(type);
		this.setBalance(balance);
	}

	public long getAccountNumber() {
		return accountNumber;
	}

	public void setAccountNumber(long accountNumber) {
		this.accountNumber = accountNumber;
	}

	public AccountType getType() {
		return type;
	}

	public void setType(AccountType type) {
		this.type = type;
	}

	public double getBalance() {
		return balance;
	}

	public void setBalance(double balance) {
		this.balance = balance;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + (int) (accountNumber ^ (accountNumber >>> 32));
		long temp;
		temp = Double.doubleToLongBits(balance);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		result = prime * result + ((type == null) ? 0 : type.hashCode());
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
		Account other = (Account) obj;
		if (accountNumber != other.accountNumber)
			return false;
		if (Double.doubleToLongBits(balance) != Double.doubleToLongBits(other.balance))
			return false;
		if (type != other.type)
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Account [accountNumber=" + accountNumber + ", type=" + type + ", balance="
				+ balance + "]";
	}
}


