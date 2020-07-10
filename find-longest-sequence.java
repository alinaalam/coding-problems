/**
* Find longest sequence of 1's with one flip
* https://www.udemy.com/course/data-structure-and-algorithms-analysis/learn/lecture/17421950#overview
*/
public class FindLongestSequence {
	public static void main(String[] args) {
		assert findLongestSequence(new int[] {1, 1, 0, 1, 1, 0, 1, 0, 1, 1}) == 5;
		assert findLongestSequence(new int[] {1, 1, 0, 1, 1, 1, 1, 0, 1, 1}) == 7;
		assert findLongestSequence(new int[] {0, 1, 1, 1, 1, 1, 1, 0, 1, 1}) == 7;
		assert findLongestSequence(new int[] {}) == 0;
		assert findLongestSequence(new int[] {0}) == 1;
		assert findLongestSequence(new int[] {1}) == 1;
	}
	
	private static int findLongestSequence(int[] array) {
		// sanity check
		if (array.length == 0) {
			return 0;
		}
		
		if (array.length == 1) {
			return 1;
		}
		
		int maximumSequence = 0; 
		int startPointer = 0, currentPointer = 0, zeroPointer = -1; 
		
		while (startPointer < array.length && currentPointer < array.length) {
			if (array[currentPointer] == 0 && zeroPointer > -1) {
				maximumSequence = Math.max(maximumSequence, currentPointer - startPointer);
				startPointer = zeroPointer + 1;
				zeroPointer = -1;
			}
			if (array[currentPointer] == 0 && zeroPointer == -1) {
				zeroPointer = currentPointer;
			}
			currentPointer++;
		}

		return maximumSequence;
	}
}
