import java.util.Arrays;

public class SpiralMatrix {
	public static void main(String[] args) {
		int[][] arr = fillArray(5, 5);
		System.out.println(Arrays.deepToString(arr));
		printSpiralMatrxi(arr);
		
		arr = fillArray(4, 4);
		System.out.println(Arrays.deepToString(arr));
		printSpiralMatrxi(arr);
	}
	
	private static void printSpiralMatrxi(int[][] arr) {
		int startRow = 0, startCol = 0, endRow = arr.length - 1, endCol = arr.length - 1;
		
		while (startRow <= endRow && startCol <= endCol) {
			// print left row 
			for (int col = startCol; col <= endCol; col++) {
				System.out.print(arr[startRow][col] + " ");
			}
			startRow++;
			System.out.println();
		
			// print downward column
			for (int row = startRow; row <= endRow; row++) {
				System.out.print(arr[row][endCol] + " ");
			}
			endCol--;
			System.out.println();
			
			// print right row
			for (int col = endCol; col >= startCol; col--) {
				System.out.print(arr[endRow][col] + " ");
			}
			endRow--;
			System.out.println();
			
			// print top col
			for (int row = endRow; row >= startRow; row--) {
				System.out.print(arr[row][startCol] + " ");
			}
			startCol++;
			System.out.println();
		}
	}
	
	private static int[][] fillArray(int rows, int cols) {
		int[][] arr = new int[rows][cols];
		int value = 1;
		for (int row = 0; row < rows; row++) {
			for (int col = 0; col < cols; col++) {
				arr[row][col] = value;
				value++;
			}
		}
		
		return arr;
	}
}
