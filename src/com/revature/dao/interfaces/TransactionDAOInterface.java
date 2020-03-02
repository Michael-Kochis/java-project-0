package com.revature.dao.interfaces;

import java.util.TreeSet;

import com.revature.model.Transaction;
import com.revature.model.User;

public interface TransactionDAOInterface {
	public void createTransaction(Transaction t);
	public void deleteTransaction(Transaction t);
	public TreeSet<Transaction> readAllTransactions();
	public Transaction readTransaction(Transaction t);
	public Transaction readTransactionByAccountUID(long uid);
	public Transaction readTransactionByUID(long uid);
	public TreeSet<Transaction> readTransactionByUserUID(long uid);
	public void updateTransaction(Transaction t);
}
