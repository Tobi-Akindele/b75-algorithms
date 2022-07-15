package dynamicprogramming;

import java.util.Arrays;

public class HouseRobberII {

	public static void main(String[] args) {
		System.out.println(new HouseRobber().rob(new int[] {1,2,3,1})); // should return 1 + 3 = 4
	}
	
	public int rob(int[] nums) {
		return Math.max(nums[0],
				Math.max(helper(Arrays.copyOfRange(nums, 1, nums.length)),
				helper(Arrays.copyOfRange(nums, 0, nums.length - 1))));
	}

	public int helper(int[] nums) {
        int rob1 = 0;
        int rob2 = 0;
        
        for(int n: nums) {
            int temp = Math.max(n + rob1, rob2);
            rob1 = rob2;
            rob2 = temp;
        }
        
        return rob2;
    }
}
