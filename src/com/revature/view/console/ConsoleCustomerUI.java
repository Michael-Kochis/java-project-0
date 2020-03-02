package com.revature.view.console;

import org.apache.log4j.Logger;

public class ConsoleCustomerUI extends ConsoleMenu {
	private Logger log = Logger.getLogger(ConsoleMainUI.class);
	private static ConsoleMenu bankCustomerMenu = new ConsoleMenu();

	public ConsoleCustomerUI() {
		super();
		init();
	}

	public void setWidth(int nw) {
		bankCustomerMenu.setWidth(nw);
	}
	
	public void displayMenu() {
		bankCustomerMenu.displayMenu();
	}

	
	private void init() {
		bankCustomerMenu.setTitle("Bank Admin Commands");
		bankCustomerMenu.add('A', "Access Bank Admin Commands");
		bankCustomerMenu.add('E', "Access Bank Employee Commands");
		bankCustomerMenu.add('Q', "Log off and return to login menu.");
		bankCustomerMenu.add('X', "Log off and close application.");
	}

}
