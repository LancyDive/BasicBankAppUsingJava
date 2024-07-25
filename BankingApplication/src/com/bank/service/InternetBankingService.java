package com.bank.service;

import com.bank.model.UserAccount;

public class InternetBankingService implements InternetBanking{
	private static final double MIN_BALANCE = 1000;
	private static final double MAX_DEPOSIT_AMOUNt = 1000000;
	@Override
	public void checkBlance(UserAccount account) {
		// TODO Auto-generated method stub
		if (account.getBalance() < MIN_BALANCE) {
			System.out.println("Please maintain account minimum balance of "+ MIN_BALANCE);
		}
		System.out.println("Current account balance is:"+account.getBalance());
		
	}

	@Override
	public boolean deposit(UserAccount account, double amount) {
		// TODO Auto-generated method stub
		if(amount > 0 && amount <= MAX_DEPOSIT_AMOUNt) {
			double currentBalance = account.getBalance();
			double newBalance = currentBalance + amount;
			account.setBalance(newBalance);
			System.out.println("Amount deposited sucessfully ...");
			System.out.println("Current Account balance is "+ account.getBalance());
			return true;
		}
		return false;
	}

	@Override
	public boolean withdraw(UserAccount account, double amount) {
		// TODO Auto-generated method stub
		if (amount>0 && amount <= account.getBalance()) {
			double currentBalance = account.getBalance();
			double newBalance = currentBalance - amount;
			account.setBalance(newBalance);
			System.out.println("Withdraw Sucessful..");
			System.out.println("Current Balance amount is "+account.getBalance());
			return true;
		}else {
			System.out.println("Insufficiant Balance");
			return false;
		}
	}
	

	@Override
	public boolean transfer(UserAccount fromAccount, UserAccount toAccount, double amount, int otp) {
		// TODO Auto-generated method stub
		if(otp == fromAccount.getOtp()) {
			if(amount >0 && amount <=fromAccount.getBalance()) {
				System.out.println("OTP validaton sucessfull");
				double fromCurrentBalance = fromAccount.getBalance();
				double fromNewBalance = fromCurrentBalance - amount;
				fromAccount.setBalance(fromNewBalance);
				
				double toCurrentBalance = toAccount.getBalance();
				double toNewCurrentBalance = toCurrentBalance + amount;
				toAccount.setBalance(toNewCurrentBalance);
				
				System.out.println("amount transfer sucessful..");
				
				System.out.println("Updated from account balance is "+ fromAccount.getBalance());
				System.out.println("updated to account balance is "+ toAccount.getBalance());
				return true;
			}else {
				System.out.println("transfer failed due to insufficient Balance");
				return false;
			}
		}else {
			System.out.println("OTP validation failed");
			return false;
		}	
	}

	@Override
	public boolean validateLogin(String accountNo, String password, UserAccount account) {
		// TODO Auto-generated method stub
		if (accountNo.equals(account.getAccountNo()) && password.equals(account.getPassword())) {
			return true;
		}
		return false;	
	}

	@Override
	public int generateOTP() {
		// TODO Auto-generated method stub
		OTPGenerator generator = new OTPGenerator();
		return generator.generateOTP(); 
	}

	

}
