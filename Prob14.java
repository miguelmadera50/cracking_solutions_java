/**
 * "Problem 1.4 -Write a method to replace all spaces in a string with
 * '%20'. You may assume that the string has sufficient space at the 
 * end of the string to hold the additional characters, and that you 
 * are given the "true" length of the string. (Note: if implementing 
 * in Java, please use a character array so that you can perform this 
 * operation in place.)"
 * 
 * EXAMPLE
 * 		Input: "Mr John Smith
 * 		Output: "Mr%20Dohn%20Smith"
 * 
 * @author miguel
 */
public class Prob14 {

	public static void main(String[] args) {
		String original = "a bc def g      ";
		char[] origCharArr = original.toCharArray();
		System.out.println(replaceSpaces(origCharArr));
	}

	/**
	 * Replaces spaces with '%20' in place by traversing the char[] backwards
	 */
	private static char[]  replaceSpaces(char[] str) {
		int spaceCount = 0;
		
		for (int i = str.length - 1; i >= 0; i--){
			if (str[i] != ' ') break;
			spaceCount++;
		}
		
		int lastLetterPos = str.length - spaceCount - 1;
		for (int i = str.length - 1; i >= 0; i--){
			if (str[lastLetterPos] == ' '){
				str[i--] = '0';
				str[i--] = '2';
				str[i] = '%';
			}
			else {
				str[i] = str[lastLetterPos];
			}
			lastLetterPos--;
		}
		return str;
	}	
}
