package com.revature.model;

import com.revature.enums.AccountType;
import com.revature.model.interfaces.CheckingAccountable;

public class CheckingAccount extends Account implements CheckingAccountable {

	public CheckingAccount() {
		super();
		this.setType(AccountType.ACCT_CHECK);
	}
}
