import java.math.*;
public class Circle {
	private int radius = 0;
	private int[] circleCenter = new int[2];
	
	public Circle(int r, int x, int y) {
		radius = r;
		circleCenter[0] = x;
		circleCenter[1] = y;
	}
	
	double Perimeter() {
		double p = 0;
		p = 2 * Math.PI * radius;
		return p;
	}
	
	double Area() {
		double a = 0;
		a = Math.PI * radius * radius;
		return a;
	}

}
