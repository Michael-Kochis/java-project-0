package com.revature.service;

import java.util.TreeSet;

import com.revature.dao.PermissionsDAO;
import com.revature.model.Permission;

public class PermissionService {
	private static PermissionsDAO pd = new PermissionsDAO();
	
	public static TreeSet<Permission> readPermissionsByUID(long uid) {
		return pd.readPermissionsByOwnerUID(uid);
	}
}
