import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

public class ListSub {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String apple = "apple";
		String orange = "orange";
		String pear = "pear";
		List<String> list = new ArrayList<String>();
		list.add(apple);
		list.add(orange);
		list.add(pear);
		list.add(apple);
		System.out.println("List集合中的元素为:");
		Iterator<String> iterator = list.iterator();
		while(iterator.hasNext()) {
			String string = iterator.next().toString();
			System.out.println(string);
		}
		Set<String> set = new HashSet<String>();
		System.out.println("去掉重复后的元素为:");
		set.addAll(list);
		Iterator<String> iterator2 = set.iterator();
		while(iterator2.hasNext()) {
			String string = iterator2.next().toString();
			System.out.println(string);
		}
	}

}
