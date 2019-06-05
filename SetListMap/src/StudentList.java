import java.util.*;
import java.util.Iterator;

public class StudentList {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String stu0 = "姓名:李哥, 性别:男, 出生日期:1984-10-6";
		String stu1 = "姓名:小陈, 性别:女, 出生日期:1982-5-10";
		String stu2 = "姓名:小刘, 性别:男, 出生日期:1983-10-5";
		String stu3 = "姓名:小张, 性别:男, 出生日期:1984-1-1";
		String stu4 = "姓名:小董, 性别:男, 出生日期:1980-7-19";
		String stu5 = "姓名:小吕, 性别:男, 出生日期:1984-11-3";
		List<String> list = new ArrayList<String>();
		list.add(stu0);
		list.add(stu1);
		list.add(stu2);
		list.add(stu3);
		list.add(stu4);
		list.add(stu5);
		Iterator<String> iterator = list.iterator();
		System.out.println("集合中的对象:");
		while(iterator.hasNext()) {
			String student = iterator.next();
			System.out.println(student);
		}
		list.remove(stu1);
		Iterator<String> iterator2 = list.iterator();
		System.out.println("删除stu1后集合中的对象:");
		while(iterator2.hasNext()) {
			String student = iterator2.next();
			System.out.println(student);
		}
		boolean judge = list.remove(stu1);
		String judgement;
		if(judge == false) judgement = "成功";
		else judgement = "失败";
		System.out.println("删除stu1"+judgement);
		String stu6 = "姓名:小吕, 性别:男, 出生日期:1984-11-3";
		list.add(stu6);
		Iterator<String> iterator3 = list.iterator();
		System.out.println("添加stu6后集合中的对象:");
		while(iterator3.hasNext()) {
			String student = iterator3.next();
			System.out.println(student);
		}
		boolean judge1 = list.remove(stu1);
		String judgement1;
		if(judge1 == false) judgement1 = "成功";
		else judgement1 = "失败";
		System.out.println("添加stu6"+judgement1);
	}

}
