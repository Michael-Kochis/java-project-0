package com.revature.controller;

import org.apache.log4j.Logger;

import com.revature.view.console.ConsoleMainUI;

public class Driver {
	private static Logger log = Logger.getLogger(Driver.class);
	private static ConsoleMainUI con = new ConsoleMainUI();

	public static void main(String[] args) {
		//log.info("Application started successfully.");
		con.setWidth(18);
		con.displayMenu();		
	}

}
