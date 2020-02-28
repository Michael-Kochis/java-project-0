package com.revature.view.console;

import org.apache.log4j.Logger;

public class ConsoleMainUI {
	private Logger log = Logger.getLogger(ConsoleMainUI.class);
	private ConsoleMenu mainMenu = new ConsoleMenu();

	public ConsoleMainUI() {
		super();
		init();
	}
	
	public void setWidth(int nw) {
		this.mainMenu.setWidth(nw);
	}
	
	public void displayMenu() {
		mainMenu.displayMenu();
	}

	private void init() {
		mainMenu.setTitle("Main Menu");
		mainMenu.add('1', "Login as an existing user.");
		mainMenu.add('2', "Register as a new user.");
		mainMenu.add('Q', "Exit application.");
	}
	
	
    
}
