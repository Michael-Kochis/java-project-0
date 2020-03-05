package com.revature.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.TreeSet;

import org.apache.log4j.Logger;

import com.revature.dao.interfaces.AccountDAOInterface;
import com.revature.enums.AccountType;
import com.revature.model.Account;

public class AccountDAO implements AccountDAOInterface {
	private static Logger log = Logger.getLogger(AccountDAO.class);
	
	public AccountDAO() {
		super();
	}

	@Override
	public void createAccount(Account a) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteAccount(Account a) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public TreeSet<Account> readAllAccounts() {
	  TreeSet<Account> returnThis = new TreeSet<Account>();
	  
      try {
	    Connection testConn = JDBCConnector.getConn();
	    PreparedStatement st = testConn.prepareStatement("SELECT * FROM BANKACCOUNT");
	    ResultSet rs = st.executeQuery();
	    
    	Account neoAccount;
    	long uid;
    	AccountType type;
    	double balance;

    	while (rs.next()) {
	    	uid = rs.getLong("BANKUID");
	    	type = AccountType.intToType(rs.getInt("ACCTTYPE"));
	    	balance = rs.getDouble("amount");
	    	
	    	neoAccount = new Account(uid, type, balance);
	    	returnThis.add(neoAccount);
	    }
	  } catch (SQLException e){
	 	log.warn("Error while accessing Accounts table in database", e);
  	  }
      
      log.trace(returnThis.size() + " records returned from Accounts table.");
	  return returnThis;
	}

	@Override
	public Account readAccount(Account a) {
		return readAccountByUID(a.getAccountNumber());
	}

	@Override
	public Account readAccountByUID(long uid) {
		  Account returnThis = null;
		  
	      try {
		    Connection testConn = JDBCConnector.getConn();
		    PreparedStatement st = testConn.prepareStatement("SELECT * FROM BANKACCOUNT WHERE BANKUID = ?");
		    st.setLong(1, uid);
		    ResultSet rs = st.executeQuery();
		    
	    	long auid;
	    	AccountType type;
	    	double balance;

	    	if (rs.next()) {
		    	auid = rs.getLong("BANKUID");
		    	type = AccountType.intToType(rs.getInt("ACCTTYPE"));
		    	balance = rs.getDouble("amount");
		    	
			    log.trace( "Single record returned from Accounts table.");
		    	returnThis = new Account(auid, type, balance);
		    } else {
		    	log.info("Attempt to retreive record from Accounts table failed");
		    }
		  } catch (SQLException e){
		 	log.warn("Error while accessing Accounts table in database", e);
	  	  }
	      
		  return returnThis;
	}

	@Override
	public void updateAccount(Account a) {
		// TODO Auto-generated method stub
		
	}

}
