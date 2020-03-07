package com.revature.dao.interfaces;

import java.util.TreeSet;

import com.revature.model.User;

public interface UserDAOInterface {
	public void createUser(User u);
	public void deleteUser(User u);
	public void deleteUserByUID(long uid);
	public boolean exist(User u);
	public boolean existByUID(long uid);
	public boolean existByName(String name);
	public TreeSet<User> readAllUsers();
	public User readUser(User u);
	public User readUserByUID(long uid);
	public User readUserByUsername(String s);
	public void updateUser(User u);
}
