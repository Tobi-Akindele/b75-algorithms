package extras.apexon;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class SumPairs {

    public static int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {
            int r =  target - nums[i];

            if (map.containsKey(r)) {
                return new int[] {map.get(r), i};
            }

            map.put(nums[i], i);
        }

        return new int[]{};
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(twoSum(new int[]{2, 7, 11, 15}, 9)));
    }
}
