package binary;

public class MissingNumber {

	public static void main(String[] args) {
		System.out.println(new MissingNumber().missingNumber(new int[] {3,0,1})); // should return 2
	}

	public int missingNumber(int[] nums) {
        int res = nums.length;
        
        for(int i = 0; i < nums.length; i++) {
            res += (i - nums[i]);
        }
        return res;
    }
}
