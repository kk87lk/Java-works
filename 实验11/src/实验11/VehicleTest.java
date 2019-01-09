package 实验11;

public class VehicleTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Vehicle vehicle = new Vehicle("父类通用车", "BYD", 2, "银灰色");
		vehicle.start();
		Bus bus = new Bus("子类公共汽车", "女神", 2, "白色", 50, "9路");
		bus.start();
		bus.announceBusStop();
		Taxi taxi = new Taxi("子类出租车", "奥迪", 2, "黄色", 3, "出租车公司");
		taxi.start();
		taxi.dfp();
		Trunk trunk = new Trunk("子类卡车", "东风", 2, "灰色",20);
		trunk.start();
		trunk.xh();
		}

}
