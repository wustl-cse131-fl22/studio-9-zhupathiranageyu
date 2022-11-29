package studio9;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import support.cse131.NotYetImplementedException;

public class WordCount {
	/**
	 * Constructs and returns a map of the distinct words in the specified list with
	 * each word associated with its accumulated count (that is: the number of
	 * occurrences of the word in the list).
	 * 
	 * For example, if passed a List<String> containing:
	 * 
	 * [to, be, or, not, to, be]
	 * 
	 * the resulting Map<String, Integer> would contain
	 * 
	 * key="to", value=2;
	 * key="be", value=2;
	 * key="or", value=1;
	 * key="not", value=1;
	 * 
	 * @param words
	 * @return a map which contains all of the distinct words as keys, each
	 *         associated with the number of occurrences of the word
	 */
	public static Map<String, Integer> countWords(List<String> words) {

		Map<String, Integer> WordCount = new HashMap<>();
		for (int i = 0; i < words.size(); i++) {
			if (WordCount.containsKey(words.get(i))) {
				int previousValue = WordCount.get(words.get(i));
				WordCount.put(words.get(i), previousValue + 1);
			} else {
				WordCount.put(words.get(i), 1);
			}
		}
		return WordCount;

	}
}
