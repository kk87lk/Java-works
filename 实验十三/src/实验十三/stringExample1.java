package ʵ��ʮ��;

public class stringExample1 {
	public static void main(String[] args) {
		String str1="JAVA��ӭ����";
		String str2=new String("��ϲ���ֱ������ֲ�ͬ�﷨�������ַ�����");
		String str3;
		str3=str1.concat(str2);
		System.out.println("�������ַ������Ӻ�ĽṹΪ��"+str3);
		str3="JAVA��ӭ����";
		if(str1.equals(str3))
			System.out.println("��ϲ�����Գɹ���str1��str3��������ȫ��ͬ��");
		str3="Java��ӭ����";
		if(str1.equalsIgnoreCase(str3))
			System.out.println("str1��str3�������ڲ����ִ�Сдʱ����ȫ��ͬ��");
		int size=str1.length();
		System.out.println("s1���ַ��ĸ���Ϊ��"+size);
		str3=str2.substring(2, 8);
		System.out.println("��0��ʼ������ȡstr2�е�2��8���ַ�Ϊ��"+str3);
		str3=str1.toLowerCase();
		System.out.println("��str1�е��ַ�ȫ������Сд��Ϊ��"+str3);
	}
}
