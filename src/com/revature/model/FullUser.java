package com.revature.model;

import java.util.TreeSet;

import com.revature.service.PermissionService;

public class FullUser {
	public User user;
	public TreeSet<Permission> perms;
	
	public FullUser() {
		super();
	}
	
	public FullUser(User u) {
		super();
		init(u);
	}
	
	private void init(User u) {
		this.user = u;
		this.perms = PermissionService.readPermissionsByUID(this.user.getBankID());
		
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public TreeSet<Permission> getPerms() {
		return perms;
	}

	public void setPerms(TreeSet<Permission> perms) {
		this.perms = perms;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((perms == null) ? 0 : perms.hashCode());
		result = prime * result + ((user == null) ? 0 : user.hashCode());
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
		FullUser other = (FullUser) obj;
		if (perms == null) {
			if (other.perms != null)
				return false;
		} else if (!perms.equals(other.perms))
			return false;
		if (user == null) {
			if (other.user != null)
				return false;
		} else if (!user.equals(other.user))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "FullUser [user=" + user + ", perms=" + perms + "]";
	}
	
}
