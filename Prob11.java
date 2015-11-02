/**
 * "Problem 1.1 - Implement an algorithm to determine if a string 
 * has all unique characters. What if you cannot use additional 
 * data structures?"
 * 
 * NOTE: Assumes that only lowercase alphabet characters are used
 * 
 * @author miguel
 */
public class Prob11 {

	public static void main(String[] args) {
		String testString = "abcdefga";
		char[] testCharArr = testString.toCharArray();
		
		// Three different ways of solving Problem 1.1		
		System.out.println(checkUnique(testCharArr));
		System.out.println(checkUniqueNoStructures(testCharArr));
		System.out.println(checkUniqueBitVector(testCharArr));
	}
	
	// Uses additional data structures
	private static boolean checkUnique(char[] str) {
		
		// 26 is max size (n), this is at most O(26^2)
		if (str.length > 26) return false;
		
		boolean[] possibleLetters = new boolean[26];
		
		// ASCII 'a' is 97
		for (char letter: str){
			if (possibleLetters[letter - 'a'] == true) return false;
			else possibleLetters[letter - 'a'] = true;
		}
		return true;
	}
	
	private static boolean checkUniqueNoStructures(char[] str) {
		int counter = 0;
		
		// 26 is max size (n), this is at most O( (26^2) / 2 ) = O(383)
		if (str.length > 26) return false;
		
		for (int i = 0; i < str.length - 1; i++){
			for (int j = i+1; j < str.length; j++){
				counter++;
				if (str[i] == str[j]) return false;
			}
		}
		System.out.println(counter);
		return true;
	}
	
	private static boolean checkUniqueBitVector(char[] str){
		
		// 26 is max size (n), this is at most O(26^2)
		if (str.length > 26) return false;
		int vector = 0;
		for (char letter: str){
			int asciiValue = letter - 97;
			
			// bitwise AND with mask 
			if ((vector & (1 << asciiValue)) > 0) return false;
			vector |= (1 << asciiValue);
		}		
		return true;
	}
}