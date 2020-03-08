package com.revature.controller;

import java.util.Scanner;

import org.apache.log4j.Logger;

import com.revature.controller.model.UserLogin;
import com.revature.enums.AccountType;
import com.revature.model.FullUser;
import com.revature.service.AccountService;
import com.revature.view.console.ConsoleCustomerUI;
import com.revature.view.scanner.ConsoleScanner;

public class CustomerConsoleController {
	private static Logger log = Logger.getLogger(CustomerConsoleController.class);
	private static ConsoleCustomerUI cc = new ConsoleCustomerUI();
	private static Scanner scan = ConsoleScanner.getScanner();

	public static void runCustomerUI(FullUser runAs) {
		String input = null;
		cc.displayMenu();
		
		
		while (true) {
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
				} else if (temp.equalsIgnoreCase("E")) {
					if (runAs.isEmployee()) {
					    log.trace("Request from user to go to Customer menu.");
					    CustomerConsoleController.runCustomerUI(runAs);
					} else {
						log.warn("Attempt by user " + runAs.getUser().getName() + " to access employee functions.");
						System.out.println("Access violation detected, returning you to login screen.");
						runAs = null;
						UserLogin.Login();
					}
				} else if (temp.equalsIgnoreCase("A")) {
					if (runAs.isAdmin()) {
					    log.trace("Request from user to go to Admin menu.");
					    BankAdminConsoleController.runAdminUI(runAs);
					} else {
						log.warn("Attempt by user " + runAs.getUser().getName() + " to access admin functions.");
						System.out.println("Access violation detected, returning you to login screen.");
						runAs = null;
						UserLogin.Login();
					}
				} else if (temp.equalsIgnoreCase("1")) {
					log.trace("Customer applying for savings account");
					System.out.println("Account application complete, pending approval.");
					AccountService.accountApplication(runAs.user.getBankID(), AccountType.APPLY_SAVE);
					cc.displayMenu();
				} else if (temp.equalsIgnoreCase("2")) {
					log.trace("Customer applying for checking account.");
					System.out.println("Account application complete, pending approval.");
					AccountService.accountApplication(runAs.user.getBankID(), AccountType.APPLY_CHECK);
					cc.displayMenu();;
				} 
			
			} 
		}
	}
}

