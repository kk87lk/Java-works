package 实验十三;

public class stringExample1 {
	public static void main(String[] args) {
		String str1="JAVA欢迎您！";
		String str2=new String("恭喜您分别用两种不同语法创建了字符串！");
		String str3;
		str3=str1.concat(str2);
		System.out.println("将两个字符串连接后的结构为："+str3);
		str3="JAVA欢迎您！";
		if(str1.equals(str3))
			System.out.println("恭喜您测试成功，str1与str3的内容完全相同！");
		str3="Java欢迎您！";
		if(str1.equalsIgnoreCase(str3))
			System.out.println("str1与str3的内容在不区分大小写时是完全相同！");
		int size=str1.length();
		System.out.println("s1中字符的个数为："+size);
		str3=str2.substring(2, 8);
		System.out.println("从0开始数，提取str2中第2到8个字符为："+str3);
		str3=str1.toLowerCase();
		System.out.println("将str1中的字符全部换成小写后为："+str3);
	}
}
