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
- [x] Develop using the agile methodologies taught in class
- - [ ] You should be using TDD (see JUnit4 requirements)
- - [x] All transactions should be logged (see Log4J requirements)

## Java Requirements
- [x]	Build the application using Java 8
- [x]	All interaction with the user should be done through the console using the `Scanner` class
- [x]   All objects modeled will include the hashCode, equals, and toString methods.

## User Accounts
- [x]	Customers of the bank should be able to register with a username and password, and apply to open an account.
- - [x] Customers should be able to apply for joint accounts
- [ ] Mandatory User Information
- - [ ] Personal information

## Bank Account Specification
- [x]	Once the account is open, customers should be able to withdraw, deposit, and transfer funds between accounts
- - [x] All basic validation should be done, such as trying to input negative amounts, overdrawing from accounts etc.
- [x] Mandatory Account information
- - [x] Account information
- - [x] Account balances

## Bank Customer Functions
- [ ] View and edit their personal information
- [x] View account information and balances, but not directly edit
- [x] Customer Banking Operations
- - [x]  Deposit
- - [x]  Withdraw
- - [x]  Transfer


## Bank Employee Functions
- [x]	Employees of the bank should be able to view all of their customers information.
- - [x] May not edit customer information or account balances
- [x]	Employees should be able to approve/deny open applications for accounts

## Bank Admin Functions
- [x]	Bank admins should be able to view and edit all accounts
- - [x] Approving/denying accounts (see Employee)
- - [x] withdrawing, depositing, transferring from all accounts
- - [x] canceling accounts

## JUnit4
- [x]	100% test coverage for the service layer is expected using JUnit4

## Log4J
- [x]	Logging should be accomplished using Log4J
- - [x] Logging of transactions will also be stored in JDBC/SQL (requirement SQL 1)

## SQL Requirements
- [x] All information will be stored through JDBC/SQL
- [x] Create a SQL script that will create:
- - [x] table schema for storing all user and account information
- - [x] method for creating a new user in the database
- [x] Your database should include at least 1 stored procedure.
- - [x] Procedure to make sure both halves of a transfer happen, or none.
- [x] You should use the DAO design pattern for data connectivity.
- [ ] (Optional) Have a full ERD showing the relationships and cardinality of your data tables.

## Dependency List
* Java Runtime Environment, version 1.8.0 (release 241)
* JUnit4 version 4.13
* Log4J version 1.2.17
* OJDBC8 version 19.3.0.0
* Oracle 12c version 19  (Currently hosted on AWS)
* Spring-Security-Core version 5.2.2
