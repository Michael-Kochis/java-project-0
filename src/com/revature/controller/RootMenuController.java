package com.revature.controller;

import org.apache.log4j.Logger;

import com.revature.enums.PermissionType;
import com.revature.model.FullUser;
import com.revature.model.Permission;

public class RootMenuController {
	private static Logger log = Logger.getLogger(RootMenuController.class);
	
	public static void runRootMenu(FullUser runAs) {
		if (runAs.isAdmin()) {
			log.trace("Admin Access granted to user " + runAs.getUser().getName());
			BankAdminConsoleController.runAdminUI(runAs);
		} else if (runAs.isEmployee()) {
			log.trace("Employee Access granted to user " + runAs.getUser().getName());
			EmployeeConsoleController.runEmployeeUI(runAs);
		} else {
			log.trace("Customer Access granted to user " + runAs.getUser().getName());
			CustomerConsoleController.runCustomerUI(runAs);
		}
		//System.out.println(runAs.toString() );
	}

}
