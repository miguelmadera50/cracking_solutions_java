/**
 * "Problem 1.3 - Given two strings, write a method to decide if one is a 
 * permutation of the other."
 * 
 * @author miguel
 */

public class Prob13 {

	public static void main(String[] args) {
		
		// Preferable to manage strings as character arrays in many 
		// of these challenges
		String original = "acbde";
		String permutation = "abrcd";
		char[] origCharArr = original.toCharArray();
		char[] permCharArr = permutation.toCharArray();
		
		//System.out.println(checkPermutationUnique(origCharArr, permCharArr));
		System.out.println(checkPermutation(origCharArr, permCharArr, 26));
	}
	
	/**
	 * Counts each letter in the char array and saves the count 
	 * in an integer array
	 */
	private static boolean checkPermutation(char[] str1, char[] str2, int n) {	
		if (str1.length != str2.length) return false;
		
		int[] letterCount1 = new int[n];
		int[] letterCount2 = new int[n];
		
		for (char str : str1) letterCount1[str - 'a']++;
		for (char str : str2) letterCount2[str - 'a']++;
		
		for (int i = 0; i < n; i++) {
			if (letterCount1[i] != letterCount2[i]) return false;
		} 
		return true;
	}

	/**
	 * NOTE: this only works if strings are unique
	 * not the actual solution to the problem at hand
	 */
	private static boolean checkPermutationUnique(char[] str1, char[] str2) {	
		if (str1.length != str2.length) return false;
		if (getBitVector(str1) == getBitVector(str2)) return true;
		else return false;
	}

	private static int getBitVector(char[] string) {
		int bitVector = 0;
		for (char str: string) bitVector |= (1 << (str - 'a'));
		System.out.println(bitVector);
		return bitVector;
	}
}