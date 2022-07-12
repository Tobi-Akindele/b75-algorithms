package dynamicprogramming;

import java.util.Arrays;
import java.util.List;

public class WordBreak {

	public static void main(String[] args) {
		System.out.println(new WordBreak().wordBreak("leetcode", Arrays.asList("leet", "code")));
		// should return true
	}

	public boolean wordBreak(String s, List<String> wordDict) {
		boolean[] dp = new boolean[s.length() + 1];
		dp[s.length()] = true;

		for (int i = s.length() - 1; i >= 0; i--) {
			for (String w : wordDict) {
				if (i + w.length() <= s.length() && s.substring(i, i + w.length()).equals(w)) {
					dp[i] = dp[i + w.length()];
				}
				if (dp[i]) {
					break;
				}
			}
		}
		return dp[0];
	}
}
