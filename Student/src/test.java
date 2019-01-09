
public class test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Student student = new Student("1", "stu", 50, 49, 51);
		System.out.println(student.toString());
		System.out.println(student.testScore());
		
		Student student_copy = new Student("1", "stu", 50, 49, 51);
		
		Student student2 = new Student("2", "stu2", 50, 49, 51);
		System.out.println(student.equals(student2));
		System.out.println(student.equals(student_copy));
		
		Student student3 = new Student("3", "stu3", 50, 49, 50);
		System.out.println(student3.compare(student2));
		
		StudentXW studentXW = new StudentXW("7", "xw", 50, 49, 51, "XW");
		System.out.println(studentXW.toString());
		System.out.println(studentXW.testScore());
		
		StudentBZ studentBZ = new StudentBZ("8", "bz", 50, 49, 51, "BZ");
		System.out.println(studentBZ.toString());
		System.out.println(studentBZ.testScore());
	}

}
