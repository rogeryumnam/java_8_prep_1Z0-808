package ch02_objects;
public class Car {
	Car() {
		color = "Blue";
	}
	
	{
		color = "Red";
	}
	String color = "Green";
	String type;
		
	
	void start() {
		System.out.println("Get Started!");
	}
	
	void printDescription() {
		System.out.println("This is a " + color + " " + type);
	}
	
	public static void main(String[] args) {
		Car myCar = new Car();
		myCar.printDescription();
		int x2 = 128;
		byte b2 = (byte)x2;
		System.out.println(b2);
	}
}
