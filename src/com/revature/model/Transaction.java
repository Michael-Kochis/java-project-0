package com.revature.model;

import java.sql.Time;
import java.util.Date;

public class Transaction {
	long transactionUID;
	long userUID;
	long accountUID;
	long transType; // TODO: make this an enum and switch the string values
	double amount;
	Date transDay;
	Time transTime;

	public Transaction() {
		super();
	}
	
	public Transaction(long uid, long owner, long acct, long type, double nd) {
		super();
		this.transactionUID = uid;
		this.userUID = owner;
		this.accountUID = acct;
		this.transType = type;
		this.amount = nd;
	}

	public long getTransactionUID() {
		return transactionUID;
	}

	public void setTransactionUID(long transactionUID) {
		this.transactionUID = transactionUID;
	}

	public long getUserUID() {
		return userUID;
	}

	public void setUserUID(long userUID) {
		this.userUID = userUID;
	}

	public long getAccountUID() {
		return accountUID;
	}

	public void setAccountUID(long accountUID) {
		this.accountUID = accountUID;
	}

	public long getTransType() {
		return transType;
	}

	public void setTransType(long transType) {
		this.transType = transType;
	}

	public double getAmount() {
		return amount;
	}

	public void setAmount(double amount) {
		this.amount = amount;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + (int) (accountUID ^ (accountUID >>> 32));
		long temp;
		temp = Double.doubleToLongBits(amount);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		result = prime * result + ((transDay == null) ? 0 : transDay.hashCode());
		result = prime * result + ((transTime == null) ? 0 : transTime.hashCode());
		result = prime * result + (int) (transType ^ (transType >>> 32));
		result = prime * result + (int) (transactionUID ^ (transactionUID >>> 32));
		result = prime * result + (int) (userUID ^ (userUID >>> 32));
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
		Transaction other = (Transaction) obj;
		if (accountUID != other.accountUID)
			return false;
		if (Double.doubleToLongBits(amount) != Double.doubleToLongBits(other.amount))
			return false;
		if (transDay == null) {
			if (other.transDay != null)
				return false;
		} else if (!transDay.equals(other.transDay))
			return false;
		if (transTime == null) {
			if (other.transTime != null)
				return false;
		} else if (!transTime.equals(other.transTime))
			return false;
		if (transType != other.transType)
			return false;
		if (transactionUID != other.transactionUID)
			return false;
		if (userUID != other.userUID)
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Transaction [transactionUID=" + transactionUID + ", userUID=" + userUID + ", accountUID=" + accountUID
				+ ", transType=" + transType + ", amount=" + amount + ", transDay=" + transDay + ", transTime="
				+ transTime + "]";
	}
}
