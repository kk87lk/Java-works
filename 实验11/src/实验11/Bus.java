package 实验11;

public class Bus extends Vehicle{
	int maxLoad;
	String busNo;
	public Bus() {
	}
	public Bus(int maxLoad,String busNo) {
		super();
		this.busNo = busNo;
		this.maxLoad = maxLoad;
	}
	public Bus(String type,String brand,int engineNum,String color,int maxLoad,String busNo) {
		super(type, brand, engineNum, color);
		this.maxLoad = maxLoad;
		this.busNo = busNo;
	}
	public void announceBusStop() {
		System.out.println(busNo +"公交汽车报站");
	}
	@Override
	public void start() {
		System.out.println(type+busNo+brand+engineNum+"引擎"+color+"汽车发动");
	}
	@Override
	public void accelerate() {
		System.out.println(type+busNo+brand+engineNum+"引擎"+color+"汽车加速");
	}
	@Override
	public void brake() {
		System.out.println(type+busNo+brand+engineNum+"引擎"+color+"汽车刹车");
	}
	@Override
	public void stop() {
		System.out.println(type+busNo+brand+engineNum+"引擎"+color+"汽车停车");
	}
}
