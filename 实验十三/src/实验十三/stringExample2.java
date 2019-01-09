package 实验十三;

public class stringExample2 {
	public static void main(String[] args) {
		String s="JAVA欢迎您！";
		StringBuffer sb=new StringBuffer("JAVA欢迎您！");
		String str="这里是第12章字符串";
		s.concat(str);
		sb.append(str);
		System.out.println("对String对象s以及StringBuffer对象sb做字符串连接操作，结果如下：");
		System.out.println("操作后s＝"+s);
		System.out.println("操作后sb＝"+sb);
	}
} 
