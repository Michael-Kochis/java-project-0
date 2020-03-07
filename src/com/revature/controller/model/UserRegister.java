package com.revature.controller.model;

import java.util.Scanner;

import org.apache.log4j.Logger;

import com.revature.model.BankID;
import com.revature.model.PHash;
import com.revature.model.User;
import com.revature.service.UserService;
import com.revature.view.scanner.ConsoleScanner;

public class UserRegister {
	private static Logger log = Logger.getLogger(UserRegister.class);
	private Scanner scan = ConsoleScanner.getScanner();
	private UserService us = new UserService();
	
	public void userInput() {
		String uname = null, pword = null, confirm = null;
		
		System.out.println("Enter your username.");
		while (uname == null) {
			uname = scan.nextLine();
			uname = uname.trim(); //remove all spaces
			if (us.existByName(uname)) {
				log.trace("Attempt to duplicate username " + uname);
				uname = null;
				System.out.println("Username " + uname + " is taken, please enter a different username.");
			}
		}
		System.out.println(uname + " is available, please set your password.");
		pword = scan.nextLine();
		System.out.println("Please enter that password again to confirm.");
		confirm = scan.nextLine();
		while (!pword.equals(confirm)) {
			System.out.println("Passwords do not match.");
			log.trace("User " + uname + " failed to enter and confirm their password.");
			System.out.println("Please enter your password.");
			pword = scan.nextLine();
			System.out.println("Please enter that password again to confirm.");
			confirm = scan.nextLine();
		}
		PHash ph = new PHash();  ph.setPassword(pword);
		User newUser = new User(BankID.getNextBankID(), uname, ph);
		us.registerUser(newUser);
	}

}
