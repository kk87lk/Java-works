public class Patient {
	private String name;
	private char sex;
	private int age;
	private float weight;
	private boolean allergies;
	
	public String getName() {
		return name;
	}
	
	public char getSex() {
		return sex;
	}
	
	public float getWeight() {
		return weight;
	}
	
	public int getAge() {
		return age;
	}
	
	public boolean getAllergies() {
		return allergies;
	}
	
	public void setAge(int age) {
		this.age = age;
	}
	
	public void setAllergies(boolean allergies) {
		this.allergies = allergies;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public void setSex(char sex) {
		this.sex = sex;
	}
	
	public void setWeight(float weight) {
		this.weight = weight;
	}
	
	public String toString() {
		return("Name:" + this.name + " Sex: " + this.sex + " Age: " + this.age + " Weight: " + this.weight + " Allergies: " + this.allergies);
	}
}
