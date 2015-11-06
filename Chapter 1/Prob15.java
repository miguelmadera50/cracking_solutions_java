/**
 * "Problem 1.5 - Implement a method to perform basic string compression 
 * using the counts of repeated characters. For example, the string 
 * aabcccccaaa would become a2blc5a3. If the "compressed" string would
 * not become smaller than the original string, your method should 
 * return the original string.

 * @author Wholebread
 *
 */
public class Prob15 {

	public static void main(String[] args) {
		String str1 = "abcde"; 
		String str2 = "aabbccddee"; 
		String str3 = "aaabbbcccdddeee";
		String str4 = "aaaaaaaaaaaaaabbdedbbaaa";
		
		char[] str1CharArr = str1.toCharArray();		
		char[] str2CharArr = str2.toCharArray();		
		char[] str3CharArr = str3.toCharArray();
		char[] str4CharArr = str4.toCharArray();
		
		System.out.println(stringCompression(str1CharArr));
		System.out.println(stringCompression(str2CharArr));
		System.out.println(stringCompression(str3CharArr));
		System.out.println(stringCompression(str4CharArr));
	}

	private static char[] stringCompression(char[] string) {
		
		// New string will be at most n-1 length
		char[] compressedString = new char[string.length - 1];
		int compressedStringPos = 0;		
		int letterCount = 1;
		char currentLetter = string[0];
		
		for(int i = 0; i < string.length; i++){
			
			if ((i < string.length -1) && (string[i] == string[i + 1])){
				letterCount++;
			}
			else {
				
				// this may be inefficient, could be improved
				char[] letterCountChar = ("" + letterCount).toCharArray();
				
				// If string is too long, it is returned
				try {
					
					// Appends letter and number char to correct position
					compressedString[compressedStringPos++] = currentLetter;
					for (char ch : letterCountChar) 
						compressedString[compressedStringPos++] = ch;
				} 
				catch (IndexOutOfBoundsException e) {
					return string;
				}
				
				if (i < string.length -1) {
					currentLetter = string[i + 1];
					letterCount = 1;
				}
			}
		}
		return compressedString;
	}
}