package com.demon.casestudy;

//The work on this class is done by Shrikant Shahapure

public class SavingsAccount extends Account
{
	static double minimumBalance;
	static float roi;
	
	
	
	public static double getMinimumBalance() {
		return minimumBalance;
	}



	public static void setMinimumBalance(double minimumBalance) {
		SavingsAccount.minimumBalance = minimumBalance;
	}



	public static float getRoi() {
		return roi;
	}



	public static void setRoi(float roi) {
		SavingsAccount.roi = roi;
	}

	static
	{
		minimumBalance = 10000;
		roi = 6;
	}
	
	public SavingsAccount() {
		// TODO Auto-generated constructor stub
	}
	
	
	
	public SavingsAccount(int accountNumber,String pass, String accountHolderName, double balance) {
		super(accountNumber,pass, accountHolderName, balance);
		// TODO Auto-generated constructor stub
	}



	public boolean withdraw(double amount)
	{
		if(this.balance - amount >= minimumBalance)
		{
			this.balance = this.balance - amount;
			return true;
		}
		else
		{
			return false;
		}
	}
	
	public double calculateIntrest()
	{
		double intrest = this.balance * (roi/100);
		System.out.println("THE INTREST YOU WILL GET ON YOUR CURRENT BALANCE IS : " + intrest);
		return intrest;
	}
	
}
