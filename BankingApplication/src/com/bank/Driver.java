package com.bank;

import com.bank.model.UserAccount;
import com.bank.service.InternetBanking;
import com.bank.service.InternetBankingService;
import java.util.*;

public class Driver {

	public static void main(String[] args) {
		
		UserAccount userAccount1 = new UserAccount("777556534","password",5000.00);
		UserAccount userAccount2 = new UserAccount("666645673","password",7000.00);
		
		InternetBanking service = new InternetBankingService();
		
		Scanner sc = new Scanner(System.in);
		
		System.out.println("welcome to internet banking ....");
		
		System.out.println("Please enter the account no");
		String accountNo = sc.nextLine();
		
		System.out.println("Please enter the password");
		String password = sc.nextLine();
		
		if (service.validateLogin(accountNo, password, userAccount1)) {
			System.out.println("login sucessfull....");
			
			
			int option;
			do {
				System.out.println("------------------------------------------------");
				System.out.println("1. Check Balance");
				System.out.println("2. Deposit");
				System.out.println("3. Withdraw");
				System.out.println("4. Transfer");
				System.out.println("0. Logout");
				
				System.out.println("enter the option");
				 option = sc.nextInt() ;
				
				switch(option) {
				case 0:
					option = 0;
					break;
					
				case 1:
					option =1;
					service.checkBlance(userAccount1);
					break;
					
				case 2:
					System.out.println("Enter the amount to be deposited");
					double amount = sc.nextDouble();
					option=2;
					service.deposit(userAccount1, amount);
					break;
				case 3:
					System.out.println("Enter the amount to withdraw");
					double withdrawAmount = sc.nextDouble();
					service.withdraw(userAccount1, withdrawAmount);
					break;
				case 4:
					System.out.println("Generating otp");
					int otp = service.generateOTP();
					System.out.println("otp generated is "+ otp);
					userAccount1.setOtp(otp);
				
					System.out.println("enter the amount to be transfered");
					double transferAmount = sc.nextDouble();
					service.transfer(userAccount1, userAccount2, transferAmount, otp);
					break;
					
				default :
					System.out.println("select valid option");
					break;
				}
				
			}while(option !=0);
		}else {
			System.out.println("Invalid credentials");
		}
	}

}
