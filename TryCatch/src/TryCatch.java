import java.util.InputMismatchException;
import java.util.Scanner;

public class TryCatch {
	public static void main(String[] args) {
		int result[]={0,1,2};
		int operand1=0;
		int operand2=0;
		Scanner in = new Scanner(System.in);
		try{		
			System.out.print("请输入除数:");
			operand1 = in.nextInt(); 
			System.out.print("请输入被除数:");
			operand2 = in.nextInt(); 		
			result[2]=operand2/operand1;
			System.out.println("计算结果："+result[3]);
		} catch (InputMismatchException ie) {
			System.out.println("异常:输入不为数字!");
		} catch (ArithmeticException ae) {
			System.out.println("异常:除数不能为零!");
		} catch (ArrayIndexOutOfBoundsException aie) {
			System.out.println("异常:数组索引越界!");
		}catch (Exception e) {
			System.out.println("其他异常:"+e.getMessage());
		}
	}

	}

