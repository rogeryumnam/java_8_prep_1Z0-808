package com.acme.utils;

public class HolidayOrdersNotAllowedException extends Exception {

	public HolidayOrdersNotAllowedException(MyDate date){
		super("Orders are not allowed to be created on: " + date);
	}
}
