package com.revature.dao.interfaces;

import java.util.TreeSet;

import com.revature.enums.PermissionType;
import com.revature.model.Permission;

public interface PermissionsDAOInterface {
	public void createPermission(Permission p);
	public void createUserPermission(long uid, Permission p);
	public void deletePermission(Permission p);
	public TreeSet<Permission> readAllPermissions();
	public Permission readPermissionByType(PermissionType pt);
	public TreeSet<Permission> readPermissionsByOwnerUID(long uid);
	public void updatePermission(Permission p);
}
