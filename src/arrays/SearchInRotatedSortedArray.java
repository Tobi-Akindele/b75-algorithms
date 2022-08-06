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

			// check if in the left sorted portion
			if (nums[left] <= nums[mid]) {
				if (target > nums[mid] || target < nums[left]) {// search right
					left = mid + 1;
				} else { // search left
					right = mid - 1;
				}
			} else { // right sorted portion
				if (target < nums[mid] || target > nums[right]) { // search left
					right = mid - 1;
				} else {// search right
					left = mid + 1;
				}
			}
		}
		return index;
	}
}
