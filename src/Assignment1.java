/*
 * Binary to Octal Conversion
 * @author Shubham 
 */
public class Assignment1 {

	/**
	 * 
	 * @param n 
	 * @return octal number (integer)
	 */
	public int convertBinaryToOctal(int n) {
		
		//checkBinary will check if input number is binary or not
		int checkBinary = n, remainder;
		while (checkBinary!=0) {
			remainder = checkBinary % 10;
			if ((remainder == 0) || (remainder == 1)) {
				checkBinary = checkBinary / 10;
			} else {
				break;
			}
		}
		
		if (checkBinary != 0) {
			return -1;
		}
		
		//decimalnum will store the decimal value of binary number
		int decimalnum = 0, j = 1;

		while (n > 0) {
			remainder = n % 10;
			decimalnum = decimalnum + (remainder * j);
			j = j * 2;
			n = n / 10;
		}
        
		//octal[] is the array which will store the grouped 
		int octal[] = new int[100];
		int i = 0, octalnum = 0;
		
		//octalnum wil store the result
		
		while (decimalnum != 0) {
			octal[i] = decimalnum % 8;
			decimalnum = decimalnum / 8;
			i++;
		}
		String result = "";
		for (j = i - 1; j >= 0; j--) {
			result+=Integer.toString(octal[j]);
		}
		octalnum = Integer.parseInt(result);
		
		return octalnum;
	}
}
