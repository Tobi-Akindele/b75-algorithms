package arrays;

import java.util.HashSet;
import java.util.Set;

public class LongestConsecutiveSequence {

    public static void main(String[] args) {
        System.out.println(longestConsecutive(new int[] {1,0,1,2}));
    }

    public static int longestConsecutive(int[] nums) {
        Set<Integer> numSet = new HashSet<>();

        for (int num: nums) {
            numSet.add(num);
        }

        int longest = 0;
        for(int num: numSet) {

            if (!numSet.contains(num - 1)) { // indicates the start of a sequence
                int current = num;
                int streak = 1;

                while (numSet.contains(current + 1)) {
                    current++;
                    streak++;
                }

                longest = Math.max(longest, streak);
            }
        }

        return longest;
    }
}
