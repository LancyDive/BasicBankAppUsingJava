package com.bank.service;

import com.bank.model.UserAccount;

public interface InternetBanking {
	public void checkBlance(UserAccount account);
	
	public boolean deposit(UserAccount account, double amount);
	
	public boolean withdraw(UserAccount account, double amount);
	
	public boolean transfer(UserAccount fromAccount, UserAccount toAccount, double amount,int otp);
	
	public boolean validateLogin(String accountNo, String password, UserAccount account);
	
	public int generateOTP();
	
}
