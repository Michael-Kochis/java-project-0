package com.revature.model.interfaces;

import com.revature.model.Account;
import com.revature.model.User;

public interface Accountable {
	public boolean depositAuthUser(User u);
	public boolean depositAuthUID(long uid);
	public boolean withdrawAuthUser(User u);
	public boolean withdrawAuthUID(long uid);
	public boolean transferAuthUser(User u, Account a);
	public boolean transferAuthUID(long uUid, long aUid);
	public boolean viewAuthUser(User u);
	public boolean viewAuthUID(long uid);
}
