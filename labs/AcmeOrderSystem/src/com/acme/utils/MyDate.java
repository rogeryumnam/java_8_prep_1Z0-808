package com.acme.utils;

public class MyDate {

	private byte month;
	private byte day;
	private short year;
	
	private static MyDate[] holidays;
	
	static {
		holidays = new MyDate[6];
		holidays[0] = new MyDate(1,1,2016); // New Year’s Date (January 1)
		holidays[1] = new MyDate(9,5,2016); //Labor Day (Sept 5)
		holidays[2] = new MyDate(5,30,2016); //Memorial Day (May 30)
		holidays[3] = new MyDate(11,24,2016); //Thanksgiving (November 24)
		holidays[4] = new MyDate(7,4,2016); //Independence Day (July 4)
		holidays[5] = new MyDate(12,25,2016); //Christmas (December 25)
	}
	
	{
		month = 1;
		day = 1;
		year = 2000;
	}
	public MyDate(){
		this(1,1,1900);
	}
	
	public MyDate(int m, int d, int y){
		setDate(m,d,y);
	}
	
	public static MyDate[] getHolidays(){
		return holidays;
	}
	
	public static void listHolidays() {
		System.out.println("the holidays are:");
		for(MyDate d : holidays){
			System.out.println(d);
		}
	}
	
	public void setDate(int m, int d, int y){
		try{
			valid(d, m, y);
		} catch (InvalidDateException e){
			System.out.println(e.getMessage());
			System.exit(0);
		}
		month = (byte) m;
		day = (byte) d;
		year = (short) y;
	}
	
	public static void leapYears() {
		for (int i = 1752; i <= 2020; i = i + 4) {
			if ((i % 100 != 0) || (i % 400 == 0))
				System.out.println("The year " + i + " is a leap year");
		}
	}
	
	private void valid(int day, int month, int year) throws InvalidDateException{
		boolean valid = true;
		if (day > 31 || day < 1 || month > 12 || month < 1 ){
			valid = false;
		}

		switch (month){
			case 4:
			case 6:
			case 9:
			case 11: if(day <= 30){valid=true;};
			case 2: if(day <= 28 || ( day == 29 && year % 4 == 0)){valid=true;} ;
		}
		if(!valid) throw new InvalidDateException(day, month, year);
	}
	
	public boolean equals(Object o) {
		if (o instanceof MyDate) {
			MyDate d = (MyDate) o;
			if ((d.day == day) && (d.month == month) && (d.year == year)) {
				return true;
			}
		}
		return false;
	}
	
	public String toString(){
		return month + "/" + day + "/" + year;
	}

	public int getMonth() {
		return month;
	}

	public void setMonth(int month) {
		try{
			valid(day, month, year);
		} catch (InvalidDateException e){
			System.out.println(e.getMessage());
			System.exit(0);
		}
		this.month = (byte) month;
	}

	public int getDay() {
		return day;
	}

	public void setDay(int day) {
		try{
			valid(day, month, year);
		} catch (InvalidDateException e){
			System.out.println(e.getMessage());
			System.exit(0);
		}
		this.day = (byte) day;
	}

	public int getYear() {
		return year;
	}

	public void setYear(int year) {
		try{
			valid(day, month, year);
		} catch (InvalidDateException e){
			System.out.println(e.getMessage());
			System.exit(0);
		}
		this.year = (short) year;
	}
}
