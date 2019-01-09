
public class ShapeSquare implements Shape{
	private double side;
	public ShapeSquare(double s) {
		// TODO Auto-generated constructor stub
		side = s;
	}
	@Override
	public double getArea() {
		// TODO Auto-generated method stub
		return side*side;
	}

	@Override
	public double getPerimeter() {
		// TODO Auto-generated method stub
		return 4*side;
	}

	public void print(Shape shape) {
		// TODO Auto-generated method stub
		System.out.println(shape.getClass());
		System.out.println("Area:"+this.getArea());
		System.out.println("Perimeter:"+this.getPerimeter());
	}
}
