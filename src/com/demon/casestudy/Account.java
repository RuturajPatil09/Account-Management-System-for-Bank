package com.demon.casestudy;

// The work on this class is done by Ruturaj Patil

public abstract class Account
{
	int accountNumber;
	String password;
	String accountHolderName;
	double balance;
	
	public Account() {
		// TODO Auto-generated constructor stub
	}

	

	public Account(int accountNumber, String password, String accountHolderName, double balance) {
		super();
		this.accountNumber = accountNumber;
		this.password = password;
		this.accountHolderName = accountHolderName;
		this.balance = balance;
	}



	public int getAccountNumber() {
		return accountNumber;
	}

	public void setAccountNumber(int accountNumber) {
		this.accountNumber = accountNumber;
	}

	public String getAccountHolderName() {
		return accountHolderName;
	}

	public void setAccountHolderName(String accountHolderName) {
		this.accountHolderName = accountHolderName;
	}

	public double getBalance() {
		return balance;
	}

	public void setBalance(double balance) {
		this.balance = balance;
	}
	 
	
	public boolean deposit(double amount)
	{
		this.balance = this.balance + amount;
		return true;
	}
	
	public boolean withdraw(double amount)
	{
		this.balance -= amount;
		return true;
	}
	
	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public abstract double calculateIntrest();
	
	public void display()
	{
		System.out.println(" "+	this.accountNumber + "             "+this.accountHolderName + "        "+this.balance);
	}
	
}
