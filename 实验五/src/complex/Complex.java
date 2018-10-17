package complex;

public class Complex {
	int realPart;
	int imaginaryPart;
	
	public Complex(int a, int b) {
		realPart = a;
		imaginaryPart = b;
	}
	
	public Complex Plus(Complex x) {
		Complex result = new Complex(realPart + x.realPart, imaginaryPart + x.imaginaryPart);
		return result;
	}
	
	public Complex Minus(Complex x) {
		Complex result = new Complex(realPart - x.realPart, imaginaryPart - x.imaginaryPart);
		return result;
	}
	
	public Complex Multiply(Complex x) {
		Complex result = new Complex(realPart * x.realPart - imaginaryPart * x.imaginaryPart,
				realPart * x.imaginaryPart + imaginaryPart * x.realPart);
		return result;
	}
}
