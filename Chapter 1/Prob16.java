/**
 * "Problem 1.6 - Given an Image represented by an NxN matrix, where each 
 * of pixel in the image is 4 bytes, write a method to rotate the image by 
 * 90 degrees. Can you do this in place? "
 * 
 * @author miguel
 */
public class Prob16 {

	public static void main(String[] args) {
		
		// int data type is 4 bytes
		int[][] matrix3 = {
				{1,2,3,4,5},
				{6,7,8,9,10},
				{11,12,13,14,15},
				{16,17,18,19,20},
				{21,22,23,24,25},
		};		
		rotate(matrix3);
		printMatrix(matrix3);
	}
	
	/**
	 * In place matrix rotation
	 */
	private static int[][] rotate(int[][] matrix) {
		int buffer;
		int x = 0;
		int maxRow = matrix.length - 2;
		
		int n = matrix.length -1 ;
		
		for (int max = maxRow; max >= (matrix.length / 2); max--){
			for (int y = x; y <= max; y++){
				buffer = matrix[x][y];				
				matrix[x][y] = matrix[n-y][x];
				matrix[n-y][x] = matrix[n-x][n-y];
				matrix[n-x][n-y] = matrix[y][n-x];
				matrix[y][n-x] = buffer;
			}
			x++;
		}
		return null;
	}
	
	private static void printMatrix(int[][] matrix) {
		for (int[] arr : matrix) {
			for (int elem : arr) System.out.print(elem + " ");
			System.out.println();
		}
	}
}
