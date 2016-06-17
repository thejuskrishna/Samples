import java.util.Scanner;

class palindromeTest_simple{
	public static void main(String[] args){
		
		Scanner in = new Scanner(System.in);
		StringBuffer testString = new StringBuffer();
		System.out.println("Enter string to check: ");
		testString.append(in.nextLine());
		palindromeTest_simple check = new palindromeTest_simple();
		check.checkPalindrome(testString);
		}
		
		
		void checkPalindrome(StringBuffer testString){
			StringBuffer testReverse = new StringBuffer(testString);
			testReverse.reverse();
			if ((testString.toString().equals(testReverse.toString()))== true)
				System.out.println("Is a palindrome");
			else
				System.out.println("Not a palindrome");
		}
		
}
