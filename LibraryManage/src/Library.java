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
		System.out.print("输入书名:");
		name = scanner.nextLine();
		System.out.print("输入出版社:");
		publisher = scanner.nextLine();
		System.out.print("输入序列号:");
		SN = scanner.nextInt();
		System.out.print("输入价格:");
		price = scanner.nextDouble();
		System.out.print("输入库存:");
		amount = scanner.nextInt();
		books[num] = new Book(name, SN,publisher,price,amount);
		num++;
	}
	
	public void deleteBook() {
		int SN;
		int i = 0;
		Scanner scanner = new Scanner(System.in);
		System.out.print("输入序列号:");
		SN = scanner.nextInt();
		while(!(books[i].getBookSN()==SN)&&i<20)
			i++;
		if(books[i].getBookSN()==SN) {
			num--;
			while(i<19) {
				books[i] = books[i+1];
				i++;
			}
		}else System.out.println("未查找到");
			
	}
	
	public void print() {
		int i = 0;
		while(books[i]!=null) {
			System.out.print("书名:" + books[i].getBookName() +" 序列号:"+books[i].getBookSN()
					+ " 出版社:"+books[i].getPublisher()+" 价格:"+books[i].getPrice()+" 库存:"+books[i].getAmount());
			if(books[i].getAmount()<=5) {
				System.out.print(" 库存不足\n");
			}else System.out.print("\n");
			i++;
		}
	}
}
