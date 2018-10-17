package complex;

import java.util.Scanner;


public class Test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner input = new Scanner(System.in);
		System.out.println("Input the real part and imaginary part of the first complex:");
		Complex one = new Complex(input.nextInt(), input.nextInt());
		System.out.println("Input the real part and imaginary part of the second complex:");
		Complex two = new Complex(input.nextInt(), input.nextInt());
		System.out.println("Operation want to do(1-plus 2-minus 3-multiply):");
		int flag = input.nextInt();
		switch (flag) {
		case 1:
			Complex result1 = new Complex(0,0);
			result1 = one.Plus(two);
			System.out.println(result1.realPart + "+" + result1.imaginaryPart + "i");
			break;
		case 2:
			Complex result2 = new Complex(0,0);
			result2 = one.Minus(two); 
			System.out.println(result2.realPart + "+" + result2.imaginaryPart + "i");
			break;
		case 3:
			Complex result3 = new Complex(0,0);
			result3 = one.Multiply(two);
			System.out.println(result3.realPart + "+" + result3.imaginaryPart + "i");
			break;
		default:
			break;
		}
	}

}
