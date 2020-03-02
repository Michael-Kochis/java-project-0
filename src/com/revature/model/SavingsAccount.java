package com.revature.model;

import com.revature.enums.AccountType;
import com.revature.model.interfaces.SavingsAccountable;

public class SavingsAccount extends Account implements SavingsAccountable {
	SavingsAccount() {
		super();
		this.setType(AccountType.ACCT_SAVE);
	}
	
	
}
