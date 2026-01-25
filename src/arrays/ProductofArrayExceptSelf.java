package arrays;

import java.util.*;

public class ProductofArrayExceptSelf {

	public static void main(String[] args) {
		
		ProductofArrayExceptSelf obj = new ProductofArrayExceptSelf();
		
		int[] nums = {1,2,3,4};
		System.out.println(Arrays.toString(obj.productExceptSelf(nums))); // should return [24, 12, 8, 6]
		System.out.println(Arrays.toString(obj.productExceptSelfII(nums))); // should return [24, 12, 8, 6]
		System.out.println();
		System.out.println(Arrays.toString(obj.productExceptSelf(new int[] {-1,1,0,-3,3}))); // should return [0,0,9,0,0]
		System.out.println(Arrays.toString(obj.productExceptSelfII(new int[] {-1,1,0,-3,3}))); // should return [0,0,9,0,0]
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

	public int[] productExceptSelfII(int[] nums) {
		int[] result = new int[nums.length];
		Map<Integer, List<Integer>> library = new HashMap<>();

		for (int i = 0; i < nums.length; i++) {
			library.put(i, new ArrayList<>());
			for (int j = 0; j < nums.length; j++) {
				if (i != j) {
					library.get(i).add(nums[j]);
				}
			}
		}

		for (int i = 0; i < library.size(); i++) {
			result[i] = library.get(i).stream().reduce(1, (a, b) -> a * b);
		}

		return result;
	}
}
