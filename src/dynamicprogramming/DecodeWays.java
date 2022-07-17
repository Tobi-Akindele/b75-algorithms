package dynamicprogramming;

import java.util.HashMap;
import java.util.Map;

public class DecodeWays {

	public static void main(String[] args) {
		System.out.println(new DecodeWays().numDecodings("1201234")); // should return 2
	}

	public int numDecodings(String s) {
		Map<Integer, Integer> dp = new HashMap<>();
		dp.put(s.length(), 1);
		
		for(int i = s.length() - 1; i >= 0; i--) {
			if (String.valueOf(s.charAt(i)).equals("0")) {
				dp.put(i, 0);
			} else {
				dp.put(i, dp.get(i + 1));
			}
			
			if(i + 1 < s.length()) {
				boolean charIsBtw20And26 = (String.valueOf(s.charAt(i)).equals("2") 
						&& "123456".contains(String.valueOf(s.charAt(i + 1))));
				if(String.valueOf(s.charAt(i)).equals("1")
						|| charIsBtw20And26) {
					int value = dp.get(i) + dp.get(i + 2);
					dp.put(i, value);
				}
			}
		}
		return dp.get(0);
	}
}
