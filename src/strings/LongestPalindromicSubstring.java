package strings;

public class LongestPalindromicSubstring {

	public static void main(String[] args) {
		System.out.println(new LongestPalindromicSubstring().longestPalindrome("babad"));
		// should return bad or aba
	}

	public String longestPalindrome(String s) {

		String res = "";
		int resLen = 0;

		for (int i = 0; i < s.length(); i++) {
			// even length
			int l = i;
			int r = i + 1;
			while (l >= 0 && r < s.length() && s.charAt(l) == s.charAt(r)) {
				if ((r - l + 1) > resLen) {
					res = s.substring(l, r + 1);
					resLen = r - l + 1;
				}
				l -= 1;
				r += 1;
			}

			// odd length
			l = i;
			r = i;
			while (l >= 0 && r < s.length() && s.charAt(l) == s.charAt(r)) {
				if ((r - l + 1) > resLen) {
					res = s.substring(l, r + 1);
					resLen = r - l + 1;
				}
				l -= 1;
				r += 1;
			}

		}
		return res;
	}
}
