package ʵ��11;

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
		System.out.println(type+brand+engineNum+"����"+color+"��������");
	}
	public void accelerate() {
		System.out.println(type+brand+engineNum+"����"+color+"��������");
	}
	public void brake() {
		System.out.println(type+brand+engineNum+"����"+color+"����ɲ��");
	}
	public void stop() {
		System.out.println(type+brand+engineNum+"����"+color+"����ͣ��");
	}
}
