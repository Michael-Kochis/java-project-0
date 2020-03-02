package com.revature.model;

import java.sql.Time;
import java.util.Date;

public class Transaction {
	long transactionUID;
	long userUID;
	long accountUID;
	String transType; // TODO: make this an enum and switch the string values
	double amount;
	Date transDay;
	Time transTime;
}
