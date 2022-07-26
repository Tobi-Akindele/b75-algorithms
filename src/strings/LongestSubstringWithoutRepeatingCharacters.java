package strings;

import java.util.HashSet;
import java.util.Set;

public class LongestSubstringWithoutRepeatingCharacters {

	public static void main(String[] args) {
		LongestSubstringWithoutRepeatingCharacters obj = new LongestSubstringWithoutRepeatingCharacters();
		System.out.println(obj.lengthOfLongestSubstring("abcabcbb"));
	}

	public int lengthOfLongestSubstring(String s) {
		Set<Character> charSet = new HashSet<>();
		int l = 0;
		int res = 0;
		
		for(int r = 0; r < s.length(); r++) {
			while(charSet.contains(s.charAt(r))) {
				charSet.remove(s.charAt(l));
				l++;
			}
			charSet.add(s.charAt(r));
			res = Math.max(res, r - l + 1);
		}
		return res;
	}
}
