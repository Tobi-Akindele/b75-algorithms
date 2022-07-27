package strings;

import java.util.HashMap;
import java.util.Map;

public class MinimumWindowSubstring {

	public static void main(String[] args) {
		System.out.println(new MinimumWindowSubstring().minWindow("ADOBECODEBANC", "ABC")); // should return BANC
	}

	public String minWindow(String s, String t) {

		if (t.isEmpty())
			return "";
		
		Map<Character, Integer> countT = new HashMap<>();
		Map<Character, Integer> window = new HashMap<>();
		for(char c: t.toCharArray()) {
			countT.put(c, countT.getOrDefault(c, 0) + 1);
		}
		
		int have = 0;
		int need = countT.size();
		
		int[] res = new int[] {-1,-1};
		int resLen = Integer.MAX_VALUE;
		int l = 0;
		
		for(int r = 0; r < s.length(); r++) {
			char c = s.charAt(r);
			window.put(c, window.getOrDefault(c, 0) + 1);
			
			if(countT.containsKey(c) && window.get(c).equals(countT.get(c)))
				have += 1;
			
			while(have == need) {
				// update our result
				if((r - l + 1) < resLen) {
					res[0] = l;
					res[1] = r;
					resLen = r - l + 1;
				}
				
				// pop from the left of our window
				window.put(s.charAt(l), window.get(s.charAt(l)) - 1);
				if(countT.containsKey(s.charAt(l)) && window.get(s.charAt(l)) < countT.get(s.charAt(l))) {
					have -= 1;
				}
				l += 1;
			}
		}
		return resLen == Integer.MAX_VALUE ? "" : s.substring(res[0], res[1] + 1);
	}
}
