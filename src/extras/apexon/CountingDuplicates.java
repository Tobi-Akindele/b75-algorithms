package extras.apexon;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

public class CountingDuplicates {

    private static final String FORMAT = "%s | %s | %s %n";

    public static int countV1(String s) {
        Set<Character> seenOnce = new HashSet<>();
        Set<Character> seenMoreThanOnce = new HashSet<>();

        for (char c: s.toLowerCase().toCharArray()) {
            if (seenMoreThanOnce.contains(c))
                continue;

            if (seenOnce.contains(c)) {
                seenMoreThanOnce.add(c);
            } else {
                seenOnce.add(c);
            }
        }

        return seenMoreThanOnce.size();
    }

    public static int countV2(String s) {
        Map<Character, Integer> map = new HashMap<>();

        for (char c: s.toLowerCase().toCharArray()) {
            map.put(c, map.getOrDefault(c, 0) + 1);
        }

        int count = 0;
        for (int c: map.values()) {
            if (c > 1)
                count++;
        }
        return count;
    }

    public static int countV3(String s) {
        return (int) s.toLowerCase().chars()
                .boxed()
                .collect(Collectors.groupingBy(c -> c, Collectors.counting()))
                .values().stream()
                .filter(v -> v > 1)
                .count();
    }

    public static void main(String[] args) {
        System.out.printf(FORMAT, "1", "2", "3");
        System.out.println("=".repeat(10));
        System.out.printf(FORMAT, countV1("abcde"), countV2("abcde"), countV3("abcde"));
        System.out.printf(FORMAT, countV1("aabbcde"), countV2("aabbcde"), countV3("aabbcde"));
        System.out.printf(FORMAT, countV1("aabBcde"), countV2("aabBcde"), countV3("aabBcde"));
        System.out.printf(FORMAT, countV1("indivisibility"), countV2("indivisibility"), countV3("indivisibility"));
        System.out.printf(FORMAT, countV1("Indivisibilities"), countV2("Indivisibilities"), countV3("Indivisibilities"));
        System.out.println("=".repeat(10));
    }
}
