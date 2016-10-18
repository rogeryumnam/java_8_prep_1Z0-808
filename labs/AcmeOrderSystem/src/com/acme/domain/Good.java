package com.acme.domain;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.HashSet;

public abstract class Good implements Product, Comparable<Good>{
	public enum UnitOfMeasureType {LITER, GALLON, CUBIC_METER,CUBIC_FEET}
	private String name;
	private int modelNumber;
	private double height;
	private UnitOfMeasureType unitOfMeasure;
	private boolean flammable = true;
	private double weightPerUofM;
	private static List<Good> catalog;
	
	public static List<Good> getCatalog() {
		return catalog;
	}
	
	public int compareTo(Good o) {
		return new Integer(getModelNumber()).compareTo(o.getModelNumber());
	}
	
	static {
		Liquid glue = new Liquid("Acme Glue", 2334, 4, UnitOfMeasureType.LITER,false, 15, 6);
		Liquid paint = new Liquid("Acme Invisible Paint", 2490, 0.65,UnitOfMeasureType.GALLON, true, 0.70, 12);
		Solid anvil = new Solid("Acme Anvil", 1668, 0.3,UnitOfMeasureType.CUBIC_METER, false, 500, 0.25, 0.3);
		Solid safe = new Solid("Acme Safe", 1672, 1.0,UnitOfMeasureType.CUBIC_METER, false, 300, 0.5, 0.5);
		Solid balloon = new Solid("Acme Balloon", 1401, 15,UnitOfMeasureType.CUBIC_FEET, false, 10, 5, 5);
		Solid pistol = new Solid("Acme Disintegrating Pistol", 1587, 0.1,UnitOfMeasureType.CUBIC_FEET, false, 1, 0.5, 2);
		Liquid nitro = new Liquid("Acme Nitroglycerin", 4289, 1.0,UnitOfMeasureType.CUBIC_METER, true, 1.5, 0.25);
		Liquid oil = new Liquid("Acme Oil", 4275, 1.0,UnitOfMeasureType.CUBIC_METER, true, 1.5, 0.25);
		catalog = new ArrayList<Good>();
		catalog.add(glue);
		catalog.add(paint);
		catalog.add(anvil);
		catalog.add(safe);
		catalog.add(balloon);
		catalog.add(pistol);
		catalog.add(nitro);
		catalog.add(oil);
	}
	
	public static Set<Good> flammablesList() {
		Set<Good> flammables = new HashSet<Good>();
		Iterator<Good> i = Good.getCatalog().iterator();
		while (i.hasNext()) {
			Good x = i.next();
			if (x.isFlammable()) {
				flammables.add(x);
			}
		}
		return flammables;
	}
	
	
	public Good(String name, int modelNumber, double height,
		UnitOfMeasureType uoM, boolean flammable, double wgtPerUoM) {
		this.name = name;
		this.modelNumber = modelNumber;
		this.height = height;
		this.unitOfMeasure = uoM;
		this.flammable = flammable;
		this.weightPerUofM = wgtPerUoM;
	}
	
	public final boolean canShipViaPostOffice() {
		if(!isFlammable() && weight() < 200){
			return true;	
		}else{
			return false;
		}
	}
	
	public abstract double volume();
	
	public double weight() {
		return volume() * weightPerUofM;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getModelNumber() {
		return modelNumber;
	}
	public void setModelNumber(int modelNumber) {
		this.modelNumber = modelNumber;
	}
	public double getHeight() {
		return height;
	}
	public void setHeight(double height) {
		this.height = height;
	}
	public UnitOfMeasureType getUnitOfMeasure() {
		return unitOfMeasure;
	}
	public void setUnitOfMeasure(UnitOfMeasureType unitOfMeasure) {
		this.unitOfMeasure = unitOfMeasure;
	}
	public boolean isFlammable() {
		return flammable;
	}
	public void setFlammable(boolean flammable) {
		this.flammable = flammable;
	}
	public double getWeightPerUofM() {
		return weightPerUofM;
	}
	public void setWeightPerUofM(double weightPerUofM) {
		this.weightPerUofM = weightPerUofM;
	}
	
	public String toString() {
		return name + "-" + modelNumber;
	}
	
}
