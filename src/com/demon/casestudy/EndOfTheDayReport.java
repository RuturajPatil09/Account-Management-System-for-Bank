package com.demon.casestudy;

//The work on this class is done by Ruturaj Patil


public class EndOfTheDayReport
{
	int accountNumber;
	String accountHolderName;
	double amount;
	String transactionType;
	
	
	public EndOfTheDayReport() {
		// TODO Auto-generated constructor stub
	}


	public EndOfTheDayReport(int accountNumber, String accountHolderName, double amount, String transactionType) {
		super();
		this.accountNumber = accountNumber;
		this.accountHolderName = accountHolderName;
		this.amount = amount;
		this.transactionType = transactionType;
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


	public double getAmount() {
		return amount;
	}


	public void setAmount(double amount) {
		this.amount = amount;
	}


	public String getTransactionType() {
		return transactionType;
	}


	public void setTransactionType(String transactionType) {
		this.transactionType = transactionType;
	}
	
	public void display()
	{
		System.out.println("\t  "+this.accountNumber+"            "+this.accountHolderName+"         "+this.amount+"           "+this.transactionType);
	}

}
