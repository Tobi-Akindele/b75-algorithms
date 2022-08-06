package strings;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;
import java.util.HashMap;
import java.util.Map;

public class ValidParenthesis {

	public static void main(String[] args) {
		
		String number = "113";
		System.out.println(Arrays.toString(number.split("1", -1)));
		
System.out.println(new ValidParenthesis().isValid("()[]"));
	}

	public boolean isValid(String s) {
		Deque<String> stack = new ArrayDeque<>();

		Map<String, String> closeToOpen = new HashMap<>();
		closeToOpen.put(")", "(");
		closeToOpen.put("]", "[");
		closeToOpen.put("}", "{");

		for (int i = 0; i < s.length(); i++) {
			if(closeToOpen.containsKey(Character.toString(s.charAt(i)))) {
				if(!stack.isEmpty() && 
						stack.peek().equals(closeToOpen.get(Character.toString(s.charAt(i))))) {
					stack.pop();
				} else {
					return false;
				}
			} else {
				stack.push(Character.toString(s.charAt(i)));
			}
		}
		return stack.isEmpty();
	}
}
