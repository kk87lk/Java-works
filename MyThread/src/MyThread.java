public class MyThread extends Thread{
	String string  = "";
	int delay = 0;
	public void setString(String string) {
		this.string = string;
	}
	public void setDelay(int delay) {
		this.delay = delay;
	}
	@Override
	public void run() {
		try {
			sleep(delay);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println(string);
		
	}
}
