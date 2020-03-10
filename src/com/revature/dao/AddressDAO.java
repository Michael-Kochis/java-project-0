package com.revature.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.TreeSet;

import org.apache.log4j.Logger;

import com.revature.dao.interfaces.AddressDAOInterface;
import com.revature.enums.AccountType;
import com.revature.model.Account;
import com.revature.model.Address;
import com.revature.model.User;

public class AddressDAO implements AddressDAOInterface {
	private static Logger log = Logger.getLogger(AddressDAO.class);

	@Override
	public void createAddress(Address a) {
	      try {
		  	    Connection testConn = JDBCConnector.getConn();
		  	    PreparedStatement st = testConn.prepareStatement("INSERT INTO ADDRESS VALUES (?, ?, ?, ?, ?, ?)");
		  	    st.setLong(1, a.getBankUID());
		  	    st.setString(2, a.getStreet1());
		  	    st.setString(3, a.getStreet2());
		  	    st.setString(4, a.getCity());
		  	    st.setString(5, a.getState());
		  	    st.setLong(6, a.getZip());
		  	    st.execute();
		  	    log.trace("Single record successfully inserted into Address table.");
			  } catch (SQLException e){
				log.warn("Error while inserting into Address table in database", e);
			  }
	}

	@Override
	public void createUserAddress(long ownerID, long addrID) {
	  try {
		Connection testConn = JDBCConnector.getConn();
		PreparedStatement st = testConn.prepareStatement("INSERT INTO USER_ADDRESS VALUES (?, ?)");
  	    st.setLong(1, ownerID);
  	    st.setLong(2, addrID);
	    st.execute();
		log.trace("Single record successfully inserted into User_Address table.");
	  } catch (SQLException e){
	    log.warn("Error while inserting into User_Address table in database", e);
	  }
	}

	@Override
	public void deleteAddress(Address a) {
		deleteAddressByUID(a.getBankUID());
	}

	@Override
	public void deleteAddressByUID(long uid) {
	      try {
		  	    Connection testConn = JDBCConnector.getConn();
		  	    PreparedStatement st = testConn.prepareStatement("DELETE FROM ADDRESS WHERE BANKUID = ?");
		  	    st.setLong(1, uid);
		  	    st.execute();
		  	    log.trace("Record successfully deleted from Address table in database");
			  } catch (SQLException e){
				 	log.warn("Error while removing from Address table in database", e);
			  }      
	}

	@Override
	public void deleteUserAddress(long uuid, long auid) {
	      try {
		  	  Connection testConn = JDBCConnector.getConn();
		  	  PreparedStatement st = testConn.prepareStatement("DELETE FROM USER_ADDRESS WHERE USERUID = ? AND BANKUID = ?");
		  	  st.setLong(1, uuid);
		  	  st.setLong(2, auid);
	  	      st.execute();
		  	    log.trace("Record successfully deleted from User_Address table in database");
			  } catch (SQLException e){
				 	log.warn("Error while removing from User_Address table in database", e);
			  }      
	}

	@Override
	public TreeSet<Address> readAllAddresses() {
		  TreeSet<Address> returnThis = new TreeSet<Address>();
		  
	      try {
		    Connection testConn = JDBCConnector.getConn();
		    PreparedStatement st = testConn.prepareStatement("SELECT * FROM ADDRESS");
		    ResultSet rs = st.executeQuery();
		    
	    	Address neoAddress;
	    	long uid;
	    	String nS1, nS2, nCity, nState;
	    	long nZip;

	    	while (rs.next()) {
		    	uid = rs.getLong("BANKUID");
		    	nS1 = rs.getString("STREET1");
		    	nS2 = rs.getString("STREET2");
		    	nCity = rs.getString("CITY");
		    	nState = rs.getString("STATE");
		    	nZip = rs.getLong("ZIP");
		    	
		    	neoAddress = new Address(uid, nS1, nS2, nCity, nState, nZip);
		    	returnThis.add(neoAddress);
		    }
		  } catch (SQLException e){
		 	log.warn("Error while accessing Address table in database", e);
	  	  }
	      
	      log.trace(returnThis.size() + " records returned from Address table.");
		  return returnThis;
	}

