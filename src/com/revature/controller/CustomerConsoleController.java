package com.revature.controller;

import java.util.Scanner;

import org.apache.log4j.Logger;

import com.revature.controller.model.UserLogin;
import com.revature.enums.AccountType;
import com.revature.model.Account;
import com.revature.model.BankID;
import com.revature.model.FullUser;
import com.revature.model.Transaction;
import com.revature.model.User;
import com.revature.service.AccountService;
import com.revature.service.UserService;
import com.revature.test.service.TransactionService;
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
					MainMenuController.runMainUI();
				} else if (temp.equalsIgnoreCase("E")) {
					if (runAs.isEmployee()) {
					    log.trace("Request from user to go to Customer menu.");
					    CustomerConsoleController.runCustomerUI(runAs);
					} else {
						log.warn("Attempt by user " + runAs.getUser().getName() + " to access employee functions.");
						System.out.println("Access violation detected, returning you to login screen.");
						runAs = null;
						MainMenuController.runMainUI();
					}
				//} else if (temp.equalsIgnoreCase("D")) { // used for troubleshooting
				//	System.out.println(runAs.toString());
				} else if (temp.equalsIgnoreCase("A")) {
					if (runAs.isAdmin()) {
					    log.trace("Request from user to go to Admin menu.");
					    BankAdminConsoleController.runAdminUI(runAs);
					} else {
						log.warn("Attempt by user " + runAs.getUser().getName() + " to access admin functions.");
						System.out.println("Access violation detected, returning you to login screen.");
						runAs = null;
						MainMenuController.runMainUI();
					}
				} else if (temp.equalsIgnoreCase("1")) {
					log.trace("Customer applying for savings account");
					System.out.println("Account application complete, pending approval.");
					AccountService.accountApplication(runAs.user.getBankID(), AccountType.APPLY_SAVE);
				} else if (temp.equalsIgnoreCase("2")) {
					log.trace("Customer applying for checking account.");
					System.out.println("Account application complete, pending approval.");
					AccountService.accountApplication(runAs.user.getBankID(), AccountType.APPLY_CHECK);
					cc.displayMenu();;
				} else if (temp.equalsIgnoreCase("3")) {
					long acctNum;
					User other;
					String inString;
					
					log.trace("Customer applying for joint account.");
					System.out.println("Which account do you want to make a joint account?");
					inString = scan.nextLine();
					acctNum = Long.parseLong(inString);
					System.out.println("Which user do you wish to share the account with?");
					inString = scan.nextLine();
					other = UserService.readByUsername(inString);
					if (other == null) {
						log.warn("Error while assigning joint account.");
						System.out.println("There was an error processing this request.");
					} else {
						log.trace("User " + runAs.getUser().getName() + " has shared account "
								+ acctNum + " with user " + other.getName());
						AccountService.createUserAccount(other.getBankID(), acctNum);
						System.out.println("Account is now shared.");
					}
					cc.displayMenu();;
				} else if (temp.equalsIgnoreCase("4")) {
					runAs.showAccounts();
					cc.displayMenu();
				} else if (temp.equalsIgnoreCase("5")) {
					for (Account a : runAs.accts) {						
						if ((a.getType() == AccountType.CANCEL) ||
							a.getType() == AccountType.DENY) {
							AccountService.deleteAccount(a);
						}
					}
					runAs.setAccts(AccountService.readAllByUserUID(runAs.getUser().getBankID()) );
				} else if (temp.equalsIgnoreCase("6")) {
					long acctUID;
					double amount;
					Account editThis = null;
					runAs.showAccounts();
					System.out.println("Please select one of the above accounts.");
					acctUID = scan.nextLong();
					System.out.println("How much did you want to deposit?");
					amount = scan.nextDouble();
					if (amount <= 0.0) {
						System.out.println("Invalid amount.");
						log.info("Attempt by " + runAs.getUser().getName() + " to deposit invalid amount.");
					}
					for (Account a : runAs.accts) {
						if (a.getAccountNumber() == acctUID) {
							editThis = a;
						}
					}
					if (editThis == null) {
						System.out.println("You lack permission to edit that account.");
						log.info("Attempt by " + runAs.getUser().getName() + " to access account " + acctUID);
					} else {
						AccountService.deposit(runAs.getUser().getBankID(), editThis, amount);
						log.trace("User " + runAs.getUser().getName() + " successfully added " + amount
								+ " to account " + acctUID );
						System.out.println("Transaction complete.");

					} 
					cc.displayMenu();
				} else if (temp.equalsIgnoreCase("7")) {	
					long acctUID;
					double amount;
					Account editThis = null;
					
					runAs.showAccounts();
					System.out.println("Please select one of the above accounts.");
					acctUID = scan.nextLong();
					System.out.println("How much did you want to withdraw?");
					amount = scan.nextDouble();
					if (amount <= 0.0) {
						System.out.println("Invalid amount.");
						log.info("Attempt by " + runAs.getUser().getName() + " to withdraw invalid amount.");
					}
					for (Account a : runAs.accts) {
						if (a.getAccountNumber() == acctUID) {
							editThis = a;
						}
					}
					if (editThis == null) {
						System.out.println("You lack permission to edit that account.");
						log.info("Attempt by " + runAs.getUser().getName() + " to access account " + acctUID);
					} else if (amount > editThis.getBalance()) {
						System.out.println("Exceeds amount of available money in account.");
						log.info("Attempt by " + runAs.getUser().getName() + " to withdraw invalid amount.");
					} else {					
						AccountService.withdraw(runAs.getUser().getBankID(), editThis, amount);
						
						log.trace("User " + runAs.getUser().getName() + " successfully withdrew " + amount
								+ " from account " + acctUID );
						System.out.println("Transaction complete.");
					}
					cc.displayMenu();
				} else if (temp.equalsIgnoreCase("8")) {
					long acctUID;
					double amount;
					Account editThis = null;
					
					runAs.showAccounts();
					System.out.println("Please select one of the above accounts.");
					acctUID = scan.nextLong();
					for (Account a : runAs.accts) {
						if (a.getAccountNumber() == acctUID) {
							editThis = a;
						}
					}
					if (editThis == null) {
						System.out.println("You lack permission to edit that account.");
						log.info("Attempt by " + runAs.getUser().getName() + " to access account " + acctUID);
					} 
					System.out.println("Please account to transfer to.");
					long destUID = scan.nextLong();
					System.out.println("How much did you want to transfer?");
					amount = scan.nextDouble();
					if (amount <= 0.0) {
						System.out.println("Invalid amount.");
						log.info("Attempt by " + runAs.getUser().getName() + " to withdraw invalid amount.");
					}
					if (amount > editThis.getBalance()) {
						System.out.println("Exceeds amount of available money in source account.");
						log.info("Attempt by " + runAs.getUser().getName() + " to withdraw invalid amount.");
					} else {					
						AccountService.withdraw(runAs.getUser().getBankID(), editThis, amount);
						Account destAccount = AccountService.readByAccountUID(destUID);
						AccountService.deposit(runAs.getUser().getBankID(), destAccount, amount);
						
						log.trace("User " + runAs.getUser().getName() + " successfully transferred " + amount
								+ " from account " + acctUID + " to " + destUID);
						System.out.println("Transaction complete.");
					}
					cc.displayMenu();
				}
			} 
		}
	}
}

