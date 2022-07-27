package strings;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class GroupedAnagrams {

	public static void main(String[] args) {
		System.out.println(new GroupedAnagrams().groupAnagrams(new String[] {"eat","tea","tan","ate","nat","bat"}));
		// should return [["bat"],["nat","tan"],["ate","eat","tea"]] order doesn't matter
	}

	public List<List<String>> groupAnagrams(String[] strs) {
		List<List<String>> groupedAnagrams = new ArrayList<>();
        Map<String, List<String>> sortedChars = new HashMap<>();
        
        for(String s: strs) {
            char[] chars = s.toCharArray();
            Arrays.sort(chars);
            String sortedStr = new String(chars);
            sortedChars.putIfAbsent(sortedStr, new ArrayList<>());
            sortedChars.get(sortedStr).add(s);
        }
        groupedAnagrams.addAll(sortedChars.values());
        return groupedAnagrams;
	}
}
