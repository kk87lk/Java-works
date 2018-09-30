
public class Foreach {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] array;
		array = new int[10];
		for(int i = 0; i < 10; i++) {
			array[i] = (i - 2);
		}
//		for(int i = 0; i < 10; i++) {
//			System.out.println(array[i]);
//		}
		for(int Foreach:array)
			System.out.println(Foreach);
	}

}
