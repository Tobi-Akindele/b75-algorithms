package strings;

public class PalindromeSubstrings {

	public static void main(String[] args) {
		System.out.println(new PalindromeSubstrings().countSubstrings("aaa")); // should return 6
	}

	public int countSubstrings(String s) {

		int res = 0;

		for (int i = 0; i < s.length(); i++) {
			// even length
			res += countPalindrome(i, i + 1, s);

			// odd length
			res += countPalindrome(i, i, s);
		}
		return res;
	}

	private int countPalindrome(int l, int r, String s) {
		int res = 0;
		while (l >= 0 && r < s.length() && s.charAt(l) == s.charAt(r)) {
			res += 1;
			l -= 1;
			r += 1;
		}
		return res;
	}
}
