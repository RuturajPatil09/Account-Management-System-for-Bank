package com.demon.casestudy;
import java.util.InputMismatchException;
import java.util.Scanner;

//The work on this Main class is done by Ruturaj Patil
// Designing done by Ruturaj Patil

public class MainApp {

	public static void main(String[] args)
	{
		int accIndex=-1;
		int recordIndex=-1;
		int accNo=100;
		Account[] bankAccounts = new Account[20];
		String admin = "Admin",pass = "pass123";
		EndOfTheDayReport[] dailyReport = new EndOfTheDayReport[30];
		
		Scanner sc = new Scanner(System.in);
		
		int choice=-1;
		do
		{
			try
			{
				System.out.println("\n 1. LOGIN PAGE \n 2. CREATE ACCOUNT \n 0. EXIT \n  SELECT YOUR CHOICE :  ");
				choice = sc.nextInt();
				switch(choice)
				{
					case 1:
					{
						System.out.println("\n\t-----------------------------------------");
						System.out.println("\t 1. Admin                                |");
						System.out.println("\t 2. User                                 |");
						System.out.println("\t-----------------------------------------");
						System.out.println("\t Enter your choice : ");
						int choice4 = sc.nextInt();
						switch(choice4)
						{
							case 1:
							{
								System.out.println("\t Enter the admin name : ");
								sc.nextLine();
								String adm = sc.nextLine();
								System.out.println("\t Enter the password : ");
								String pas = sc.nextLine();
								
								if(adm.equals(admin) && pas.equals(pass))
								{
									System.out.println("\n\t--------------------------------------------------------------------");
									System.out.println("\t| 1. Show daily report                                                |");
									System.out.println("\t| 2. Add all intrests                                                 |");
									System.out.println("\t| 3. Display all users                                                |");
									System.out.println("\t-----------------------------------------------------------------------");
									System.out.println("\n\t Enter the choice : ");
									int choice5 = sc.nextInt();
									
									switch(choice5)
									{
										case 1:
										{
											System.out.println("\n\n\t FOLLOWING ARE THE ACCOUNTS PRESENT IN YOUR SYSTEM \n");
											System.out.println("\t ACCOUNT NO.    HOLDER NAME      AMOUNT      ACTIVITY     ");
											for(int count=0;count<=recordIndex;count++)
											{
												dailyReport[count].display();
											}
										}break;
										
										case 2:
										{
											for(int count=0;count<=accIndex;count++)
											{
												bankAccounts[count].balance +=  bankAccounts[count].calculateIntrest();
											}
										}break;
										
										case 3:
										{
											System.out.println("\n\n\t FOLLOWING ARE THE ACCOUNTS PRESENT IN YOUR SYSTEM \n");
											System.out.println(" ACCOUNT NUMBER      HOLDER NAME           BALANCE      ");
											for(int count=0;count<=accIndex;count++)
											{
												bankAccounts[count].display();
											}
										}break;
									}
									
								}
								else
								{
									System.out.println("\n--------------------- INVALID CREDENTIALS -------------------------");
								}
							}break;
							
							case 2:
							{
								System.out.println("\n Enter the Account Number : ");
								int accNumber = sc.nextInt();
								int found=-1;
								for(int ctr=0;ctr<=accIndex;ctr++)
								{
									if(accNumber == bankAccounts[ctr].accountNumber)
									{
										found = ctr;
										break;
									}
								}
								
								if(found == -1)
								{
									System.out.println("\n\t !!!!!!!!!!!!!!!!!! NO SUCH ACCOUNT EXISTS !!!!!!!!!!!!!!!!!!!\n\n");
								}
								else
								{
									System.out.println("\n Enter the password : ");
									sc.nextLine();
									String pas = sc.nextLine();
									if(pas.equals(bankAccounts[found].getPassword()))
									{
										int choice2=0;
										do
										{
											System.out.println("------------------------------------------------------------------------");
											System.out.println("                                             ___   ___      ");
											System.out.println("| 1. WITHDRAWAL                             |   | |   |  |\\   |  | /  |");
											System.out.println("| 2. DEPOSIT                                |___| |___|  | \\  |  |/   |");
											System.out.println("| 3. TRANSACTION                            |   | |   |  |  \\ |  |\\   |");
											System.out.println("| 4. SHOW INTREST AMOUNT ON BALANCE         |___| |   |  |   \\|  | \\  |");
											System.out.println("| 5. SHOW BALANCE                                                      |");
											System.out.println("| 0. LOGOUT                                                            |");
											System.out.println("------------------------------------------------------------------------");
											System.out.println(" Enter your choice : ");
											
											try
											{
												choice2 = sc.nextInt();
												switch(choice2)
												{
													case 1:
													{
														try
														{
															System.out.println("\n\n\t Enter the amount you want to withdraw : ");
															double amount = sc.nextDouble();
//															if(amount <= 0)
//															{
//																throw 0;
//															}
															if(bankAccounts[found].withdraw(amount))
															{
																dailyReport[++recordIndex] = new EndOfTheDayReport(bankAccounts[found].getAccountNumber(),bankAccounts[found].getAccountHolderName(),amount,"WITHDRAW");
																System.out.println("\n\t WITHDRAWAL SUCCESSFULL \n");
																System.out.println(" Your current balanceis : " + bankAccounts[found].getBalance());
															}
															else
															{
																System.out.println("\n\t WITHDRAWAL UNSUCCESSFULL \n");
															}
														}
														catch(InputMismatchException error)
														{
															System.out.println("\n\n\t !!!!!!!!!!!!!!!!!!!  NUMBERICAL AMOUNT EXPECTED  !!!!!!!!!!!!!!!!!!!\n\n");
														}
//														catch(Integer error)
//														{
//															System.out.println("\n\n\t !!!!!!!!!!!!!!!!! ENTER VALID WITHDRAWAL AMOUNT !!!!!!!!!!!!!!!!!!!!!!!\n\n");
//														}
													}break;
													
													case 2:
													{
														System.out.println("\n\n\t Enter the amount you want to deposit : ");
														int amount = sc.nextInt();
														if(bankAccounts[found].deposit(amount))
														{
															dailyReport[++recordIndex] = new EndOfTheDayReport(bankAccounts[found].getAccountNumber(),bankAccounts[found].getAccountHolderName(),amount,"DEPOSIT");
															System.out.println("\n\t DEPOSIT SUCCESSFULL \n");
															System.out.println(" Your current balanceis : " + bankAccounts[found].getBalance());
														}
														else
														{
															System.out.println("\n\t DEPOSIT UNSUCCESSFULL \n");
														}
													}break;
													
													case 3:
													{
														System.out.println("\n Enter the Account Number to which you want to transfer money : ");
														int accNum2 = sc.nextInt();
														int next=-1;
														for(int ctr=0;ctr<=accIndex;ctr++)
														{
															if(accNum2 == bankAccounts[ctr].accountNumber)
															{
																next = ctr;
																break;
															}
														}
														if(next==-1)
														{
															System.out.println("\n\t !!!!!!!!!!!!!!!!!! NO SUCH ACCOUNT EXISTS !!!!!!!!!!!!!!!!!!!\n\n");
														}
														else
														{
															System.out.println("\n\t Enter the amount you want to transfer : ");
															int amt = sc.nextInt();
															
															if(bankAccounts[found].withdraw(amt))
															{
																if(bankAccounts[next].deposit(amt))
																{
																	dailyReport[++recordIndex] = new EndOfTheDayReport(bankAccounts[found].getAccountNumber(),bankAccounts[found].getAccountHolderName(),amt,"WITHDRAW");
																	dailyReport[++recordIndex] = new EndOfTheDayReport(bankAccounts[next].getAccountNumber(),bankAccounts[next].getAccountHolderName(),amt,"DEPOSIT");
																	System.out.println("\n\t TRANSFER SUCCESSFULL \n");
																	System.out.println(" Your current balanceis : " + bankAccounts[found].getBalance());
																}
																else
																{
																	bankAccounts[found].deposit(amt);
																}
																
															}
															else
															{
																System.out.println("\n\t TRANSFER UNSUCCESSFULL \n");
															}
														}
														
													}break;
													
													case 4:
													{
														bankAccounts[found].calculateIntrest();
													}break;
													
													case 5:
													{
														System.out.println("\n\n\t FOLLOWING ARE THE ACCOUNTS PRESENT IN YOUR SYSTEM \n");
														System.out.println(" ACCOUNT NO.    HOLDER NAME      Balance     ");
														bankAccounts[found].display();
														System.out.println("\n\n");
													}break;
													
													case 0:
													{
														System.out.println("\n\n\t !!!!!!!!--------- LOOGING OUT ----------!!!!!!!\n\n");
													}break;
													
													default : System.out.println("\n INVALID CHOICE ");
													
												}
											}
											catch(InputMismatchException  error)
											{
												System.out.println("\n\n !!!!!!!!!!!!!!!!! NUMBER EXPECTED !!!!!!!!!!!!!!!!!!!!");
											}
										}while(choice2 != 0);
									}
									else
									{
										System.out.println("\n---------------- INVALID PASSWORD -----------------------");
									}
								}
							}
							
						}
						
					}break;
					
					case 2:
					{
						try
						{
							System.out.println("\t-----------------------------------------------");
							System.out.println("\t| 1. SAVINGS ACCOUNT                          |");
							System.out.println("\t| 2. CURRENT ACCOUNT                          |");
							System.out.println("\t| 3. SALARY ACCOUNT                           |");
							System.out.println("\t| 4. LOAN ACCOUNT                             |");
							System.out.println("\t-----------------------------------------------");

							System.out.println(" SELECT YOUR CHOICE : ");
							int choice1 = sc.nextInt();
							switch(choice1)
							{
								case 1:
								{
									if(accIndex<20)
									{
										System.out.println("\n Set the password for your account : ");
										sc.nextLine();
										String pas = sc.nextLine();
										System.out.println("\n Enter the Account Holder Name : ");
										String accName = sc.nextLine();
										System.out.println("\n Enter the Sarting balance : ");
										double bal = sc.nextDouble();
										if(bal > 10000)
										{
											bankAccounts[++accIndex] = new SavingsAccount(++accNo,pas,accName,bal);
											System.out.println(" YOUR ACCOUNT NUMBER IS : "+ bankAccounts[accIndex].getAccountNumber());

										}
										else
										{
											System.out.println("\n\t ALERT !!!-------- SRARTING BALANCE OF SAVINGS ACCOUNT CANNOT BE BELOW 10000 -------!!!");
										}
									}
									else
									{
										System.out.println("\n\n\t ALERT !!! NO MORE ACCOUNTS CAN BE CREATED NOW \n\n");
									}
								}break;
								
								case 2:
								{
									if(accIndex<20)
									{
										System.out.println("\n Set the password for your account : ");
										sc.nextLine();
										String pas = sc.nextLine();
										System.out.println("\n Enter the Account Holder Name : ");
										sc.nextLine();								String accName = sc.nextLine();
										System.out.println("\n Enter the Sarting balance : ");
										double bal = sc.nextDouble();
										if(bal >= 0)
										{
											bankAccounts[++accIndex] = new CurrentAccount(++accNo,pas,accName,bal);
											System.out.println(" YOUR ACCOUNT NUMBER IS : "+ bankAccounts[accIndex].getAccountNumber());
										}
										else
										{
											System.out.println("\n\n\t ALERT !!!-------- SRARTING BALANCE CANNOT BE NEGETIVE  -------!!!");
										}

									}
									else
									{
										System.out.println("\n\n\t ALERT !!! NO MORE ACCOUNTS CAN BE CREATED NOW \n\n");
									}
								}break;
								
								case 3:
								{
									if(accIndex<20)
									{
										System.out.println("\n Set the password for your account : ");
										sc.nextLine();
										String pas = sc.nextLine();
										System.out.println("\n Enter the Account Holder Name : ");
										String accName = sc.nextLine();
										System.out.println("\n Enter the Sarting balance : ");
										double bal = sc.nextDouble();
										if(bal > 10000)
										{
											bankAccounts[++accIndex] = new SalaryAccount(++accNo,pas,accName,bal);
											System.out.println(" YOUR ACCOUNT NUMBER IS : "+ bankAccounts[accIndex].getAccountNumber());
		}
										else
										{
											System.out.println("\n\n\t ALERT !!!-------- SRARTING BALANCE OF SAVINGS ACCOUNT CANNOT BE BELOW 10000 -------!!!");
										}
									}
									else
									{
										System.out.println("\n\n\t ALERT !!! NO MORE ACCOUNTS CAN BE CREATED NOW \n\n");
									}
								}break;
								
								case 4:
								{
									if(accIndex<20)
									{
										System.out.println("\n Set the password for your account : ");
										sc.nextLine();
										String pas = sc.nextLine();
										System.out.println("\n Enter the Account Holder Name : ");
										String accName = sc.nextLine();
										System.out.println("\n Enter the Loan amount you have taken : ");
										double loan = sc.nextDouble();
										bankAccounts[++accIndex] = new LoanAccount(++accNo,pas,accName,loan);
										System.out.println(" YOUR ACCOUNT NUMBER IS : "+ bankAccounts[accIndex].getAccountNumber());

									}
									else
									{
										System.out.println("\n\n\t ALERT NO MORE ACCOUNTS CAN BE CREATED NOW \n\n");
									}
								}break;
							}
						}
						catch(InputMismatchException error)
						{
							System.out.println(error + "\n\n INVALID INPUT \n\n");
						}
						
					}break;
					
					default : System.out.println("\n ALERT !!! INVALID CHOICE ");
					
				}
			}
			catch(InputMismatchException error)
			{
				sc.next();
				System.out.println("\n\t !!!!!!!!!!!!!!! INVALID INPUT !!!!!!!!!!!!!!!!!!!!\n\n");
			}
			catch(NullPointerException error)
			{
				sc.next();
				System.out.println("\n\t!!!!!!!!!!!!!!!!!!!!!!!!!!!!! NULL POINTER !!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!\n");
			}
			catch(Exception error)
			{
				sc.next();
				System.out.println("\n\t !!!!!!!!!!!!!!!! SOME PROBLEM OCCURED IN YOUR CODE PLEASE CHECK AGAIN !!!!!!!!!!!!!!!\n");
			}
			
		}while(choice!=0);
		sc.close();
		
		
		
		
	}

}
