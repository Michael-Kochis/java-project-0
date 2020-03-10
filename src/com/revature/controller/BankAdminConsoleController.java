package com.revature.controller;

import java.util.Scanner;
import java.util.TreeSet;

import org.apache.log4j.Logger;

import com.revature.controller.model.UserLogin;
import com.revature.enums.AccountType;
import com.revature.enums.PermissionType;
import com.revature.model.Account;
import com.revature.model.Address;
import com.revature.model.BankID;
import com.revature.model.FullUser;
import com.revature.model.User;
import com.revature.service.AccountService;
import com.revature.service.AddressService;
import com.revature.service.PermissionService;
import com.revature.service.UserService;
import com.revature.view.console.ConsoleBankAdminUI;
import com.revature.view.scanner.ConsoleScanner;

public class BankAdminConsoleController {
	private static Logger log = Logger.getLogger(BankAdminConsoleController.class);
	private static ConsoleBankAdminUI ca = new ConsoleBankAdminUI();
	private static Scanner scan = ConsoleScanner.getScanner();

	public static void runAdminUI(FullUser runAs) {
		String input = null;
		
		while (true) {
			ca.displayMenu();
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
				} else if (temp.equalsIgnoreCase("E")) {
					if (runAs.isEmployee()) {
					    log.trace("Request from user to go to Employee menu.");
					    EmployeeConsoleController.runEmployeeUI(runAs);
					} else {
						log.warn("Attempt by user " + runAs.getUser().getName() + " to access employee functions.");
						System.out.println("Access violation detected, returning you to login screen.");
						runAs = null;
						MainMenuController.runMainUI();
					}
				} else if (temp.equalsIgnoreCase("C")) {
					log.trace("Request from user to go to Customer menu.");
					CustomerConsoleController.runCustomerUI(runAs);
				} else if (temp.equalsIgnoreCase("1")) {
					System.out.println("Please enter the username to grant permissions.");
					String target = scan.nextLine();
					User tUser = UserService.readByUsername(target);
					if (tUser == null) {
						System.out.println("Unable to locate a user with that username.");
						log.info("User " + runAs + " attempted to grant access to nonexistent " + target);
					} else {
						PermissionService.createPermission(tUser.getBankID(), PermissionType.PERM_EMP);
						log.trace("User " + runAs.getUser().getName() + " granted employee access to " + target);
					}
				} else if (temp.equalsIgnoreCase("2")) {
					System.out.println("Please enter the username to grant permissions.");
					String target = scan.nextLine();
					User tUser = UserService.readByUsername(target);
					if (tUser == null) {
						System.out.println("Unable to locate a user with that username.");
						log.info("User " + runAs + " attempted to grant access to nonexistent " + target);
					} else {
						PermissionService.createPermission(tUser.getBankID(), PermissionType.PERM_ADM);
						PermissionService.createPermission(tUser.getBankID(), PermissionType.PERM_EMP);
						log.trace("User " + runAs.getUser().getName() + " granted admin access to " + target);
					}
				} else if (temp.equalsIgnoreCase("3")) {
					System.out.println("Please enter the username to revoke permissions.");
					String target = scan.nextLine();
					User tUser = UserService.readByUsername(target);
					if (tUser == null) {
						System.out.println("Unable to locate a user with that username.");
						log.info("User " + runAs.getUser().getName() + " attempted to revoke access from nonexistent " + target);
					} else {
						PermissionService.removeAllPermissionsByUserUID(tUser.getBankID()); 
						log.trace("User " + runAs.getUser().getName() + " revoked all access from " + target);
					}
				} else if (temp.equalsIgnoreCase("4")) {
					AccountService.viewAll();
					System.out.println("Select which account to cancel (must have zero funds, 0 to abort process");
					long uid = scan.nextLong();
					if (uid == 0) {						
					} else {
						Account cancelThis = AccountService.readByAccountUID(uid);
						if (cancelThis.getBalance() == 0.0d) {
							cancelThis.setType(AccountType.CANCEL);
							AccountService.updateAccount(cancelThis);
							log.trace("Account " + cancelThis.getAccountNumber() + " has been cancelled.");
						} else {
							System.out.println("Only accounts with zero balance can be cancelled; please withdraw or transfer the funds.");
							log.trace("Account " + cancelThis.getAccountNumber() + " has funds and cannot be cancelled.");
						}
					}
				} else if (temp.equalsIgnoreCase("5")) {
					AccountService.viewAll();
					System.out.println("Select account to deposit funds.");
					long uid = scan.nextLong();
					System.out.println("Select amount to deposit.");
					double amt = scan.nextDouble();
					if (amt <= 0.0) {
						System.out.println("Invalid amount.");
						log.info("Attempt by " + runAs.getUser().getName() + " to deposit invalid amount.");
					} else {
						Account editThis = AccountService.readByAccountUID(uid);
						AccountService.deposit(runAs.getUser().getBankID(), editThis, amt);
						log.trace("User " + runAs.getUser().getName() + " successfully added " + amt
								+ " to account " + uid );
						System.out.println("Transaction complete.");
					}
				} else if (temp.equalsIgnoreCase("6")) {
					AccountService.viewAll();
					System.out.println("Select account to withdraw funds.");
					long uid = scan.nextLong();
					Account editThis = AccountService.readByAccountUID(uid);
					System.out.println("Select amount to withdraw.");
					double amt = scan.nextDouble();
					if (amt > editThis.getBalance()) {
						System.out.println("Exceeds amount of available money in account.");
						log.info("Attempt by " + runAs.getUser().getName() + " to withdraw invalid amount.");
					} else {
						AccountService.withdraw(runAs.getUser().getBankID(), editThis, amt);
						
						log.trace("User " + runAs.getUser().getName() + " successfully withdrew " + amt
								+ " from account " + uid );
						System.out.println("Transaction complete.");
					}				
				} else if (temp.equalsIgnoreCase("7")) {
					AccountService.viewAll();
					System.out.println("Select source account.");
					long suid = scan.nextLong();
					Account sa = AccountService.readByAccountUID(suid);
					System.out.println("Select destination account.");
					long duid = scan.nextLong();
					Account da = AccountService.readByAccountUID(duid);
					System.out.println("Select amount to transfer.");
					double amt = scan.nextDouble();
					if (amt <= 0.0) {
						System.out.println("Invalid amount.");
						log.info("Attempt by " + runAs.getUser().getName() + " to withdraw invalid amount.");
					} else if (amt > sa.getBalance()) {
						System.out.println("Exceeds amount of available money in source account.");
						log.info("Attempt by " + runAs.getUser().getName() + " to withdraw invalid amount.");
					} else {
						AccountService.withdraw(runAs.getUser().getBankID(), sa, amt);
						AccountService.deposit(runAs.getUser().getBankID(), da, amt);
						
						log.trace("User " + runAs.getUser().getName() + " successfully transferred " + amt
								+ " from account " + suid + " to " + duid);
						System.out.println("Transaction complete.");
					}
				} else if (temp.equalsIgnoreCase("8")) {
					TreeSet<Address> properties = AddressService.readAll();
					for (Address property : properties) {
						System.out.println(property.toString());
					}
					
					System.out.println("Enter an address to edit, 0 to exit, any number not above to enter new.");
					long option = scan.nextLong();  scan.nextLine();
					if (option == 0) {						
					} else {
						boolean isNew = false;
						Address toEdit = null;
						for (Address a : runAs.addr) {
							if (a.getBankUID() == option) {
								toEdit = a;
							}
						}
						
						if (toEdit == null) {
							toEdit = new Address();
							toEdit.setBankUID(BankID.getNextBankID());
							isNew = true;
						}
						System.out.println("Enter first line of street address.");
						String nS1 = scan.nextLine();
						toEdit.setStreet1(nS1);
						System.out.println("Enter second line of street address.");
						String nS2 = scan.nextLine();
						toEdit.setStreet2(nS2);
						System.out.println("Please enter the city.");
						String nCity = scan.nextLine();
						toEdit.setCity(nCity);
						System.out.println("Please enter the state.");
						String nState = scan.nextLine();
						toEdit.setState(nState);
						System.out.println("Please enter the zip code.");
						long nZip = scan.nextLong();  scan.nextLine();
						toEdit.setZip(nZip);
						if (isNew) {
							AddressService.create(toEdit);
						} else {
							AddressService.update(toEdit);
						}
						runAs.addr.add(toEdit);
						AddressService.createUserAddress(runAs.getUser().getBankID(), toEdit.getBankUID());
						System.out.println("Your new address has been registered to you.");
						if (isNew) {
							log.trace("User " + runAs.getUser().getName() + " has registered address: " + toEdit.toString());
						} else {
							log.trace("User " + runAs.getUser().getName() + " has modified address " + toEdit.toString());
						}
					}					
				}
			}
		}
		
	}

}
