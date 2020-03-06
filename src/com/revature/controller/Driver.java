package com.revature.controller;

import java.util.TreeSet;

import org.apache.log4j.Logger;

import com.revature.dao.PermissionsDAO;
import com.revature.enums.PermissionType;
import com.revature.model.PHash;
import com.revature.model.Permission;
import com.revature.view.console.ConsoleMainUI;

public class Driver {
	private static Logger log = Logger.getLogger(Driver.class);
	private static ConsoleMainUI con = new ConsoleMainUI();

	public static void main(String[] args) {
		//PermissionsDAO pd = new PermissionsDAO();
		//Permission p = new Permission(PermissionType.PERM_ADM);
		PHash ph = new PHash();
		ph.setPassword("IBdaBank");
		
		
		log.info("Application started successfully.");
		//pd.createUserPermission(0L, p);
		System.out.println();
		
		//con.displayMenu();
		log.trace("Application ending successfully.\n\n");
	}

}
