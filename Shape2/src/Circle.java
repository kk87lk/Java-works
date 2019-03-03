
public class Circle implements Shape{
	double radius = 0;
	public Circle(double radius) {
		this.radius = radius;
	}
	@Override
	public double area() {
		return radius*radius*Math.PI;
	}

}
