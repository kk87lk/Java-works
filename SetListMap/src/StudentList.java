import java.util.*;
import java.util.Iterator;

public class StudentList {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String stu0 = "����:���, �Ա�:��, ��������:1984-10-6";
		String stu1 = "����:С��, �Ա�:Ů, ��������:1982-5-10";
		String stu2 = "����:С��, �Ա�:��, ��������:1983-10-5";
		String stu3 = "����:С��, �Ա�:��, ��������:1984-1-1";
		String stu4 = "����:С��, �Ա�:��, ��������:1980-7-19";
		String stu5 = "����:С��, �Ա�:��, ��������:1984-11-3";
		List<String> list = new ArrayList<String>();
		list.add(stu0);
		list.add(stu1);
		list.add(stu2);
		list.add(stu3);
		list.add(stu4);
		list.add(stu5);
		Iterator<String> iterator = list.iterator();
		System.out.println("�����еĶ���:");
		while(iterator.hasNext()) {
			String student = iterator.next();
			System.out.println(student);
		}
		list.remove(stu1);
		Iterator<String> iterator2 = list.iterator();
		System.out.println("ɾ��stu1�󼯺��еĶ���:");
		while(iterator2.hasNext()) {
			String student = iterator2.next();
			System.out.println(student);
		}
		boolean judge = list.remove(stu1);
		String judgement;
		if(judge == false) judgement = "�ɹ�";
		else judgement = "ʧ��";
		System.out.println("ɾ��stu1"+judgement);
		String stu6 = "����:С��, �Ա�:��, ��������:1984-11-3";
		list.add(stu6);
		Iterator<String> iterator3 = list.iterator();
		System.out.println("���stu6�󼯺��еĶ���:");
		while(iterator3.hasNext()) {
			String student = iterator3.next();
			System.out.println(student);
		}
		boolean judge1 = list.remove(stu1);
		String judgement1;
		if(judge1 == false) judgement1 = "�ɹ�";
		else judgement1 = "ʧ��";
		System.out.println("���stu6"+judgement1);
	}

}
