package arrays;

import java.util.Arrays;

public class MaximumProductSubarray {

	public static void main(String[] args) {
		System.out.println(
				new MaximumProductSubarray().maxProduct(
						new int[] {1,0,-1,2,3,-5,-2})); // should return 60
	}

	public int maxProduct(int[] nums) {
		
		if(nums.length == 1)
            return nums[0];
		
        int result = Arrays.stream(nums).max().getAsInt();
        int max = 1;
        int min = 1;
        int overallTotal = 1;
        
        for(int i = 0; i < nums.length; i++) {
        	overallTotal *= nums[i];
        }
        
        for(int i = 0; i < nums.length; ++i) {
        	if(nums[i] == 0) {
        		max = 1;
        		min = 1;
        		continue;
        	}
        	int tmp = max * nums[i];
        	max = Math.max(nums[i], Math.max(nums[i] * min, nums[i] * max));
        	min = Math.min(nums[i], Math.max(nums[i] * min, tmp));
        	
        	result = Math.max(result, max);
        }
        return Math.max(result, overallTotal);
    }
}
