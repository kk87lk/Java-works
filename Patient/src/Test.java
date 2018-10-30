
public class Test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Patient april = new Patient();
		april.setName("ZhangLi");
		april.setSex('f');
		april.setAge(33);
		april.setWeight(154.72f);
		april.setAllergies(true);
		System.out.println("Name: " + april.getName());
		System.out.println("Sex: " + april.getSex());
		System.out.println("Age: " + april.getAge());
		System.out.println("Weight: " + april.getWeight());
		System.out.println("Allergies: " + april.getAllergies());
		
		System.out.println(april.toString());
	}

}
