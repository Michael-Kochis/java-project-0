package com.revature.enums;

public enum AccountType {
	ACCT_CHECK, ACCT_SAVE, APPLY_CHECK, APPLY_SAVE;
	
	public static AccountType intToType(int input) {
		switch(input) {
		case 1: return AccountType.ACCT_CHECK;
		case 2: return AccountType.APPLY_SAVE;
		case 3: return AccountType.APPLY_CHECK;
		default: return AccountType.ACCT_SAVE;
		}
	}
	
	public static int typeToInt(AccountType a) {
		if (a == AccountType.ACCT_CHECK) {
			return 1;
		} else if (a == AccountType.APPLY_SAVE) {
			return 2;
		} else if (a == AccountType.APPLY_CHECK) {
			return 3;
		} else {
			return 0;
		}
	}
}
