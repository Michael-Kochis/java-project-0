package com.revature.controller;

import org.apache.log4j.Logger;

import com.revature.model.FullUser;
import com.revature.view.console.ConsoleBankAdminUI;

public class BankAdminConsoleController {
	private static Logger log = Logger.getLogger(BankAdminConsoleController.class);
	private static ConsoleBankAdminUI ca = new ConsoleBankAdminUI();

	public static void runAdminUI(FullUser runAs) {
		ca.displayMenu();
		
	}

}
