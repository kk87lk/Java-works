package ʵ��ʮ��;

public class stringExample2 {
	public static void main(String[] args) {
		String s="JAVA��ӭ����";
		StringBuffer sb=new StringBuffer("JAVA��ӭ����");
		String str="�����ǵ�12���ַ���";
		s.concat(str);
		sb.append(str);
		System.out.println("��String����s�Լ�StringBuffer����sb���ַ������Ӳ�����������£�");
		System.out.println("������s��"+s);
		System.out.println("������sb��"+sb);
	}
} 
