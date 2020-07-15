import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class FindUniqueNumbers {
	public static void main(String[] args) {
		int[] array = {1, 2, 3, 2, 4, 5, 5, 6, 6, 10, 9, 0, 0, 1};
		List<Integer> uniqueNumbers = findUniqueNumbers(array);
		
		System.out.println(uniqueNumbers.toString().equals("[3, 4, 9, 10]"));
		
//		assert uniqueNumbers.toString() == "[3, 4, 9 ,10]";
	}
	
	private static List<Integer> findUniqueNumbers(int[] array) {
		Map<Integer, Integer> map = new HashMap<>();
		
		for (int num : array) {
			int count = map.getOrDefault(num, 0);
			map.put(num, count + 1);
		}
		
		List<Integer> uniqueNumbers = new ArrayList<>();
		
		for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
			if (entry.getValue() == 1) {
				uniqueNumbers.add(entry.getKey());
			}
		}
		
		return uniqueNumbers;
	}
}
