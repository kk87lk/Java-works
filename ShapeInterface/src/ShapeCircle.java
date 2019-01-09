
public class ShapeCircle implements Shape{
	private double radius;
	public ShapeCircle(double r) {
		// TODO Auto-generated constructor stub
		radius = r;
	}
	@Override
	public double getArea() {
		// TODO Auto-generated method stub
		return radius*radius*Math.PI;
	}

	@Override
	public double getPerimeter() {
		// TODO Auto-generated method stub
		return 2*radius*Math.PI;
	}

	public void print(Shape shape) {
		// TODO Auto-generated method stub
		System.out.println(shape.getClass());
		System.out.println("Area:"+this.getArea());
		System.out.println("Perimeter:"+this.getPerimeter());
	}
}
