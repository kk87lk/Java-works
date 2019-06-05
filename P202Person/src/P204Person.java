import java.util.Iterator;
import java.util.TreeSet;

public class P204Person {
	private String name;
	private long id_card;
	
	public P204Person(String name,long id_card) {
		this.name = name;
		this.id_card = id_card;
	}
	
	public int compareTo(Object o) {
		P204Person person = (P204Person) o;
		int result = id_card>person.id_card?1:(id_card==person.id_card?0:-1);
		return result;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		P204Person person1 = new P204Person("ma", 200181);
		P204Person person2 = new P204Person("li", 200186);
		P204Person person3 = new P204Person("wang", 200193);
		P204Person person4 = new P204Person("yi", 200196);
		P204Person person5 = new P204Person("wang2", 200175);
		TreeSet<P204Person> treeSet = new TreeSet<P204Person>();
		treeSet.add(person1);
		treeSet.add(person2);
		treeSet.add(person3);
		treeSet.add(person4);
		treeSet.add(person5);
		System.out.println("初始化的集合：");
		Iterator<P204Person> iterator = treeSet.iterator();
		while(iterator.hasNext()) {
			P204Person person = iterator.next();
			System.out.println("-----"+person.id_card+" "+person.name);
		}
		System.out.println("截取前面部分得到的集合：");
		iterator = treeSet.headSet(person1).iterator();
		while(iterator.hasNext()) {
			P204Person person = iterator.next();
			System.out.println("-----"+person.id_card+" "+person.name);
		}
		System.out.println("截取中间部分得到的集合：");
		iterator = treeSet.subSet(person1,person3).iterator();
		while(iterator.hasNext()) {
			P204Person person = iterator.next();
			System.out.println("-----"+person.id_card+" "+person.name);
		}
		System.out.println("截取后面部分得到的集合：");
		iterator = treeSet.tailSet(person3).iterator();
		while(iterator.hasNext()) {
			P204Person person = iterator.next();
			System.out.println("-----"+person.id_card+" "+person.name);
		}
	}

}
