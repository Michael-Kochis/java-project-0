package com.revature.controller;

import java.util.Scanner;

import org.apache.log4j.Logger;

import com.revature.controller.model.UserLogin;
import com.revature.controller.model.UserRegister;
import com.revature.view.console.ConsoleMainUI;
import com.revature.view.scanner.ConsoleScanner;

public class MainMenuController {
	private static Logger log = Logger.getLogger(MainMenuController.class);
	private static ConsoleMainUI con = new ConsoleMainUI();
    private static Scanner scan = ConsoleScanner.getScanner();
    private static UserRegister ur = new UserRegister();
	
	public static void runMainUI() { 
		String input = null;
		con.displayMenu();
		while (true) {
			input = scan.nextLine();
			String temp = "";
			for (int i = 0; i < input.length(); i++) {
				temp = input.substring(i, (i+1) );
				if (temp.equalsIgnoreCase("Q")) {
					log.trace("Request from user to exit.");
					System.exit(0);
				} else if (temp.equalsIgnoreCase("1")) {
					log.trace("Request from the user to log in.");
					UserLogin.Login();
				} else if (temp.equalsIgnoreCase("2")) {
					log.trace("Request from user to Register");
					ur.userInput();
					i += input.length();
					MainMenuController.runMainUI();
				} 
			}
		}
		//System.out.println(input);
	}

}
