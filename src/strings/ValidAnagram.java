package strings;

import java.util.HashMap;
import java.util.Map;

public class ValidAnagram {

	public static void main(String[] args) {
		System.out.println(new ValidAnagram().isAnagram("anagram", "nagaram")); // should return true
		System.out.println(isAnagramV1("anagram", "nagaram")); // should return true
	}

	public boolean isAnagram(String s, String t) {
		if (s.length() != t.length())
			return false;

		Map<Character, Integer> sMap = new HashMap<>();
		Map<Character, Integer> tMap = new HashMap<>();
		for (int i = 0; i < s.length(); i++) {
			sMap.put(s.charAt(i), sMap.getOrDefault(s.charAt(i), 0) + 1);
			tMap.put(t.charAt(i), tMap.getOrDefault(t.charAt(i), 0) + 1);
		}

//		for (char c: s.toCharArray()) {
//			if(!sMap.get(c).equals(tMap.getOrDefault(c, 0)))
//				return false;
//		}
//		return true;
		return sMap.equals(tMap);
	}

	public static boolean isAnagramV1(String s, String t) {
		if (s.length() != t.length()) {
			return false;
		}

		int [] freq = new int[26];

		for (char c: s.toCharArray()) {
			freq[c - 'a']++;
		}

		for (char c: t.toCharArray()) {
			freq[c - 'a']--;
		}

		for (int count: freq) {
			if (count != 0)
				return false;
		}

		return true;
	}
}
