import java.util.*;

public class MapText {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("��������Ҫ��ѯ�˵�����:");
		move();
	}
	public static void move() {
		Map map = new HashMap();
		map.put("����", "11111");
		map.put("����", "22222");
		map.put("����", "33333");
		Scanner scanner = new Scanner(System.in);
		String name = scanner.next();
		if(map.containsKey(name) == true) {
			System.out.println(name + "�ĵ绰����Ϊ:\n" + map.get(name));
		}else {
			System.out.println("���޴���,����������:");
			move();
		}
	}
}
