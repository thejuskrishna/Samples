import java.util.Arrays;


public class Permute {

	public static void main(String args[]) {
		System.out.println(Arrays.toString(numbersWithSameDigits(119)));
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
}
