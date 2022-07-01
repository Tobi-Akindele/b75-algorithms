package arrays;

public class FindMinimumInRotatedSortedArray {

	public static void main(String[] args) {
		int[] nums = { 3, 4, 5, 1, 2 };
		System.out.println(new FindMinimumInRotatedSortedArray().findMin(nums)); // should return 1
	}

	public int findMin(int[] nums) {

		if (nums.length == 0)
			return -1;
		if (nums.length == 1)
			return nums[0];

		int left = 0;
		int right = nums.length - 1;
		int min = nums[left];

		while (left < right) {

			int mid = left + (right - left) / 2;
			min = Math.min(min, nums[mid]);
			if (nums[mid] >= nums[left]) {
				left = mid + 1;
			} else {
				right = mid - 1;
			}

			if (nums[left] <= min) {
				min = nums[left];
			}
		}
		return min;
	}
}
