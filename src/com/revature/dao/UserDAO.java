package com.revature.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.TreeSet;

import org.apache.log4j.Logger;

import com.revature.dao.interfaces.UserDAOInterface;
import com.revature.model.PHash;
import com.revature.model.User;

public class UserDAO implements UserDAOInterface {
	private static Logger log = Logger.getLogger(UserDAO.class);

	@Override
	public void createUser(User u) {
	      try {
		  	    Connection testConn = JDBCConnector.getConn();
		  	    PreparedStatement st = testConn.prepareStatement("INSERT INTO BANKUSER VALUES (?, ?, ?)");
		  	    st.setLong(1, u.getBankID());
		  	    st.setString(2, u.getName());
		  	    st.setString(3, u.getHash().getHash());
		  	    st.execute();
		  	    log.trace("Single record successfully inserted into BankUser table.");
			  } catch (SQLException e){
				log.warn("Error while inserting into BankUser table in database", e);
			  }
	}

	@Override
	public void deleteUser(User u) {
		deleteUserByUID(u.getBankID());
	}
	
	@Override
	public void deleteUserByUID(long uid) {
	      try {
		  	    Connection testConn = JDBCConnector.getConn();
		  	    PreparedStatement st = testConn.prepareStatement("DELETE FROM BANKUSER WHERE BANKUID = ?");
		  	    st.setLong(1, uid);
		  	    st.execute();
		  	    log.trace("Record successfully deleted from User table in database");
			  } catch (SQLException e){
				 	log.warn("Error while removing from User table in database", e);
			  }      
	}

	@Override
	public boolean exist(User u) {
		return existByUID(u.getBankID());
	}

	@Override
	public boolean existByUID(long uid) {
		User exists = this.readUserByUID(uid);
		if (exists == null) {
			return false;
		} else {
			return true;
		}
	}

	@Override
	public boolean existByName(String name) {
		User exists = this.readUserByUsername(name);
		if (exists == null) {
			return false;
		} else {
			return true;
		}
	}

	@Override
	public TreeSet<User> readAllUsers() {
		  TreeSet<User> returnThis = new TreeSet<User>();
		  
	      try {
		    Connection testConn = JDBCConnector.getConn();
		    PreparedStatement st = testConn.prepareStatement("SELECT * FROM BANKUSER");
		    ResultSet rs = st.executeQuery();
		    
	    	User neoUser;
	    	long uid;
	    	String nName;
	    	String nHash;

	    	while (rs.next()) {
		    	uid = rs.getLong("BANKUID");
		    	nName = rs.getString("USERNAME");
		    	nHash = rs.getString("PASSWD");
		    	PHash tHash = new PHash(nHash);
		    	
		    	neoUser = new User(uid, nName, tHash);
		    	returnThis.add(neoUser);
		    }
		  } catch (SQLException e){
		 	log.warn("Error while accessing Accounts table in database", e);
	  	  }
	      
	      log.trace(returnThis.size() + " records returned from Accounts table.");
		  return returnThis;
	}

	@Override
	public User readUser(User u) {
		return readUserByUID(u.getBankID());
	}

	@Override
	public User readUserByUID(long uid) {
		  User returnThis = null;
		  
	      try {
		    Connection testConn = JDBCConnector.getConn();
		    PreparedStatement st = testConn.prepareStatement("SELECT * FROM BANKUSER WHERE BANKUID = ?");
		    st.setLong(1, uid);
		    ResultSet rs = st.executeQuery();
		    
	    	long nUID;
	    	String nName;
	    	String tHash;

	    	if (rs.next()) {
		    	nUID = rs.getLong("BANKUID");
		    	nName = rs.getString("USERNAME");
		    	tHash = rs.getString("PASSWD");
		    	PHash nPHash = new PHash(tHash);
		    	
			    log.trace( "Single record returned from Accounts table.");
		    	returnThis = new User(nUID, nName, nPHash);
		    } else {
		    	log.info("Attempt to retreive record from Accounts table failed");
		    }
		  } catch (SQLException e){
		 	log.warn("Error while accessing Accounts table in database", e);
	  	  }
	      
		  return returnThis;
	}

	@Override
	public User readUserByUsername(String s) {
		  User returnThis = null;
		  
	      try {
		    Connection testConn = JDBCConnector.getConn();
		    PreparedStatement st = testConn.prepareStatement("SELECT * FROM BANKUSER WHERE USERNAME = ?");
		    st.setString(1, s);
		    ResultSet rs = st.executeQuery();
		    
	    	long nUID;
	    	String nName;
	    	String tHash;

	    	if (rs.next()) {
		    	nUID = rs.getLong("BANKUID");
		    	nName = rs.getString("USERNAME");
		    	tHash = rs.getString("PASSWD");
		    	PHash nPHash = new PHash(tHash);
		    	
			    log.trace( "Single record returned from Accounts table.");
		    	returnThis = new User(nUID, nName, nPHash);
		    } else {
		    	log.info("Attempt to retreive record from Accounts table failed");
		    }
		  } catch (SQLException e){
		 	log.warn("Error while accessing Accounts table in database", e);
	  	  }
	      
		  return returnThis;
	}

	@Override
	public void updateUser(User u) {
	      try {
		  	    Connection testConn = JDBCConnector.getConn();
		  	    PreparedStatement st = testConn.prepareStatement("UPDATE BANKUSER SET USERNAME = ?, PASSWD = ? WHERE BANKUID = ?");
		  	    st.setString(1, u.getName());
		  	    st.setString(2, u.getHash().getHash());
		  	    st.setLong(3, u.getBankID());
		  	    st.execute();
		  	    log.trace("Record successfully updated in Accounts table in database");
			  } catch (SQLException e){
				 	log.warn("Error while updating Accounts table in database", e);
			  }      
	}

}
