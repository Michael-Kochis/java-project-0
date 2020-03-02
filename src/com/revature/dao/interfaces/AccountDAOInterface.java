package com.revature.dao.interfaces;

import java.util.TreeSet;

import com.revature.model.Account;

public interface AccountDAOInterface {
	public void createAccount(Account a);
	public void deleteAccount(Account a);
	public TreeSet<Account> readAllAccounts();
	public Account readAccount(Account a);
	public TreeSet<Account> readAccountsbyOwnerUID(long uid);
	public Account readAccountByUID(long uid);
	public void updateAccount(Account a);
}
