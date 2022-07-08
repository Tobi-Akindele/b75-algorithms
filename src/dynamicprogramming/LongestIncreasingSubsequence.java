package dynamicprogramming;

import java.util.Arrays;

public class LongestIncreasingSubsequence {

	public static void main(String[] args) {
		System.out.println(new LongestIncreasingSubsequence().lengthOfLIS(new int[] {10,9,2,5,3,7,101,18}));
		// should return 4
	}

	public int lengthOfLIS(int[] nums) {
		int[] lis = new int[nums.length];
		
		for(int i = 0; i < lis.length; i++) {
			lis[i] = 1;
		}
		
		for(int i = nums.length -1; i >= 0; i--) {
			for(int j = i + 1; j < nums.length; j++) {
				if(nums[i] < nums[j]) {
					lis[i] = Math.max(lis[i], 1 + lis[j]);
				}
			}
		}
		return Arrays.stream(lis).max().getAsInt();
	}
}