	@Override
	public TreeSet<Address> readAllByUser(User u) {
		return readAllByUserUID(u.getBankID());
	}

	@Override
	public TreeSet<Address> readAllByUserUID(Long uid) {
		  TreeSet<Address> returnThis = new TreeSet<Address>();
		  
	      try {
		    Connection testConn = JDBCConnector.getConn();
		    PreparedStatement st = testConn.prepareStatement("SELECT * FROM USER_ADDRESS ua, ADDRESS a WHERE ua.ADDRUID = a.BANKUID AND ua.USERUID = ? ");
		    st.setLong(1, uid);
		    ResultSet rs = st.executeQuery();
		    
	    	Address neoAddress;
	    	long buid;
	    	String nS1, nS2, nCity, nState;
	    	long nZip;

	    	while (rs.next()) {
		    	buid = rs.getLong("BANKUID");
		    	nS1 = rs.getString("STREET1");
		    	nS2 = rs.getString("STREET2");
		    	nCity = rs.getString("CITY");
		    	nState = rs.getString("STATE");
		    	nZip = rs.getLong("ZIP");
		    	
		    	neoAddress = new Address(buid, nS1, nS2, nCity, nState, nZip);
		    	returnThis.add(neoAddress);
		    }
		  } catch (SQLException e){
		 	log.warn("Error while accessing User_Address table in database", e);
	  	  }
	      
	      log.trace(returnThis.size() + " records returned from User_Address table.");
		  return returnThis;
	}

	@Override
	public Address readAddress(Address a) {
		return readAddressByUID(a.getBankUID());
	}

	@Override
	public Address readAddressByUID(long uid) {
		  Address returnThis = null;
		  
	      try {
		    Connection testConn = JDBCConnector.getConn();
		    PreparedStatement st = testConn.prepareStatement("SELECT * FROM ADDRESS WHERE BANKUID = ?");
		    st.setLong(1, uid);
		    ResultSet rs = st.executeQuery();
		    
	    	long auid;
	    	String nS1, nS2, nCity, nState;
	    	long nZip;

	    	if (rs.next()) {
		    	auid = rs.getLong("BANKUID");
		    	nS1 = rs.getString("STREET1");
		    	nS2 = rs.getString("STREET2");
		    	nCity = rs.getString("CITY");
		    	nState = rs.getString("STATE");
		    	nZip = rs.getLong("ZIP");
		    	
			    log.trace( "Single record returned from Address table.");
		    	returnThis = new Address(auid, nS1, nS2, nCity, nState, nZip);
		    } else {
		    	log.info("Attempt to retreive record from Address table failed");
		    }
		  } catch (SQLException e){
		 	log.warn("Error while accessing Address table in database", e);
	  	  }
	      
		  return returnThis;
	}

	@Override
	public void updateAddress(Address a) {
	      try {
		  	    Connection testConn = JDBCConnector.getConn();
		  	    PreparedStatement st = testConn.prepareStatement("UPDATE ADDRESS SET STREET1 = ?, STREET2 = ?, CITY = ?, STATE = ?, ZIP = ? WHERE BANKUID = ?");
		  	    st.setString(1, a.getStreet1());
		  	    st.setString(2, a.getStreet2());
		  	    st.setString(3, a.getCity());
		  	    st.setString(4, a.getState());
		  	    st.setLong(5, a.getZip());
		  	    st.setLong(6, a.getBankUID());
		  	    st.execute();
		  	    log.trace("Record successfully updated in Address table in database");
			  } catch (SQLException e){
				 	log.warn("Error while updating Address table in database", e);
			  }      
	}

}
