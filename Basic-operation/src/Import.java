
import java.util.Scanner;
	
public class Import {
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner in = new Scanner(System.in);
		int i = 0;
		int[] numbers = new int[100];
		int record = in.nextInt();
		while (record != 0){
			numbers[i++] = record;
			record = in.nextInt();
		}
		int n = 0;
		System.out.println(numbers[4]);
		while (numbers[n] != 0) {
			System.out.println(numbers[n++]);
		}
		in.close();
	}
	
}
