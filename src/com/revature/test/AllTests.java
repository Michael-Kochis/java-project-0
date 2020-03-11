package com.revature.test;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

import com.revature.test.controller.AccountStatusTest;
import com.revature.test.controller.PerformTransactionTest;
import com.revature.test.controller.UserLoginTest;
import com.revature.test.controller.UserRegistrationTest;
import com.revature.test.dao.*;
import com.revature.test.model.*;
import com.revature.test.service.*;
import com.revature.test.view.*;

@RunWith(Suite.class)
@SuiteClasses({ AccountStatusTest.class, PerformTransactionTest.class, UserLoginTest.class,
		UserRegistrationTest.class, AccountDAOTest.class, PermissionsDAOTest.class,
		TransactionDAOTest.class, UserDAOTest.class, AccountTest.class, BankIDTest.class,
		CheckingAccountTest.class, PermissionsTest.class, PHashTest.class, SavingsAccountTest.class,
		TransactionTest.class, UserTest.class, AccountServiceTest.class, AddressServiceTest.class,
		PermissionServiceTest.class, TransactionService.class, UserServiceTest.class, ConsoleMainUITest.class,
		})
public class AllTests {

}
