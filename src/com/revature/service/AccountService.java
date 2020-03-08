package com.revature.service;

import java.util.TreeSet;

import org.apache.log4j.Logger;

import com.revature.dao.AccountDAO;
import com.revature.model.Account;

public class AccountService {
	private static Logger log = Logger.getLogger(AccountService.class);
    private static AccountDAO ad = new AccountDAO();
    
    public AccountService() {
    	super();
    }
    
    public AccountService(AccountDAO nd) {
    	this();
    	ad = nd;
    }
    
    public static TreeSet<Account> readAllByUserUID(long uid) {
    	return ad.readAllByUserUID(uid);
    }
}