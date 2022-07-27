package strings;

import java.util.HashMap;
import java.util.Map;

public class LongestRepeatingCharacterReplacement {

	public static void main(String[] args) {
		LongestRepeatingCharacterReplacement obj = new LongestRepeatingCharacterReplacement();
		System.out.println(obj.characterReplacement("ABAB", 2)); // should return 4
		
		System.out.println(obj.characterReplacement("AABABBA", 1)); // should return 4
	}

	public int characterReplacement(String s, int k) {
		Map<Character, Integer> count = new HashMap<>();
		int res = 0;

		int l = 0;
		int maxFreq = 0; // to optimize code
		for (int r = 0; r < s.length(); r++) {
			if (count.containsKey(s.charAt(r)))
				count.put(s.charAt(r), count.get(s.charAt(r)) + 1);
			else
				count.put(s.charAt(r), 1);

			maxFreq = Math.max(maxFreq, count.get(s.charAt(r))); // to optimize code

			while ((r - l + 1) - getMaxFreq(count) > k) { // replace getMaxFreq(count) with maxF
				count.put(s.charAt(l), count.get(s.charAt(l)) - 1);
				l++;
			}

			res = Math.max(res, r - l + 1);
		}
		return res;
	}

	private int getMaxFreq(Map<Character, Integer> map) {
		Map.Entry<Character, Integer> maxEntry = null;
		int maxFreq = 0;
		for (Map.Entry<Character, Integer> entry : map.entrySet()) {
			if (maxEntry == null || entry.getValue().compareTo(maxEntry.getValue()) > 0) {
				maxEntry = entry;
				maxFreq = Math.max(maxFreq, maxEntry.getValue());
			}
		}
		return maxFreq;
	}
}
