package com.revature.controller;

import java.util.TreeSet;

import org.apache.log4j.Logger;

import com.revature.dao.AccountDAO;
import com.revature.enums.AccountType;
import com.revature.model.Account;
import com.revature.view.console.ConsoleMainUI;

public class Driver {
	private static Logger log = Logger.getLogger(Driver.class);
	private static ConsoleMainUI con = new ConsoleMainUI();

	public static void main(String[] args) {
		AccountDAO ad = new AccountDAO();
		Account a = new Account(2, AccountType.intToType(2), 0.0d);
		
		log.info("Application started successfully.");
		ad.createAccount(a);
		a.setBalance(50.0d);
		ad.updateAccount(a);
		ad.deleteAccountByUID(2);
		//con.displayMenu();
		log.trace("Application ending successfully.\n\n");
	}

}
