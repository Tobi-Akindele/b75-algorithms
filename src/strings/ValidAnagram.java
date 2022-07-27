package strings;

import java.util.HashMap;
import java.util.Map;

public class ValidAnagram {

	public static void main(String[] args) {
		System.out.println(new ValidAnagram().isAnagram("anagram", "nagaram")); // should return true
	}

	public boolean isAnagram(String s, String t) {
		if (s.length() != t.length())
			return false;

		Map<Character, Integer> alphabets = new HashMap<>();
		for (char c : s.toCharArray()) {
			alphabets.put(c, alphabets.getOrDefault(c, 0) + 1);
		}

		for (char c : t.toCharArray()) {
			if (alphabets.containsKey(c)) {
				if (alphabets.getOrDefault(c, 0) == 0) {
					return false;
				} else {
					alphabets.put(c, alphabets.get(c) - 1);
				}
			} else {
				return false;
			}
		}
		return true;
	}
}
