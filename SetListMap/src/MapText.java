import java.util.*;

public class MapText {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("请输入需要查询人的姓名:");
		move();
	}
	public static void move() {
		Map map = new HashMap();
		map.put("张三", "11111");
		map.put("李四", "22222");
		map.put("王五", "33333");
		Scanner scanner = new Scanner(System.in);
		String name = scanner.next();
		if(map.containsKey(name) == true) {
			System.out.println(name + "的电话号码为:\n" + map.get(name));
		}else {
			System.out.println("查无此人,请重新输入:");
			move();
		}
	}
}
