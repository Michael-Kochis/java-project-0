package com.revature.controller;

import org.apache.log4j.Logger;

import com.revature.model.FullUser;
import com.revature.view.console.ConsoleEmployeeUI;

public class EmployeeConsoleController {
	private static Logger log = Logger.getLogger(EmployeeConsoleController.class);
	private static ConsoleEmployeeUI ce = new ConsoleEmployeeUI();

	public static void runEmployeeUI(FullUser runAs) {
		ce.displayMenu();
		
	}

}
