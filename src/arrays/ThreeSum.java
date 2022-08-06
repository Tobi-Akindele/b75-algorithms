package arrays;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ThreeSum {

	public static void main(String[] args) {
		System.out.println(new ThreeSum().threeSum(new int[] {-1,0,1,2,-1,-4})); 
		//should return [[]-1,-1,2], [-1,0,1]]
	}

	public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> uniqueThree = null;
        
        Arrays.sort(nums);
        for(int i = 0; i < nums.length; i++) {
            
            if(i > 0 && nums[i] == nums[i - 1])// to ignore the same values
                continue;
            
            int left = i + 1;
            int right = nums.length - 1;
            
            while(left < right) {
                int threeSum = nums[i] + nums[left] + nums[right]; // compute sums
                if(threeSum > 0) {// if too great, shift right pointer back
                    right -= 1;
                } else if(threeSum < 0) {// if too small, shift left pointer forward
                    left += 1;
                } else {// if 0 add to result
                	uniqueThree = new ArrayList<>();
                    uniqueThree.add(nums[i]);
                    uniqueThree.add(nums[left]);
                    uniqueThree.add(nums[right]);
                    result.add(uniqueThree);
                    
                    left += 1;
                    while(nums[left] == nums[left - 1] && left < right) {// continue to shift left pointer if its the same number
                        left += 1;
                    }
                }
            }
        }
        return result;
    }
}
