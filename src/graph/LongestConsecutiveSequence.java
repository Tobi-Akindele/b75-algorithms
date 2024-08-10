package graph;

import java.util.*;

public class LongestConsecutiveSequence {

    public static void main(String[] args) {
        System.out.println("Test case 1: nums = [100,4,200,1,3,2]");
        System.out.println(longestConsecutive(new int[]{100, 4, 200, 1, 2, 3}));

        System.out.println();

        System.out.println("Test case 2: nums = [0,3,7,2,5,8,4,6,0,1]");
        System.out.println(longestConsecutive(new int[]{0, 3, 7, 2, 5, 8, 4, 6, 0, 1}));
    }

    public static int longestConsecutive(int[] nums) {
        Set<Integer> numSet = new HashSet<>();
        for (int num : nums) {
            numSet.add(num);
        }

        int longest = 0;
        for (int num : nums) {
            if (!numSet.contains(num - 1)) {
                int length = 1;
                while (numSet.contains(num + length)) {
                    length += 1;
                }
                longest = Math.max(longest, length);
            }
        }

        return longest;
    }
}
