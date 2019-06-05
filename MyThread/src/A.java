
public class A implements Runnable{
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
			Thread.sleep(delay);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println(string);
	}
}