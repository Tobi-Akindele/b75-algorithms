package arrays;

public class MaximumSubArray {

	public static void main(String[] args) {
		MaximumSubArray msa = new MaximumSubArray();
		
		System.out.println(msa.maxSubArray(new int[] {-2,1,-3,4,-1,2,1,-5,4})); // should return 6
	}

	public int maxSubArray(int[] nums) {

		int currSum = nums[0];
		int maxSum = currSum;

		for (int i = 1; i < nums.length; i++) {
			currSum = Math.max(nums[i] + currSum, nums[i]);
			maxSum = Math.max(currSum, maxSum);
		}
		return maxSum;
	}
}
