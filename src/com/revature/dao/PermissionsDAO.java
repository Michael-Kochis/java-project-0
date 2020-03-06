package com.revature.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.TreeSet;

import org.apache.log4j.Logger;

import com.revature.dao.interfaces.PermissionsDAOInterface;
import com.revature.enums.AccountType;
import com.revature.enums.PermissionType;
import com.revature.model.Account;
import com.revature.model.Permission;

public class PermissionsDAO implements PermissionsDAOInterface {
	private static Logger log = Logger.getLogger(AccountDAO.class);

	@Override
	public void createPermission(Permission p) {
	      try {
		  	    Connection testConn = JDBCConnector.getConn();
		  	    PreparedStatement st = testConn.prepareStatement("INSERT INTO PERMISSION VALUES (?)");
		  	    st.setInt(1, PermissionType.typeToInt(p.getPermission()));
		  	    st.execute();
		  	    log.trace("Single record successfully inserted into Permission table.");
			  } catch (SQLException e){
				log.warn("Error while inserting into Permission table in database", e);
			  }
	}
	
	@Override
	public void createUserPermission(long uid, Permission p) {
	      try {
		  	    Connection testConn = JDBCConnector.getConn();
		  	    PreparedStatement st = testConn.prepareStatement("INSERT INTO USER_PERMISSION VALUES (?, ?)");
		  	    st.setLong(1, uid);
		  	    st.setInt(2, PermissionType.typeToInt(p.getPermission()));
	  	        st.execute();
		  	    log.trace("Single record successfully inserted into User_Permission table.");
			  } catch (SQLException e){
				log.warn("Error while inserting into User_Permission table in database", e);
			  }
	}

	@Override
	public void deletePermission(Permission p) {
	      try {
		  	    Connection testConn = JDBCConnector.getConn();
		  	    PreparedStatement st = testConn.prepareStatement("DELETE FROM PERMISSION WHERE PERMISSION = ?");
		  	    st.setLong(1, PermissionType.typeToInt(p.getPermission()));
		  	    st.execute();
		  	    log.trace("Record successfully deleted from Permission table in database");
			  } catch (SQLException e){
				 	log.warn("Error while removing from Permission table in database", e);
			  }      
	}

	@Override
	public TreeSet<Permission> readAllPermissions() {
		  TreeSet<Permission> returnThis = new TreeSet<Permission>();
		  
	      try {
		    Connection testConn = JDBCConnector.getConn();
		    PreparedStatement st = testConn.prepareStatement("SELECT * FROM PERMISSION");
		    ResultSet rs = st.executeQuery();
		    
	    	Permission neoPermission;
	    	int in;

	    	while (rs.next()) {
		    	in = rs.getInt("Permission");
		    	
		    	neoPermission = new Permission(PermissionType.intToType(in));
		    	returnThis.add(neoPermission);
		    }
		  } catch (SQLException e){
		 	log.warn("Error while accessing Permission table in database", e);
	  	  }
	      
	      log.trace(returnThis.size() + " records returned from Permission table.");
		  return returnThis;
	}

	@Override
	public Permission readPermissionByType(PermissionType pt) {
		  Permission returnThis = null;
		  
	      try {
		    Connection testConn = JDBCConnector.getConn();
		    PreparedStatement st = testConn.prepareStatement("SELECT * FROM PERMISSION WHERE PERMISSION = ?");
		    st.setInt(1, PermissionType.typeToInt(pt));
		    ResultSet rs = st.executeQuery();
		    
	    	int in;

	    	if (rs.next()) {
		    	in = rs.getInt("Permission");
		    	
		    	returnThis = new Permission(PermissionType.intToType(in));
		    	log.trace("Single record returned from Permission table.");
		    }
		  } catch (SQLException e){
		 	log.warn("Error while accessing Permission table in database", e);
	  	  }
	      
	      return returnThis;
	}

	@Override
	public TreeSet<Permission> readPermissionsByOwnerUID(long uid) {
		  TreeSet<Permission> returnThis = new TreeSet<Permission>();
		  
	      try {
		    Connection testConn = JDBCConnector.getConn();
		    PreparedStatement st = testConn.prepareStatement("SELECT * FROM USER_PERMISSION WHERE BANKUID = ?");
		    st.setLong(1, uid);
		    ResultSet rs = st.executeQuery();
		    
	    	Permission neoPermission;
	    	int in;

	    	while (rs.next()) {
		    	in = rs.getInt("Permission");
		    	
		    	neoPermission = new Permission(PermissionType.intToType(in));
		    	returnThis.add(neoPermission);
		    }
		  } catch (SQLException e){
		 	log.warn("Error while accessing Permission table in database", e);
	  	  }
	      
	      log.trace(returnThis.size() + " records returned from Permission table.");
		  return returnThis;
	}

	@Override
	public void updatePermission(Permission p) {
		createPermission(p);
	}

}
