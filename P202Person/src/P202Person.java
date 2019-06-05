import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class P202Person {
	private String name;
	private long id_card;
	public P202Person(String name, long id_card) {
		this.name = name;
		this.id_card = id_card;
	}
	
	public int hashCode() {
		final int PRIME = 31;
		int result = 1;
		result = PRIME*result+(int)(id_card^(id_card>>>32));
		result = PRIME*result+((name == null)?0:name.hashCode());
		return result;
	}
	
	public boolean equals(Object obj) {
		if(this == obj)
			return true;
		if(obj == null)
			return false;
		if(getClass()!=obj.getClass())
			return false;
		final P202Person other = (P202Person) obj;
		if(id_card != other.id_card)
			return false;
		if(name == null) {
			if(other.name != null)
				return false;
		}else if(!name.equals(other.name))
			return false;
		return true;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Set<P202Person> hashSet = new HashSet<P202Person>();
		hashSet.add(new P202Person("ma", 220181));
		hashSet.add(new P202Person("li", 220186));
		hashSet.add(new P202Person("wang", 220193));
		Iterator<P202Person> iterator = hashSet.iterator();
		while(iterator.hasNext()) {
			P202Person person = iterator.next();
			System.out.println(person.name+""+person.id_card);
		}
	}

}
