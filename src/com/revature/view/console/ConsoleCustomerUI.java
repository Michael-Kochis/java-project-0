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
		bankCustomerMenu.setTitle("Customer Menu ");
		bankCustomerMenu.add('1', "Apply for a savings account");
		bankCustomerMenu.add('2', "Apply for a checking account");
		bankCustomerMenu.add('3', "Make one of your accounts a joint account");
		bankCustomerMenu.add('4', "View all of your accounts");
		bankCustomerMenu.add('5', "Delete your denied/cancelled accounts");
		bankCustomerMenu.add('6', "Deposit into an account");
		bankCustomerMenu.add('7', "Withdraw from an account");
		bankCustomerMenu.add('8', "Transfer from an account you own.");
		bankCustomerMenu.add('9', "View/Edit your customer information.");
		bankCustomerMenu.add('A', "Access Bank Admin Commands");
		bankCustomerMenu.add('E', "Access Bank Employee Commands");
		bankCustomerMenu.add('X', "Log off and return to login menu.");
		bankCustomerMenu.add('Q', "Log off and close application.");
	}

}
