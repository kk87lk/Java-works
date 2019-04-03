
public class Manage extends Library{
	double DISCOUNT = 0.5;
	public void discount(int SN) {
		int i = 0;
		while(!(books[i].getBookSN()==SN)&&i<20)
			i++;
		if(books[i].getBookSN()==SN) {
			System.out.println(books[i].getPrice() * DISCOUNT);
		}else System.out.println("未查找到");
	}
	
	public void displayPrice(String name) {
		int i = 0;
		while(!books[i].getBookName().equals(name)&&i<20)
			i++;
		if(books[i].getBookName().equals(name)) {
			System.out.println(books[i].getPrice());
		}else System.out.println("未查找到");
	}
	
	public void displayPrice(int SN) {
		int i = 0;
		while(!(books[i].getBookSN()== SN)&&i<20)
			i++;
		if(books[i].getBookSN()== SN) {
			System.out.println(books[i].getPrice());
		}else System.out.println("未查找到");
	}
	

}
