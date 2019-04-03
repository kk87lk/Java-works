import java.util.Scanner;

public class Library {
	public Book[] books = new Book[20];
	static int num = 0;
	public static  int getNum() {
		return num;
	}
	public void addBook() {
		String name;
		int SN;
		String publisher;
		double price;
		int amount;
		Scanner scanner = new Scanner(System.in);
		System.out.print("��������:");
		name = scanner.nextLine();
		System.out.print("���������:");
		publisher = scanner.nextLine();
		System.out.print("�������к�:");
		SN = scanner.nextInt();
		System.out.print("����۸�:");
		price = scanner.nextDouble();
		System.out.print("������:");
		amount = scanner.nextInt();
		books[num] = new Book(name, SN,publisher,price,amount);
		num++;
	}
	
	public void deleteBook() {
		int SN;
		int i = 0;
		Scanner scanner = new Scanner(System.in);
		System.out.print("�������к�:");
		SN = scanner.nextInt();
		while(!(books[i].getBookSN()==SN)&&i<20)
			i++;
		if(books[i].getBookSN()==SN) {
			num--;
			while(i<19) {
				books[i] = books[i+1];
				i++;
			}
		}else System.out.println("δ���ҵ�");
			
	}
	
	public void print() {
		int i = 0;
		while(books[i]!=null) {
			System.out.print("����:" + books[i].getBookName() +" ���к�:"+books[i].getBookSN()
					+ " ������:"+books[i].getPublisher()+" �۸�:"+books[i].getPrice()+" ���:"+books[i].getAmount());
			if(books[i].getAmount()<=5) {
				System.out.print(" ��治��\n");
			}else System.out.print("\n");
			i++;
		}
	}
}
