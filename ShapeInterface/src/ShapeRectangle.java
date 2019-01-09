
public class ShapeRectangle implements Shape{
	private double length;
	private double width;
	public ShapeRectangle(double l,double w) {
		// TODO Auto-generated constructor stub
		length = l;
		width = w;
	}
	public double getArea() {
		// TODO Auto-generated method stub
		return length*width;
	}

	public double getPerimeter() {
		// TODO Auto-generated method stub
		return 2*(length+width);
	}

	public void print(Shape shape) {
		// TODO Auto-generated method stub
		System.out.println(shape.getClass());
		System.out.println("Area:"+this.getArea());
		System.out.println("Perimeter:"+this.getPerimeter());
	}
}
