package com.acme.domain;

import com.acme.utils.MyDate;

public interface Rushable {
	public abstract boolean isRushable(MyDate orderDate, double amount);
}
