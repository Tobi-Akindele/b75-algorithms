package strings;

import java.util.ArrayList;
import java.util.List;

public class ValidPalindrome {

	public static void main(String[] args) {
		System.out.println();
		System.out.println(new ValidPalindrome().isPalindrome1("A man, a plan, a canal: Panama"));
	}

	// 1.
	public boolean isPalindrome1(String s) {
		int l = 0;
		int r = s.length() - 1;

		while (l < r) {
			while (l < r && !isAlphNum(s.charAt(l))) {
				l++;
			}
			while (r > l && !isAlphNum(s.charAt(r))) {
				r--;
			}

			if (Character.toLowerCase(s.charAt(l)) != Character.toLowerCase(s.charAt(r))) {
				return false;
			}

			l++;
			r--;
		}
		return true;
	}

	private boolean isAlphNum(char c) {
		int value = c;
		boolean isAlpNum = false;

		// check isUppercase
		if ((value >= 65 && value <= 90) || (value >= 97 && value <= 122) || (value >= 48 && value <= 57)) {
			isAlpNum = true;
		}
		return isAlpNum;
	}

	// 2.
	public boolean isPalindrome2(String s) {
		List<Character> charList = new ArrayList<>();

		for (int i = 0; i < s.length(); i++) {
			if (Character.isAlphabetic(s.charAt(i)) || Character.isDigit(s.charAt(i))) {
				charList.add(Character.toLowerCase(s.charAt(i)));
			}
		}

		int l = 0;
		int r = charList.size();
		while (l <= r) {
			if (s.charAt(l) != s.charAt(r)) {
				return false;
			}
			l++;
			r--;
		}
		return true;
	}
}
