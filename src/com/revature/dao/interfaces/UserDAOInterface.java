package com.revature.dao.interfaces;

import java.util.TreeSet;

import com.revature.model.User;

public interface UserDAOInterface {
	public void createUser(User u);
	public void deleteUser(User u);
	public TreeSet<User> readAllUsers();
	public User readUser(User u);
	public User readUserByUID(long uid);
	public User readUserByUsername(String s);
	public void updateUser(User u);
}
