package arrays;

import java.util.Arrays;

public class ProductofArrayExceptSelf {

	public static void main(String[] args) {
		
		ProductofArrayExceptSelf obj = new ProductofArrayExceptSelf();
		
		int[] nums = {1,2,3,4};
//		System.out.println(Arrays.toString(obj.productExceptSelf(nums))); // should return [24, 12, 8, 6]
		System.out.println(Arrays.toString(obj.productExceptSelf(new int[] {-1,1,0,-3,3}))); // should return [0,0,9,0,0]
	}

	public int[] productExceptSelf(int[] nums) {

		int[] output = new int[nums.length];

		output[0] = 1;

		// left prefix product
		for (int i = 1; i < nums.length; i++) {
			output[i] = output[i - 1] * nums[i - 1];
		}

		int product = 1;

		for (int i = nums.length - 1; i >= 0; i--) {

			output[i] = output[i] * product;

			product *= nums[i];
		}

		return output;
	}
}
