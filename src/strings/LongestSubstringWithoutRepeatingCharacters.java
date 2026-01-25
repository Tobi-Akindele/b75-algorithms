package strings;

import java.util.HashSet;
import java.util.Set;

public class LongestSubstringWithoutRepeatingCharacters {

	public static void main(String[] args) {
		LongestSubstringWithoutRepeatingCharacters obj = new LongestSubstringWithoutRepeatingCharacters();
		System.out.println(obj.lengthOfLongestSubstring("abcabcbb"));
		System.out.println(LongestSubstringWithoutRepeatingCharacters.lengthOfLongestSubstringII("abcabcbb"));
		System.out.println(LongestSubstringWithoutRepeatingCharacters.lengthOfLongestSubstringII(" "));
		System.out.println(LongestSubstringWithoutRepeatingCharacters.lengthOfLongestSubstringIII(" "));
	}

	public static int lengthOfLongestSubstringIII(String s) {
		Set<Character> seen = new HashSet<>();

		int left = 0;
		int right = 0;
		int maxLen = 0;

		while (right < s.length()) {
			char c = s.charAt(right);

			if (!seen.contains(c)) {
				seen.add(c);
				maxLen = Math.max(maxLen, right - left + 1);
				right++;
			} else {
				seen.remove(s.charAt(left));
				left++;
			}
		}

		return maxLen;
	}

	public static int lengthOfLongestSubstringII(String s) {
		Set<Character> chars;

		int longest = 0;
		for (int i = 0; i < s.length(); i++) {
			chars = new HashSet<>();

			int j = i;
			while (j < s.length()) {

				if (!chars.add(s.charAt(j))) {
					break;
				}

				j++;
			}
			longest = Math.max(longest, chars.size());
		}

		return longest;
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
