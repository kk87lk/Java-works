
public class Rectangle implements Shape{
	double width = 0;
	double length = 0;
	public Rectangle(double width,double length) {
		this.length = length;
		this.width = width;
	}
	@Override
	public double area() {
		return length * width;
	}
	
}
