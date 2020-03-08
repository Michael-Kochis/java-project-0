package com.revature.service;

import org.apache.log4j.Logger;

import com.revature.dao.UserDAO;
import com.revature.model.User;

public class UserService {
	private static Logger log = Logger.getLogger(UserService.class);
	private static UserDAO ud;
	
	public UserService() {
		super();
		ud = new UserDAO();
	}
	
	public UserService(UserDAO nd) {
		super();
		ud = nd;
	}
	
	public void addUser(User u) {
		ud.createUser(u);
	}
	
	public boolean exist(User u) {
		return ud.exist(u);
	}
	
	public boolean existByName(String name) {
		return ud.existByName(name);
	}
	
	public static long getMax() {
		if (ud == null)
			ud = new UserDAO();
		return ud.getMax();
	}
	
	public static User readByUsername(String s) {
		return ud.readUserByUsername(s);
	}

	public void registerUser(User u) {
		if (ud.exist(u)) {
			log.info("Attept to insert existing user into database: " + u.toString());
		} else {
			addUser(u);
		}
	}
	
	public void removeUser(User u) {
		ud.deleteUser(u);
	}

}
