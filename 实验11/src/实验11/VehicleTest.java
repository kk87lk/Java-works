package ʵ��11;

public class VehicleTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Vehicle vehicle = new Vehicle("����ͨ�ó�", "BYD", 2, "����ɫ");
		vehicle.start();
		Bus bus = new Bus("���๫������", "Ů��", 2, "��ɫ", 50, "9·");
		bus.start();
		bus.announceBusStop();
		Taxi taxi = new Taxi("������⳵", "�µ�", 2, "��ɫ", 3, "���⳵��˾");
		taxi.start();
		taxi.dfp();
		Trunk trunk = new Trunk("���࿨��", "����", 2, "��ɫ",20);
		trunk.start();
		trunk.xh();
		}

}
