package arrays.similar2containsduplicate;

import java.util.HashMap;
import java.util.Map;

public class ContainsDuplicateII {

	public static void main(String[] args) {
		System.out.println(
				new ContainsDuplicateII()
				.containsNearbyDuplicate(new int[] {1,2,3,1}, 3)); // should return true
	}

	public boolean containsNearbyDuplicate(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        for(int i = 0; i < nums.length; i++) {
            int currentNo = nums[i];
            
            // check if the hashmap contains currentNo and check if its index and the current index is less than k
            if(map.containsKey(currentNo) && (i - map.get(nums[i]) <= k)) {
                return true;
            } else {
                // just store the current number and the index in the hashmap
                map.put(currentNo, i);
            }
        }
        // return false if able to run through the entire array
        return false;
    }
}
