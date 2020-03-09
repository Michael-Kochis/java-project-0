package com.revature.service;

import java.util.TreeSet;

import org.apache.log4j.Logger;

import com.revature.dao.AccountDAO;
import com.revature.enums.AccountType;
import com.revature.model.Account;
import com.revature.model.BankID;
import com.revature.model.FullUser;
import com.revature.model.Transaction;
import com.revature.test.service.TransactionService;

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
    
    public static TreeSet<Account> readAllApplied() {
    	TreeSet<Account> returnThis = ad.readAllByType(AccountType.APPLY_SAVE);
    	returnThis.addAll(ad.readAllByType(AccountType.APPLY_CHECK));
    	
    	return returnThis;
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

	public static Account readByAccountUID(long uid) {
		return ad.readAccountByUID(uid);
	}

	public static void updateAccount(Account a) {
		ad.updateAccount(a);
	}

	public static void deleteAccount(Account a) {
		ad.deleteAccount(a);
	}
	
	public static void deposit(long userUID, Account a, double howMuch) {
		a.setBalance(a.getBalance() + howMuch);
		AccountService.updateAccount(a);
		Transaction t = new Transaction(
				BankID.getNextBankID(), userUID,
				a.getAccountNumber(), 0L, howMuch);
		TransactionService.create(t);		
	}
	
	public static void withdraw(long userUID, Account a, double howMuch) {
		a.setBalance(a.getBalance() - howMuch);
		AccountService.updateAccount(a);
		Transaction t = new Transaction(
				BankID.getNextBankID(), userUID,
				a.getAccountNumber(), 1L, howMuch);
		TransactionService.create(t);		
	}
}
