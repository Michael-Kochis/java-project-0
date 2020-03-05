package com.revature.controller;

import org.apache.log4j.Logger;

import com.revature.dao.AccountDAO;
import com.revature.model.Account;
import com.revature.view.console.ConsoleMainUI;

public class Driver {
	private static Logger log = Logger.getLogger(Driver.class);
	private static ConsoleMainUI con = new ConsoleMainUI();

	public static void main(String[] args) {
		AccountDAO ad = new AccountDAO();
		
		log.info("Application started successfully.");
		Account a = ad.readAccountByUID(0L);
		System.out.println(a.toString());
		con.displayMenu();	
	}

}
