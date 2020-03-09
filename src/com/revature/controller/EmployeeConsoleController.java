package com.revature.controller;

import java.util.Scanner;
import java.util.TreeSet;

import org.apache.log4j.Logger;

import com.revature.controller.model.UserLogin;
import com.revature.enums.AccountType;
import com.revature.model.Account;
import com.revature.model.FullUser;
import com.revature.service.AccountService;
import com.revature.view.console.ConsoleEmployeeUI;
import com.revature.view.scanner.ConsoleScanner;

public class EmployeeConsoleController {
	private static Logger log = Logger.getLogger(EmployeeConsoleController.class);
	private static ConsoleEmployeeUI ce = new ConsoleEmployeeUI();
	private static Scanner scan = ConsoleScanner.getScanner();

	public static void runEmployeeUI(FullUser runAs) {
		String input = null;
		
		
		while (true) {
			ce.displayMenu();
			input = scan.nextLine();
			String temp = "";
			for (int i = 0; i < input.length(); i++) {
				temp = input.substring(i, (i+1) );
				if (temp.equalsIgnoreCase("Q")) {
					log.trace("Request from user to exit.");
					System.exit(0);
				} else if (temp.equalsIgnoreCase("X")) {
					log.trace("Request from the user to return to log in.");
					runAs = null;
					UserLogin.Login();
				} else if (temp.equalsIgnoreCase("W")) {
					AccountService.viewAll();
				} else if (temp.equalsIgnoreCase("V")) {
					FullUser.viewAllUsers();
				} else if (temp.equalsIgnoreCase("A")) {
					if (runAs.isAdmin()) {
					    log.trace("Request from user to go to Admin menu.");
					    CustomerConsoleController.runCustomerUI(runAs);
					} else {
						log.warn("Attempt by user " + runAs.getUser().getName() + " to access admin functions.");
						System.out.println("Access violation detected, returning you to login screen.");
						runAs = null;
						MainMenuController.runMainUI();
					}
				} else if (temp.equalsIgnoreCase("C")) {
					log.trace("Request from user to go to Customer menu.");
					CustomerConsoleController.runCustomerUI(runAs);
				} else if (temp.equalsIgnoreCase("1")) {
					TreeSet<Account> list = AccountService.readAllApplied();
					for (Account a : list) {
						System.out.println(a);
					}
					System.out.println("Which account do you want to approve?");
					long uid = scan.nextLong();
					Account editThis = AccountService.readByAccountUID(uid);
					if (editThis.getType() == AccountType.APPLY_CHECK) {
						editThis.setType(AccountType.ACCT_CHECK);
					} else {
						editThis.setType(AccountType.ACCT_SAVE);
					}
					AccountService.updateAccount(editThis);
					System.out.println("Account approved and ready for use.");
					log.trace("Account " + uid + " is approved and ready for use.");
				} else if (temp.equalsIgnoreCase("2")) {
					TreeSet<Account> list = AccountService.readAllApplied();
					for (Account a : list) {
						System.out.println(a);
					}
					System.out.println("Which account do you want to deny?");
					long uid = scan.nextLong();
					Account editThis = AccountService.readByAccountUID(uid);
					editThis.setType(AccountType.DENY);
					AccountService.updateAccount(editThis);
					System.out.println("Account denied.");
					log.trace("Account " + uid + " is denied.");
				}
			}
		}
	}

}
