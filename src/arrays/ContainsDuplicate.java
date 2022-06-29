package arrays;

import java.util.HashMap;
import java.util.Map;

public class ContainsDuplicate {

	public static void main(String[] args) {

		ContainsDuplicate cd = new ContainsDuplicate();
		
		System.out.println("Test case one: ");
		System.out.println(cd.containsDuplicate(new int[] {1,2,3,1})); // should return false;
		System.out.println();
		
		System.out.println("Test case one: ");
		System.out.println(cd.containsDuplicate(new int[] {1,2,3,4})); // should return false;
		System.out.println();
		
		System.out.println("Test case one: ");
		System.out.println(cd.containsDuplicate(new int[] {1,1,1,3,3,4,3,2,4,2})); // should return false;
		System.out.println();
	}

	public boolean containsDuplicate(int[] nums) {

		if (nums.length <= 1 && nums.length >= 100000)
			return false;

		Map<Integer, Integer> visited = new HashMap<>();
		for (int i = 0; i < nums.length; i++) {
			if (nums[i] <= -1000000000 && nums[i] >= 1000000000)
				return false;

			if (visited.containsKey(nums[i])) {
				return true;
			}

			visited.put((Integer) nums[i], (Integer) i);
		}
		return false;
	}
}
