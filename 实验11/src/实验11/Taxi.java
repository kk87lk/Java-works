package 实验11;

public class Taxi extends Vehicle{
	int maxLoad;
	String corporation;
	public Taxi() {
	}
	public Taxi(int maxLoad,String corporation) {
		super();
		this.corporation = corporation;
		this.maxLoad = maxLoad;
	}
	public Taxi(String type,String brand,int engineNum,String color,int maxLoad,String corporation) {
		super(type, brand, engineNum, color);
		this.maxLoad = maxLoad;
		this.corporation = corporation;
	}
	public void dfp() {
		System.out.println("打发票");
	}
	@Override
	public void start() {
		System.out.println(type+corporation+brand+engineNum+"引擎"+color+"汽车发动");
	}
	@Override
	public void accelerate() {
		System.out.println(type+corporation+brand+engineNum+"引擎"+color+"汽车加速");
	}
	@Override
	public void brake() {
		System.out.println(type+corporation+brand+engineNum+"引擎"+color+"汽车刹车");
	}
	@Override
	public void stop() {
		System.out.println(type+corporation+brand+engineNum+"引擎"+color+"汽车停车");
	}
}
