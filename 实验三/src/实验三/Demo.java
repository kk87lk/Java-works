package สตั้ศý;
import java.util.Scanner;
import java.text.NumberFormat;
public class Demo {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		Double[] exponents1 = new Double[20];
		Double[] coefficients1 = new Double[20];
		Double[] exponents2 = new Double[20];
		Double[] coefficients2 = new Double[20];
		Double[] resultExponents = new Double[40];
		Double[] resultCoefficients = new Double[40];
		int countExponents = 0, countCoefficients = 0;
		int record1 = in.nextInt();
	    for (int i = 0; i < record1; i++) {
	        exponents1[countExponents++] = in.nextDouble();
	        coefficients1[countCoefficients++] = in.nextDouble();
	    }
	    countExponents = 0; countCoefficients = 0;
	    int record2 = in.nextInt();
	    for (int i = 0; i < record2; i++) {
	        exponents2[countExponents++] = in.nextDouble();
	        coefficients2[countCoefficients++] = in.nextDouble();
	    }
	    //-------------
	    int count1 = 0, count2 = 0, flag = 0, mark = 0;
	    while(!(count1 == record1 - 1 && count2 == record2 - 1 && mark >= record1 + record2 - 1)) {
	    	if(exponents1[count1] > exponents2[count2]) {
	    		resultExponents[flag] = exponents1[count1];
	    		resultCoefficients[flag++] = coefficients1[count1];
	    		count1++;
	    		if(count1 == record1) {
	    			mark++;
	    			count1--;
	    		} else mark++;
	    	}else if (exponents1[count1].equals(exponents2[count2])) {
	    		resultExponents[flag] = exponents1[count1];
	    		resultCoefficients[flag++] = coefficients1[count1] + coefficients2[count2];
	    		count1++;
	    		count2++;
	    		if(count1 == record1) {
	    			mark++;
	    			count1--;
	    		} else mark++;
	    		if(count2 == record2) {
	    			mark++;
	    			count2--;
	    		} else mark++;
	    	}else if (exponents1[count1] < exponents2[count2]) {
	    		resultExponents[flag] = exponents2[count2];
	    		resultCoefficients[flag++] = coefficients2[count2];
	    		count2++;
	    		if(count2 == record2) {
	    			mark++;
	    			count2--;
	    		} else mark++;
	    	}
	    }
	    if (mark < record1 + record2) {
	    	if(exponents1[count1] > exponents2[count2]) {
	    		resultExponents[flag] = exponents2[count2];
	    		resultCoefficients[flag++] = coefficients2[count2];
	    		count1++;
	    		if(count1 == record1) {
	    			mark++;
	    			count1--;
	    		}
	    	}else if (exponents1[count1].equals(exponents2[count2])) {
	    		resultExponents[flag] = exponents1[count1];
	    		resultCoefficients[flag++] = coefficients1[count1] + coefficients2[count2];
	    		count1++;
	    		count2++;
	    		if(count1 == record1)
	    			count1--;
	    		if(count2 == record2) {
	    			mark++;
	    			count2--;
	    		}
	    	}else if (exponents1[count1] < exponents2[count2]) {
	    		resultExponents[flag] = exponents1[count1];
	    		resultCoefficients[flag++] = coefficients1[count1];
	    		count2++;
	    		if(count2 == record2) {
	    			mark = 1;
	    			count2--;
	    		}	
	    	}
	    }
	    int recordLength = 0;
	    while(resultExponents[recordLength++] != null);
	    System.out.print(recordLength - 1);
	    recordLength = 0;
	    NumberFormat nf = NumberFormat.getInstance();
	    while(resultExponents[recordLength] != null) {
	    	System.out.print(' ');
	    	System.out.print(nf.format(resultExponents[recordLength]));
	    	System.out.print(' ');
	    	System.out.print(nf.format(resultCoefficients[recordLength++]));
	    }
	}
}