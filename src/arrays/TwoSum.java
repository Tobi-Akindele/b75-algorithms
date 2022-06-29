package arrays;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class TwoSum {

	public static void main(String[] args) {

		int[] nums = { 2, 7, 11, 15 };
		int target = 9;

		System.out.println("Test case one: ");
		System.out.println(Arrays.toString(new TwoSum().twoSum(nums, target)));
		System.out.println();

		int[] nums2 = { 3, 2, 4 };
		int target2 = 6;

		System.out.println("Test case two: ");
		System.out.println(Arrays.toString(new TwoSum().twoSum(nums2, target2)));
		System.out.println();

		int[] nums3 = { 3, 3 };
		int target3 = 6;

		System.out.println("Test case three: ");
		System.out.println(Arrays.toString(new TwoSum().twoSum(nums3, target3)));
		System.out.println();
	}

	public int[] twoSum(int[] nums, int target) {

		if (nums.length < 2 || nums.length > 10000) {
			return new int[] {};
		}

		Map<Integer, Integer> m = new HashMap<>();

		for (int i = 0; i < nums.length; i++) {
			int r = target - nums[i];
			if (m.containsKey(r)) {
				return new int[] { m.get(r), i };
			}
			m.put(nums[i], i);
		}
		return new int[] {};
	}

}
