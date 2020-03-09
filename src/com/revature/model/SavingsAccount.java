package com.revature.model;

import com.revature.enums.AccountType;
import com.revature.model.interfaces.SavingsAccountable;

public class SavingsAccount extends Account implements SavingsAccountable {
	public SavingsAccount() {
		super();
		this.setType(AccountType.ACCT_SAVE);
	}

	@Override
	public boolean depositAuthUser(User u) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean depositAuthUID(long uid) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean withdrawAuthUser(User u) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean withdrawAuthUID(long uid) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean transferAuthUser(User u, Account a) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean transferAuthUID(long uUid, long aUid) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean viewAuthUser(User u) {
		return viewAuthUID(u.getBankID());
	}

	@Override
	public boolean viewAuthUID(long uid) {
		// TODO Auto-generated method stub
		return false;
	}
	
	
}
