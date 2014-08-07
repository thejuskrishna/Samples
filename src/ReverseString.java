
public class ReverseString {
	
	public static void main(String args[]) {
		String sentence = "Sanju Samson  selected to Indian    team";
		String reversedSentence;
		reversedSentence = reverseSentenceByWord(sentence);
		System.out.println("Sentence received : " + sentence);
		System.out.println("Reversed sentence : " + reversedSentence);
	}
	
	public static String reverseSentenceByWord(String sentence) {
		int i;
		String temp = "";
		String reversedTemp = "";
		sentence = sentence + " ";
		for(i=0 ; i < sentence.length(); i++) {
			if(sentence.charAt(i) != ' ') {
				temp = temp + sentence.charAt(i);
			} else {
				reversedTemp = reverseWord(temp);
				sentence = sentence.replaceFirst(temp, reversedTemp);
				temp = "";
			}
			
		}
		
		return sentence;
		
	}
	
	public static String reverseWord(String word) {
		String reversedWord = "";
		int i;
		
		for(i = word.length() - 1; i >= 0; i--) {
			reversedWord = reversedWord + word.charAt(i);
		}
		
		return reversedWord;
	}

}
