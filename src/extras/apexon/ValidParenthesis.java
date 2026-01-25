package extras.apexon;

import java.util.*;

public class ValidParenthesis {

	public static void main(String[] args) {
		System.out.println(ValidParenthesis.isValidParenthesis("()[]"));
		System.out.println(ValidParenthesis.isValidParenthesis2("(()"));
	}

	// ()[]
	public static boolean isValidParenthesis(String s) {
		Deque<Character> stack = new ArrayDeque<>();
		Map<Character, Character> matching = Map.of(
				')', '(',
				']', '[',
				'}', '{'
		);

		for (char c: s.toCharArray()) {
			if (matching.containsValue(c)) {
				stack.push(c);
			} else if (matching.containsKey(c)) {
				if (stack.isEmpty() || !stack.pop().equals(matching.get(c)))
					return false;
			}
		}

		return stack.isEmpty();
	}

	// only ( and )
	public static boolean isValidParenthesis2(String s) {
		int balance = 0;
		for (char c: s.toCharArray()) {
			if (c == '(') {
				balance++;
			} else if (c == ')') {
				balance--;
				if (balance < 0)
					return false;
			}
		}
		System.out.println("Balance = " + balance);

		return balance == 0;
	}
}
