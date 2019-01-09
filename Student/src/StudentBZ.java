
public class StudentBZ extends Student{
	String responsibility = "";
	public StudentBZ(String no, String name, int en, int ma, int co, String respon) {
		super(no, name, en, ma, co);
		responsibility = respon;
		// TODO Auto-generated constructor stub
	}
	
	@Override
	public int testScore() {
		// TODO Auto-generated method stub
		return super.testScore() + 5;
	}
	
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return super.toString()+" "+responsibility;
	}
}
