package com.revature.model;

import com.revature.enums.PermissionType;

public class Permission implements Comparable {
	private PermissionType permission;
	
	public Permission() {
		super();
	}
	
	public Permission(PermissionType p) {
		this();
		this.setPermission(p);
	}

	public PermissionType getPermission() {
		return permission;
	}

	public void setPermission(PermissionType permission) {
		this.permission = permission;
	}

	@Override
	public int compareTo(Object o) {
		Permission p = (Permission) o;
		return PermissionType.typeToInt(this.permission)-PermissionType.typeToInt(p.permission);
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((permission == null) ? 0 : permission.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Permission other = (Permission) obj;
		if (permission == null) {
			if (other.permission != null)
				return false;
		} else if (!this.permission.equals(other.permission)) {
			return false;
		}
		return true;
	}

	@Override
	public String toString() {
		return "Permission [permission=" + permission + "]";
	}

}
