package com.revature.view.console;

import org.apache.log4j.Logger;

public class ConsoleBankAdminUI extends ConsoleMenu {
	private Logger log = Logger.getLogger(ConsoleMainUI.class);
	private static ConsoleMenu bankAdminMenu = new ConsoleMenu();

	public ConsoleBankAdminUI() {
		super();
		init();
	}

	public void setWidth(int nw) {
		bankAdminMenu.setWidth(nw);
	}
	
	public void displayMenu() {
		bankAdminMenu.displayMenu();
	}

	
	private void init() {
		bankAdminMenu.setTitle("Bank Admin Commands");
		bankAdminMenu.add('C', "Access your bank accounts as a Customer");
		bankAdminMenu.add('E', "Access Bank Employee Commands");
		bankAdminMenu.add('X', "Log off and return to login menu.");
		bankAdminMenu.add('Q', "Log off and close application.");
	}
}
