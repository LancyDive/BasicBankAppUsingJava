package com.bank.service;

public class OTPGenerator {
	public int generateOTP() {
		return (int)(Math.random()*9000)+1000;
	}
}
