
public class Book {
	private String bookName;
	private String bookSN;
	private String publisher;
	private double price;
	private int amount;
	public String getBookName() {
		return bookName;
	}
	public int getAmount() {
		return amount;
	}
	public String getBookSN() {
		return bookSN;
	}
	public double getPrice() {
		return price;
	}
	public String getPublisher() {
		return publisher;
	}
	public void setAmount(int amount) {
		this.amount = amount;
	}
	public void setBookName(String bookName) {
		this.bookName = bookName;
	}
	public void setBookSN(String bookSN) {
		this.bookSN = bookSN;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	public void setPublisher(String publisher) {
		this.publisher = publisher;
	}
	public Book(String name,String SN,String publisher,double price,int amount ) {
		bookName = name;
		bookSN = SN;
		this.publisher = publisher;
		this.price = price;
		this.amount = amount;
	}
}
