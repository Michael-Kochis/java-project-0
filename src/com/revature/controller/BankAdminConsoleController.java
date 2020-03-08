package com.revature.controller;

import java.util.Scanner;

import org.apache.log4j.Logger;

import com.revature.controller.model.UserLogin;
import com.revature.model.FullUser;
import com.revature.view.console.ConsoleBankAdminUI;
import com.revature.view.scanner.ConsoleScanner;

public class BankAdminConsoleController {
	private static Logger log = Logger.getLogger(BankAdminConsoleController.class);
	private static ConsoleBankAdminUI ca = new ConsoleBankAdminUI();
	private static Scanner scan = ConsoleScanner.getScanner();

	public static void runAdminUI(FullUser runAs) {
		String input = null;
		ca.displayMenu();
		
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
				} else if (temp.equalsIgnoreCase("C")) {
					log.trace("Request from user to go to Customer menu.");
					CustomerConsoleController.runCustomerUI(runAs);
				} 
			}
		}
		
	}

}
