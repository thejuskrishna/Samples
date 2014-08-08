import java.util.Arrays;


public class NextSmallestInteger {
	
	public static void main(String args[]) {
		int inputValue = 119;
		int outputValue = getNextSmallestIntegerWithSameDigits(12345);
		if(outputValue == -1) {
			System.out.println("Single digit number. Enter numbers with two or more digits");
		} else if (inputValue > outputValue) {
			System.out.println("No larger number exist after: " + inputValue);
		} else {
			System.out.println("Next number with same digits: " + outputValue);
		}
	}
	
	public static int getNextSmallestIntegerWithSameDigits(int input) {
		int output = 0;
		int i;
		if(input/10 == 0) {
			return -1;
		}
		int getInts[];
		
		getInts = numbersWithSameDigits(input);
		output = findSmallestInteger(getInts);
		return output;
	}
	
	public static int findSmallestInteger(int[] getInts) {
		int small = getInts[0];
		int i;
		for(i=0; i < getInts.length; i++) {
			if(getInts[i] < small) {
				small = getInts[i];
			}
		}
		
		return small;
	}
	
	public static int[] numbersWithSameDigits(int input) {
		String aNumber = "" + input;
		int i = 0;
		int j = 0;
		int k = 0;
		byte[] str = aNumber.getBytes();
		byte character;
		int[] listOfNumbers;
		String[] diff = new String[100];
		for(i = 0; i < aNumber.length(); i++) {
			for(j=0; j < aNumber.length() - 1; j++) {
				
				character = str[j];
				str[j] = str[j+1];
				str[j+1] = character;
				String temp = new String(str);
				if(!temp.equals(aNumber)) {
					diff[k++] = temp;
				} 
			}
		}
		listOfNumbers = new int[k];
		
		for(i = 0; i < 100 && diff[i] != null; i++) {
			if(input != Integer.parseInt(diff[i])) {
				listOfNumbers[i] = Integer.parseInt(diff[i]);
			} 
		}
		
		return listOfNumbers;
	}
	
	public static int[] getDigits(int input) {
		int i=0;
		int numberOfDigits = String.valueOf(input).length();
		int digit[] = new int[numberOfDigits];
		
		while(input > 0) {
			digit[i] = input % 10;
			input = input / 10;
			i++;
		}
		
		
		
		return digit;
	}
	
	

}
