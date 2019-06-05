
public class Book {
	private String BookName;
	private String BookISBN;
	private String BookPress;
	private String BookAuthor;
	private double BookPrice;
	private int BookNumber;
	public String getBookName() {
		return BookName;
	}
	public int getAmount() {
		return BookNumber;
	}
	public String getBookAuthor() {
		return BookAuthor;
	}
	public String getBookSN() {
		return BookISBN;
	}
	public double getPrice() {
		return BookPrice;
	}
	public String getPublisher() {
		return BookPress;
	}
	public void setAmount(int BookNumber) {
		this.BookNumber = BookNumber;
	}
	public void setBookName(String BookName) {
		this.BookName = BookName;
	}
	public void setBookSN(String BookISBN) {
		this.BookISBN = BookISBN;
	}
	public void setPrice(double BookPrice) {
		this.BookPrice = BookPrice;
	}
	public void setBookAuthor(String bookAuthor) {
		BookAuthor = bookAuthor;
	}
	public void setPublisher(String BookPress) {
		this.BookPress = BookPress;
	}
	public Book(String name,String SN,String BookPress,String BookAuthor,double BookPrice,int BookNumber ) {
		BookName = name;
		BookISBN = SN;
		this.BookAuthor = BookAuthor;
		this.BookPress = BookPress;
		this.BookPrice = BookPrice;
		this.BookNumber = BookNumber;
	}
}
