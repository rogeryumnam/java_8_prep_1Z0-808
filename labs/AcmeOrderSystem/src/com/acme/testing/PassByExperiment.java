package com.acme.testing;

import com.acme.utils.MyDate;

public class PassByExperiment {

	public static void passObject(MyDate d){
		d.setYear(2009);
	}
	
	public static void passPrimitive(int i){
		i=2010;
	}
	
	public static void passString(String s){
		int yearSlash =s.lastIndexOf('/');
		s = s.substring(0, yearSlash+1);
		s += "2012";
		System.out.println("New date string: " + s);
	}
	
	public static void passStringBuilder(StringBuilder s){
		int yearSlash = s.lastIndexOf("/");
		s.replace(yearSlash+1, s.length(), "2012");
		System.out.println("New date string: " + s);
	}
	
	public static void main(String [] args){
		MyDate date = new MyDate(1,20,2008);
		System.out.println("Before passing an object " + date);
		passObject(date);
		System.out.println("After passing an object " + date);
		
		System.out.println("Before passing a primitive " + date.getYear());
		passPrimitive(date.getYear());
		System.out.println("After passing a primitive " + date.getYear());
		
		String x = date.toString();
		System.out.println("Before passing a String " + x);
		passString(x);
		System.out.println("After passing a String " + x);
		
		StringBuilder xs = new StringBuilder(date.toString());
		System.out.println("Before passing a String " + xs);
		passStringBuilder(xs);
		System.out.println("After passing a String " + xs);
		
		/**
		 * Before passing an object 1/20/2008
		 * After passing an object __1/20/2009_____
		 * Before passing a primitive 2009
		 * After passing a primitive _____2009_______
		 * Before passing a String 1/20/2009
		 * New date string: 1/20/2012
		 * After passing a String ___1/20/2009____
		 **/
	}
}
