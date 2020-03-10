package com.revature.service;

import java.util.TreeSet;

import com.revature.dao.AddressDAO;
import com.revature.model.Address;

public class AddressService {
	private static AddressDAO ad = new AddressDAO();
	
	public AddressService() {
		super();
	}

	public AddressService(AddressDAO nad) {
		this();
		ad = nad;
	}

	public static TreeSet<Address> readAll() {
		return ad.readAllAddresses();
	}

	public static Address readByUID(long uid) {
		return ad.readAddressByUID(uid);
	}

	public static TreeSet<Address> readAllByUserUID(long uid) {
		return ad.readAllByUserUID(uid);
	}

	public static void create(Address addr) {
		ad.createAddress(addr);
	}

	public static void createUserAddress(long ownerID, long addrID) {
		ad.createUserAddress(ownerID, addrID);
	}

	public static void update(Address addr) {
		ad.updateAddress(addr);
	}

}
