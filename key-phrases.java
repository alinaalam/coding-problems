import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * https://www.udemy.com/course/data-structure-and-algorithms-analysis/learn/lecture/10679826#overview
 * @author alinaalam
 *
 */
public class KeyPhrases {
	
	public static void main(String[] args) {
		String text = "Suppose we have a set of English text documents a big set of English text documents and we wish to rank which document is the most relevant to the query";
		Set<String> excludedWords = new HashSet<>(Arrays.asList("we", "a", "of", "to", "and", "is", "the"));
		
		List<String> keyPhrases = getKeyPhrases(text, excludedWords);
		
		System.out.println(keyPhrases);
	}
	
	private static List<String> getKeyPhrases(String text, Set<String> excludedWords) {
		Map<String, Integer> map = new HashMap<>();
		int maximumFrequency = 0;
		
		for (String word : text.split("\\s+")) {
			word = word.toLowerCase();
			
			if (!excludedWords.contains(word)) {
				int frequency = map.getOrDefault(word, 0);
				map.put(word, frequency + 1);
				
				maximumFrequency = Math.max(maximumFrequency, frequency + 1);
			}
		} 

		List<String> keyPhrases = new ArrayList<>();
		
		for (Map.Entry<String, Integer> entry : map.entrySet()) {
			if (entry.getValue() == maximumFrequency) {
				keyPhrases.add(entry.getKey());
			}
		}
		
		return keyPhrases;
	}
}
