package dynamicprogramming;

import java.util.HashMap;
import java.util.Map;

public class CombinationSumIV {

	public static void main(String[] args) {
		System.out.println(new CombinationSumIV().combinationSum4(new int[] {1,2,3}, 4)); 
		// should return 7
	}

	public int combinationSum4(int[] nums, int target) {
		Map<Integer, Integer> dp = new HashMap<>();
		dp.put(0, 1);
		
		for(int total = 1; total < target + 1; total++) {
			dp.put(total, 0);
			for(int n: nums) {
				int value = dp.get(total - n) == null ? 0 : dp.get(total - n);
				dp.put(total, dp.get(total) + value);
			}
		}
		return dp.get(target);
	}
}
