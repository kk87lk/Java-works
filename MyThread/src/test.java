
public class test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		MyThread t1 = new MyThread();
		MyThread t2 = new MyThread();
		MyThread t3 = new MyThread();
		t1.setString("�߳�A");
		t2.setString("�߳�B");
		t3.setString("�߳�C");
		t1.setDelay(1000);
		t2.setDelay(2000);
		t3.setDelay(3000);
		t1.start();
		t2.start();
		t3.start();
	}

}
