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
import com.revature.model.User;

public class AccountDAO implements AccountDAOInterface {
	private static Logger log = Logger.getLogger(AccountDAO.class);
	
	public AccountDAO() {
		super();
	}

	@Override
	public void createAccount(Account a) {
	      try {
	  	    Connection testConn = JDBCConnector.getConn();
	  	    PreparedStatement st = testConn.prepareStatement("INSERT INTO BANKACCOUNT VALUES (?, ?, ?)");
	  	    st.setLong(1, a.getAccountNumber());
	  	    st.setInt(2, AccountType.typeToInt(a.getType()));
	  	    st.setDouble(3, a.getBalance());
	  	    st.execute();
	  	    log.trace("Single record successfully inserted into Accounts table.");
		  } catch (SQLException e){
			log.warn("Error while inserting into Accounts table in database", e);
		  }
	}

	@Override
	public void createUserAccount(long ownerID, long acctNum) {
	      try {
		  	    Connection testConn = JDBCConnector.getConn();
		  	    PreparedStatement st = testConn.prepareStatement("INSERT INTO USER_ACCOUNT VALUES (?, ?)");
		  	    st.setLong(1, ownerID);
		  	    st.setLong(2, acctNum);
		  	    st.execute();
		  	    log.trace("Single record successfully inserted into UserAccounts table.");
			  } catch (SQLException e){
				log.warn("Error while inserting into UserAccounts table in database", e);
			  }
	
	}

	@Override
	public void deleteAccount(Account a) {
	  deleteAccountByUID(a.getAccountNumber());
	}

	@Override
	public void deleteAccountByUID(long uid) {
	      try {
	  	    Connection testConn = JDBCConnector.getConn();
	  	    PreparedStatement st = testConn.prepareStatement("DELETE FROM BANKACCOUNT WHERE BANKUID = ?");
	  	    st.setLong(1, uid);
	  	    st.execute();
	  	    log.trace("Record successfully deleted from Accounts table in database");
		  } catch (SQLException e){
			 	log.warn("Error while removing from Accounts table in database", e);
		  }      
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
	      try {
		  	    Connection testConn = JDBCConnector.getConn();
		  	    PreparedStatement st = testConn.prepareStatement("UPDATE BANKACCOUNT SET accttype = ?, amount = ? WHERE BANKUID = ?");
		  	    st.setInt(1, AccountType.typeToInt(a.getType()));
		  	    st.setDouble(2, a.getBalance());
		  	    st.setLong(3, a.getAccountNumber());
		  	    st.execute();
		  	    log.trace("Record successfully updated in Accounts table in database");
			  } catch (SQLException e){
				 	log.warn("Error while updating Accounts table in database", e);
			  }      
	}

	@Override
	public TreeSet<Account> readAllByUser(User u) {
		return readAllByUserUID(u.getBankID());
	}

	@Override
	public TreeSet<Account> readAllByUserUID(Long uid) {
		  TreeSet<Account> returnThis = new TreeSet<Account>();
		  
	      try {
		    Connection testConn = JDBCConnector.getConn();
		    PreparedStatement st = testConn.prepareStatement("SELECT * FROM BANKACCOUNT a INNER JOIN USER_ACCOUNT ua ON ua.useruid = ?");
		    st.setLong(1, uid);
		    ResultSet rs = st.executeQuery();
		    
	    	long auid;
	    	AccountType type;
	    	double balance;
	    	
	    	while (rs.next()) {
		    	auid = rs.getLong("BANKUID");
		    	type = AccountType.intToType(rs.getInt("ACCTTYPE"));
		    	balance = rs.getDouble("amount");
		    	
			    Account temp = new Account(auid, type, balance);
		    	returnThis.add(temp);
		    } 
		  } catch (SQLException e){
		 	log.warn("Error while accessing Accounts table in database", e);
	  	  }
	      
	      log.trace(returnThis.size() + " records returned from Accounts table.");
		  return returnThis;
	}

	@Override
	public String toString() {
		return "AccountDAO [AccountDAO has no data fields to enter.]";
	}

}
