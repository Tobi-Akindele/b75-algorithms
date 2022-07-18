package extras;

import java.util.HashMap;
import java.util.Map;

public class CheckStringBisSubstringofStringA {

	public static void main(String[] args) {
		System.out.println(check("apple", "ppl")); // should return true
	}

	public static boolean check(String a, String b) {
		Map<Character, Integer> map = new HashMap<>();
		
		for(char c: a.toCharArray()) {
			if(map.containsKey(c)) {
				map.put(c, map.get(c) + 1);
			} else {
				map.put(c, 1);
			}
		}
		
		for(char c: b.toCharArray()) {
			if(map.containsKey(c)) {
				if(map.get(c) == 1) {
					map.remove(c);
				} else {
					map.put(c, map.get(c) - 1);
				}
			} else {
				return false;
			}
		}
		return true;
	}
}
