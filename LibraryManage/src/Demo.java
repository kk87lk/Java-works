
public class Demo {

	public static void main(String[] args) {
		Manage manage = new Manage();
		manage.addBook();
		manage.addBook();
		manage.addBook();
		manage.print();
		manage.deleteBook();
		manage.print();
		manage.displayPrice("a");
		manage.displayPrice(1);
		manage.displayPrice(2);
		System.out.print("уш©ш╨С ");
		manage.discount(2);
	}

}
