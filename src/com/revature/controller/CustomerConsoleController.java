package com.revature.controller;

import org.apache.log4j.Logger;

import com.revature.model.FullUser;
import com.revature.view.console.ConsoleCustomerUI;

public class CustomerConsoleController {
	private static Logger log = Logger.getLogger(CustomerConsoleController.class);
	private static ConsoleCustomerUI cc = new ConsoleCustomerUI();

	public static void runCustomerUI(FullUser runAs) {
		cc.displayMenu();
		
	}

}
