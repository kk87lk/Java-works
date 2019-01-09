package ÊµÑé11;

public class Trunk extends Vehicle{
	int maxWeight;
	public Trunk() {
	}
	public Trunk(int maxWeight) {
		super();
		this.maxWeight = maxWeight;
	}
	public Trunk(String type,String brand,int engineNum,String color,int maxWeight) {
		super(type, brand, engineNum, color);
		this.maxWeight = maxWeight;
	}
	public void xh() {
		System.out.println("Ð¶»õ");
	}
}
