/**
 * "Problem 1.7 - Write an algorithm such that if an element in an MXN 
 * matrix is 0, its entire row and column are set to 0."
 * 
 * @author miguel
 */
public class Prob17 {

	public static void main(String[] args) {
		int[][] matrix3 = {
				{1,2,3,4,5},
				{6,1,8,9,3},
				{1,2,3,4,5},
				{1,7,0,0,2},
				{2,2,3,1,5},
		};
		setZeros(matrix3);
		printMatrix(matrix3);
	}
	
	private static void setZeros(int[][] matrix) {
	
		// Rows and columns where 0's are found are stored in a boolean array.
		boolean[] columns = new boolean[matrix.length];
		boolean[] rows = new boolean[matrix[0].length];
		
		for (int i = 0; i < matrix.length; i++){
			for (int j = 0; j < matrix.length; j++){
				if (matrix[i][j] == 0){
					columns[i] = true;
					rows[j] = true;
				}
			}
		}
		
		for (int i = 0; i < matrix.length; i++){
			for (int j = 0; j < matrix.length; j++){
				if (columns[i] || rows[j]){
					matrix[i][j] = 0;
				}
			}
		}
	}

	private static void printMatrix(int[][] matrix) {
		for (int[] arr : matrix) {
			for (int elem : arr) System.out.print(elem + " ");
			System.out.println();
		}
	}
}