package com.revature.controller.model;

import java.util.Scanner;

import org.apache.log4j.Logger;

import com.revature.controller.MainMenuController;
import com.revature.controller.RootMenuController;
import com.revature.dao.UserDAO;
import com.revature.model.FullUser;
import com.revature.model.User;
import com.revature.service.UserService;
import com.revature.view.scanner.ConsoleScanner;

public class UserLogin {
	private static Logger log = Logger.getLogger(UserDAO.class);
	private static UserService us = new UserService();
	private static Scanner scan = ConsoleScanner.getScanner();
		
	public static void Login() {
		User user = null;
		String uname = null, pword = null;
		
		System.out.println("Enter your username.");
		uname = scan.nextLine();
		uname = uname.trim(); //remove all spaces
		if (!us.existByName(uname)) {
				log.trace("Attempt to log in as nonexistent username " + uname);
				System.out.println("Username " + uname + " does not exist.");
				MainMenuController.runMainUI();
		} else {
			System.out.println("Please enter your password.");
			pword = scan.nextLine();
			user = us.readByUsername(uname);
			if (user.checkPassword(pword)) {
				log.trace("User " + uname + " has successfully logged in.");
				FullUser login = new FullUser(user);
				RootMenuController.runRootMenu(login);
			} else {
				System.out.println("That password is incorrect.");
				MainMenuController.runMainUI();
			}
		}
	}

}
