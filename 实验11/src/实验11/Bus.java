package ʵ��11;

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
		System.out.println(busNo +"����������վ");
	}
	@Override
	public void start() {
		System.out.println(type+busNo+brand+engineNum+"����"+color+"��������");
	}
	@Override
	public void accelerate() {
		System.out.println(type+busNo+brand+engineNum+"����"+color+"��������");
	}
	@Override
	public void brake() {
		System.out.println(type+busNo+brand+engineNum+"����"+color+"����ɲ��");
	}
	@Override
	public void stop() {
		System.out.println(type+busNo+brand+engineNum+"����"+color+"����ͣ��");
	}
}
