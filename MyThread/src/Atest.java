import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Atest {

	public static void main(String[] args) {
		ExecutorService exe = Executors.newFixedThreadPool(50);
		A t1 = new A();
		A t2 = new A();
		t1.setString("A类对象1");
		t2.setString("A类对象2");
		t1.setDelay(1000);
		t2.setDelay(2000);
		exe.execute(t1);
		exe.execute(t2);
		 exe.shutdown();  
	        while (true) {  
	            if (exe.isTerminated()) {  
	                System.out.println("线程运行完毕");  
	                break;  
	            } 
	        }  
	}

}
