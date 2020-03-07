package com.revature.service;

import org.apache.log4j.Logger;

import com.revature.dao.AccountDAO;

public class AccountService {
	private static Logger log = Logger.getLogger(AccountService.class);
    private AccountDAO ad = new AccountDAO();
    
    public AccountService() {
    	super();
    }
    
    public AccountService(AccountDAO nd) {
    	this();
    	ad = nd;
    }
}
