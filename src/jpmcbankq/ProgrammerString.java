package jpmcbankq;
import java.util.HashMap;
import java.util.Map;

public class ProgrammerString {

	public static void main(String[] args) {
		System.out.println(ProgrammerString.programmerStrings("programmerxxxprozmerqgram"));
//        System.out.println(Result.programmerStrings("progxrammerrxproxgrammer"));
//        System.out.println(Result.programmerStrings("xprogxrmaxemrppprmmograeiruu"));
//        System.out.println(Result.programmerStrings("programmerprogrammer"));
	}
	
	public static int programmerStrings(String s) {
		return computeLastOccurrence(s) - computeFirstOccurrence(s);
	}

	private static Map<Character, Integer> getConstructedProgrammerMap() {
        String p = "programmer";
        Map<Character, Integer> pMap = new HashMap<>();
        for(int i = 0; i < p.length(); i++) {
            pMap.put(p.charAt(i), pMap.getOrDefault(p.charAt(i), 0) + 1);
        }
        return pMap;
    }
    
    private static int computeFirstOccurrence(String s) {
        Map<Character, Integer> pMap = getConstructedProgrammerMap();
        for(int i = 0; i < s.length(); i++) {
            computeMapValue(pMap, s.charAt(i));
            if(pMap.size() == 0) {
                return i + 1;
            }
        }
        return -1;
    }
    
    private static void computeMapValue(Map<Character, Integer> map, Character key) {
        Integer count = map.get(key);
        if (count == null) {
            return;
        }
        if(count == 1) {
            map.remove(key);
        } else {
            map.put(key, count - 1);
        }
    }
    
    private static int computeLastOccurrence(String s) {
        Map<Character, Integer> pMap = getConstructedProgrammerMap();
        for(int i = s.length() - 1; i >= 0; i--) {
            computeMapValue(pMap, s.charAt(i));
            if(pMap.size() == 0) {
                return i - 1;
            }
        }
        return -1;
    }
}
