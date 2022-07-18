package extras;

import java.util.LinkedList;
import java.util.List;

public class LetterCombinationOfAPhone {

	public static void main(String[] args) {
		System.out.println(new LetterCombinationOfAPhone().letterCombinations("23"));
		// should return ["ad","ae","af","bd","be","bf","cd","ce","cf"]
	}

	public List<String> letterCombinations(String digits) {
		LinkedList<String> outputArr = new LinkedList<>();

		if (digits.length() == 0)
			return outputArr;

		outputArr.add("");

		String[] charMap = new String[] { "0", "1", "abc", "def", "ghi", 
				"jkl", "mno", "pqrs", "tuv", "wxyz" };
		
		for(int i = 0; i < digits.length(); i++) {
			int index = Character.getNumericValue(digits.charAt(i));
			while(outputArr.peek().length() == i) {
				String permutation = outputArr.remove();
				for(char c: charMap[index].toCharArray()) {
					outputArr.add(permutation + c);
				}
			}
		}
		return outputArr;
	}
}
