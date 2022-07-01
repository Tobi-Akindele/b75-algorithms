package arrays;

public class SearchInRotatedSortedArray {

	public static void main(String[] args) {
		System.out.println(new SearchInRotatedSortedArray()
				.search(new int[] { 5, 1, 2, 3, 4 }, 1)); // should return index 1
	}

	public int search(int[] nums, int target) {

		int index = -1;
		int left = 0;
		int right = nums.length - 1;

		while (left <= right) {

			int mid = left + (right - left) / 2;
			if (nums[mid] == target)
				return mid;

			if (nums[left] <= nums[mid]) {
				if (target > nums[mid] || target < nums[left]) {
					left = mid + 1;
				} else {
					right = mid - 1;
				}
			} else {
				if (target < nums[mid] || target > nums[right]) {
					right = mid - 1;
				} else {
					left = mid + 1;
				}
			}
		}
		return index;
	}
}
