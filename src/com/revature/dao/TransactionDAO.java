package com.revature.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.TreeSet;

import org.apache.log4j.Logger;

import com.revature.dao.interfaces.TransactionDAOInterface;
import com.revature.enums.PermissionType;
import com.revature.model.Transaction;

public class TransactionDAO implements TransactionDAOInterface {
	private static Logger log = Logger.getLogger(TransactionDAO.class);

	@Override
	public void createTransaction(Transaction t) {
	    try {
		  Connection testConn = JDBCConnector.getConn();
		  PreparedStatement st = testConn.prepareStatement("INSERT INTO BANKTRANS (TRANSUID, USERUID, ACCOUNTUID, TRANSTYPE, AMOUNT) VALUES (?, ?, ?, ?, ?)");
		  st.setLong(1, t.getTransactionUID());
		  st.setLong(2, t.getUserUID());
		  st.setLong(3, t.getAccountUID());
		  st.setLong(4, t.getTransType());
		  st.setDouble(5, t.getAmount());
		  st.execute();
		  log.trace("Single record successfully inserted into BankTrans table.");
		} catch (SQLException e){
		 log.warn("Error while inserting into BankTrans table in database", e);
		}
	}

	@Override
	public void deleteTransaction(Transaction t) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public TreeSet<Transaction> readAllTransactions() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Transaction readTransaction(Transaction t) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Transaction readTransactionByAccountUID(long uid) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Transaction readTransactionByUID(long uid) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public TreeSet<Transaction> readTransactionByUserUID(long uid) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void updateTransaction(Transaction t) {
		// TODO Auto-generated method stub
		
	}

}
