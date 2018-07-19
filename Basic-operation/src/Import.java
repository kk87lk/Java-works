
import java.util.Scanner;
	
public class Import {
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner in = new Scanner(System.in);
		System.out.println(in.nextLine());
		int n1 = in.nextInt();
		if (n1 == 1)
			System.out.println(n1 + 2);
		else
			System.out.println(n1);
		in.close();
	}
	
}
