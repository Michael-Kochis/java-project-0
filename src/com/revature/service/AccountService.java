package com.revature.service;

import java.util.TreeSet;

import org.apache.log4j.Logger;

import com.revature.dao.AccountDAO;
import com.revature.enums.AccountType;
import com.revature.model.Account;
import com.revature.model.BankID;
import com.revature.model.FullUser;

public class AccountService {
	private static Logger log = Logger.getLogger(AccountService.class);
    private static AccountDAO ad = new AccountDAO();
    
    public AccountService() {
    	super();
    }
    
    public AccountService(AccountDAO nd) {
    	this();
    	ad = nd;
    }
    
    public static TreeSet<Account> readAllByUserUID(long uid) {
    	return ad.readAllByUserUID(uid);
    }

	public static void accountApplication(long ownerID, AccountType type) {
		long acctNum = BankID.getNextBankID();
		Account a = new Account(acctNum, type, 0.0d);
		ad.createAccount(a);
		ad.createUserAccount(ownerID, acctNum);
		
	}

	public static void createUserAccount(long u, long a) {
		ad.createUserAccount(u, a);
	}
}
