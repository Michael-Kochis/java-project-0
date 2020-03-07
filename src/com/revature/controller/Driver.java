package com.revature.controller;


import org.apache.log4j.Logger;

import com.revature.model.BankID;
import com.revature.service.UserService;

public class Driver {
	private static Logger log = Logger.getLogger(Driver.class);

	public static void main(String[] args) {
		BankID.setLastID(UserService.getMax());
		
		log.info("Application started successfully.");
		
		MainMenuController.runMainUI();
		
		log.trace("Application ending successfully.\n\n");
	}

}
