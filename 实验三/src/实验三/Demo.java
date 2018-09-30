package สตั้ศý;
import java.util.Scanner;
public class Demo {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		Double[] exponents = new Double[20];
		Double[] coefficients = new Double[20];
		Double[] resultExponents = new Double[40];
		Double[] resultCoefficients = new Double[40];
		int countExponents = 0, countCoefficients = 0;
		int record1 = in.nextInt();
	    for (int i = 0; i < record1; i++) {
	        exponents[countExponents++] = in.nextDouble();
	        coefficients[countCoefficients++] = in.nextDouble();
	    }
	    int record2 = in.nextInt();
	    for (int i = 0; i < record2; i++) {
	        exponents[countExponents++] = in.nextDouble();
	        coefficients[countCoefficients++] = in.nextDouble();
	    }
	    int flag = 0;
	    for(int c1 = 0; c1 < record1; c1++) {
	    	for(int c2 = 0; c2 < record2; c2++) {
	    		while (exponents[c1] > exponents[c2 + record1]) {
	    			resultExponents[flag] = exponents[c1];
	    			resultCoefficients[flag++] = coefficients[c1];
	    			break;
	    		}
	    		while (exponents[c1] == exponents[c2 + record1]) {
	    			resultExponents[flag] = exponents[c1] + exponents[c2 + record1];
	    			resultCoefficients[flag++] = coefficients[c1] + coefficients[c2 + record1];;
	    			break;
	    		}
	    		while (exponents[c1] < exponents[c2 + record1]) {
	    			resultExponents[flag] = exponents[c2 + record1];
	    			resultCoefficients[flag++] = coefficients[c2 + record1];
	    			break;
	    		}
	    	}
	    }
	    int recordLength = 0;
	    while(resultExponents[recordLength++] != null);
	    System.out.print(recordLength - 1);
	    recordLength = 0;
	    while(resultExponents[recordLength++] != null) {
	    	System.out.print(' ');
	    	System.out.print(resultExponents[recordLength]);
	    	System.out.print(' ');
	    	System.out.print(resultCoefficients[recordLength]);
	    }
	}
}