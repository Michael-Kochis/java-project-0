package com.revature.view.console;

import org.apache.log4j.Logger;

public class ConsoleEmployeeUI extends ConsoleMenu {
	private Logger log = Logger.getLogger(ConsoleMainUI.class);
	private static ConsoleMenu employeeMenu = new ConsoleMenu();

	public ConsoleEmployeeUI() {
		super();
		init();
	}

	public void setWidth(int nw) {
		employeeMenu.setWidth(nw);
	}
	
	public void displayMenu() {
		employeeMenu.displayMenu();
	}

	
	private void init() {
		employeeMenu.setTitle("Bank Employee Commands");
		employeeMenu.add('1', "Approve accounts.");
		employeeMenu.add('A', "Access Administrative Commands.");
		employeeMenu.add('E', "Access your customer menu.");
		employeeMenu.add('X', "Log off and return to login menu.");
		employeeMenu.add('Q', "Log off and close application.");
	}
}
