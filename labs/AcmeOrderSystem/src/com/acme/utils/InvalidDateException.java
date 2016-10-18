package com.acme.utils;

public class InvalidDateException extends Exception {

	public InvalidDateException(int day, int month, int year){
		super("Month " + month + " Day " + day + " and year " + year + " doesn't create a valid date");
	}
}
