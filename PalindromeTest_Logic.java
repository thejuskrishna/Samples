import java.util.Scanner;

class PalindromeTest_Logic{
	public static void main(String[] args){
		
		Scanner in = new Scanner(System.in);
		String testString = new String();
		System.out.println("Enter string to check: ");
		testString =in.nextLine();
		PalindromeTest_Logic check = new PalindromeTest_Logic();
		check.checkPalindrome(testString);
		}
		
		
		void checkPalindrome(String testString){
			char[] testReverse_temp = new char[testString.length()];
			int stringLength = testString.length();
			int temp_stringLength = stringLength;

			for (int i=temp_stringLength-1, j=0; i>=0 ; i--, j++){
				testReverse_temp[j] = testString.charAt(i);
			}		
				String testReverse = new String (testReverse_temp);
			
			if ((testString.equals(testReverse))== true)
				System.out.println("Is a palindrome");
			else
				System.out.println("Not a palindrome");
		}
		
}
