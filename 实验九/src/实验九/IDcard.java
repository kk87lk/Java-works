package ÊµÑé¾Å;

import java.util.Scanner;

public class IDcard {
	private long No = 0;
	
	public void setNo(long iDcard_No) {
		No = iDcard_No;
	}
	
	public long getNo() {
		return No;
	}
	
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		IDcard c = new IDcard();
		try {
			System.out.print("Input the IDcard's No:");
			c.setNo(in.nextLong());
			System.out.print("Completed");
		} catch (IllegalArgumentException nle) {
			System.out.println("1");
		}
	}
}
class IllegalArgumentException extends Exception{
	public IllegalArgumentException(String string) {
		// TODO Auto-generated constructor stub
		super(string);
	}
	public void IllegalArgumentException(String str)throws IllegalArgumentException{
		long num = 0;
		if(!(num >=100000000000000000L && num <= 999999999999999999L)) {
			throw new IllegalArgumentException("Exception:Length");
		}
	}
}
class IDcard_Exception extends Exception{
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		IDcard c = new IDcard();
		try {
			System.out.print("Input the IDcard's No:");
			c.setNo(in.nextLong());
			System.out.print("Completed");
		} catch (IllegalArgumentException nle) {
			System.out.println("1");
		}
	}
}