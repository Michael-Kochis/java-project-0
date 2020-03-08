package com.revature.service;

import java.util.TreeSet;

import com.revature.dao.PermissionsDAO;
import com.revature.enums.PermissionType;
import com.revature.model.Permission;

public class PermissionService {
	private static PermissionsDAO pd = new PermissionsDAO();
	
	public static TreeSet<Permission> readPermissionsByUID(long uid) {
		return pd.readPermissionsByOwnerUID(uid);
	}

	public static void createPermission(long uid, PermissionType p) {
		Permission pm = new Permission(p);
		pd.createUserPermission(uid, pm);	
	}
	
	public static void removeAllPermissionsByUserUID(long uid) {
		pd.deleteAllPermissionsByUserUID(uid);
	}
}
