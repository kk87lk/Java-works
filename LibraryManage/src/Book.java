
public class Book {
	private int BookID;
	private String BookISBN;
	private String BookName;
	private String BookAuthor;
	private String BookPress;
	private double BookPrice;
	private int BookNumber;
	
	public void setBookAuthor(String bookAuthor) {
		BookAuthor = bookAuthor;
	}
	public void setBookID(int bookID) {
		BookID = bookID;
	}
	public void setBookISBN(String bookISBN) {
		BookISBN = bookISBN;
	}
	public void setBookName(String bookName) {
		BookName = bookName;
	}
	public void setBookNumber(int bookNumber) {
		BookNumber = bookNumber;
	}
	public void setBookPress(String bookPress) {
		BookPress = bookPress;
	}
	public void setBookPrice(double bookPrice) {
		BookPrice = bookPrice;
	}
	public String getBookAuthor() {
		return BookAuthor;
	}
	public int getBookID() {
		return BookID;
	}
	public String getBookISBN() {
		return BookISBN;
	}
	public String getBookName() {
		return BookName;
	}
	public int getBookNumber() {
		return BookNumber;
	}
	public String getBookPress() {
		return BookPress;
	}
	public double getBookPrice() {
		return BookPrice;
	}
}
