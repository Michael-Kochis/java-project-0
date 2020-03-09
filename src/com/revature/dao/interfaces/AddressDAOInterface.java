package com.revature.dao.interfaces;

import java.util.TreeSet;

import com.revature.model.Address;
import com.revature.model.User;

public interface AddressDAOInterface {
	public void createAddress(Address a);
	public void createUserAddress(long ownerID, long addrID);
	public void deleteAddress(Address a);
	public void deleteAddressByUID(long uid);
	public void deleteUserAddress(long uuid, long auid);
	public TreeSet<Address> readAllAddresses();
	public TreeSet<Address> readAllByUser(User u);
	public TreeSet<Address> readAllByUserUID(Long uid);
	public Address readAddress(Address a);
	public Address readAddressByUID(long uid);
	public void updateAddress(Address a);

}
