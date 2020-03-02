package com.revature.dao.interfaces;

import java.util.TreeSet;

import com.revature.model.Permission;

public interface PermissionsDAOInterface {
	public void createPermission(Permission p);
	public void deletePermission(Permission p);
	public TreeSet<Permission> readAllPermissions();
	public Permission readPermission(Permission p);
	public Permission readPermissionByName(String s);
	public TreeSet<Permission> readAccountsbyOwnerUID(long uid);
	public void updatePermission(Permission p);
}
