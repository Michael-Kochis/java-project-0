package com.revature.enums;

public enum AccountType {
	ACCT_CHECK, ACCT_SAVE;
	
	public static AccountType intToType(int input) {
		switch(input) {
		case 1: return AccountType.ACCT_CHECK;
		default: return AccountType.ACCT_SAVE;
		}
	}
	
	public static int typeToInt(AccountType a) {
		if (a == AccountType.ACCT_CHECK) {
			return 1;
		} else {
			return 0;
		}
	}
}
