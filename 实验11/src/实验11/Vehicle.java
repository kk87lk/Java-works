package 实验11;

public class Vehicle {
	String type;
	String brand;
	int engineNum;
	String color;
	public Vehicle() {
	}
	public Vehicle(String type,String brand,int engineNum,String color) {
		this.brand = brand;
		this.color = color;
		this.engineNum = engineNum;
		this.type = type;
	}
	public void start() {
		System.out.println(type+brand+engineNum+"引擎"+color+"汽车发动");
	}
	public void accelerate() {
		System.out.println(type+brand+engineNum+"引擎"+color+"汽车加速");
	}
	public void brake() {
		System.out.println(type+brand+engineNum+"引擎"+color+"汽车刹车");
	}
	public void stop() {
		System.out.println(type+brand+engineNum+"引擎"+color+"汽车停车");
	}
}
