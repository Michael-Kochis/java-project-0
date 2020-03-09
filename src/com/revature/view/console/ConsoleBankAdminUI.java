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
		bankAdminMenu.setTitle("Bank Admin Commands ");
		bankAdminMenu.add('1', "Grant employee permissions");
		bankAdminMenu.add('2', "Grant employee permissions");
		bankAdminMenu.add('3', "Revoke user permissions");
		bankAdminMenu.add('4', "Cancel an account");
		bankAdminMenu.add('5', "Deposit into an account");
		bankAdminMenu.add('6', "Withdraw from an account");
		bankAdminMenu.add('7', "Transfer funds between accounts");
		bankAdminMenu.add('C', "Access your bank accounts as a Customer");
		bankAdminMenu.add('E', "Access Bank Employee Commands");
		bankAdminMenu.add('V', "View all Customers");
		bankAdminMenu.add('W', "View all Accounts");
		bankAdminMenu.add('X', "Log off and return to login menu.");
		bankAdminMenu.add('Q', "Log off and close application.");
	}
}
