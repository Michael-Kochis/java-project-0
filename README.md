# Project 0: Banking App

### Requirements

**Description**
Leveraging Java 8, create an application that simulates simple banking transactions.
Maven is required to manage dependencies required by this project.

**Required Environment Variables**
- JavaBank_URL: the JDBC connection string used to connect to the database.
- JavaBank_Login: the user name to connect to the database with
- JavaBank_Password: the password to use for the login (above)

## Agile Requirements
- [ ] Develop using the agile methodologies taught in class
- - [ ] You should be using TDD (see JUnit4 requirements)
- - [ ] All transactions should be logged (see Log4J requirements)

## Java Requirements
- [x]	Build the application using Java 8
- [ ]	All interaction with the user should be done through the console using the `Scanner` class
- [ ]   All objects modeled will include the hashCode, equals, and toString methods.

## User Accounts
- [ ]	Customers of the bank should be able to register with a username and password, and apply to open an account.
- - [ ] Customers should be able to apply for joint accounts
- [ ] Mandatory User Information
- - [ ] Personal information

## Bank Account Specification
- [ ]	Once the account is open, customers should be able to withdraw, deposit, and transfer funds between accounts
- - [ ] All basic validation should be done, such as trying to input negative amounts, overdrawing from accounts etc.
- [ ] Mandatory Account information
- - [ ] Account information
- - [ ] Account balances

## Bank Customer Functions
- [ ] View and edit their personal information
- [ ] View account information and balances, but not directly edit
- [ ] Customer Banking Operations
- - [ ]  Deposit
- - [ ]  Withdraw
- - [ ]  Transfer


## Bank Employee Functions
- [ ]	Employees of the bank should be able to view all of their customers information.
- - [ ] May not edit customer information or account balances
- [ ]	Employees should be able to approve/deny open applications for accounts

## Bank Admin Functions
- [ ]	Bank admins should be able to view and edit all accounts
- - [ ] Approving/denying accounts (see Employee)
- - [ ] withdrawing, depositing, transferring from all accounts
- - [ ] canceling accounts

## JUnit4
- [ ]	100% test coverage for the service layer is expected using JUnit4

## Log4J
- [ ]	Logging should be accomplished using Log4J
- - [ ] Logging of transactions will also be stored in JDBC/SQL (requirement SQL 1)

## SQL Requirements
- [ ] All information will be stored through JDBC/SQL
- [ ] Create a SQL script that will create:
- - [ ] table schema for storing all user and account information
- - [ ] method for creating a new user in the database
- [ ] Your database should include at least 1 stored procedure.
- - [ ] Procedure to make sure both halves of a transfer happen, or none.
- [ ] You should use the DAO design pattern for data connectivity.

## Dependency List
* Java Runtime Environment, version 1.8.0 (release 241)
* JUnit4 version 4.13
* Log4J version 1.2.17
* OJDBC8 version 19.3.0.0
* Oracle 12c version 19  (Currently hosted on AWS)
* Spring-Security-Core version 5.2.2
