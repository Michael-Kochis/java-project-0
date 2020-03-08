package com.revature.test.service;

import com.revature.dao.TransactionDAO;
import com.revature.model.Transaction;

public class TransactionService {
	private static TransactionDAO td = new TransactionDAO();

	public static void create(Transaction t) {
		td.createTransaction(t);
	}

}
