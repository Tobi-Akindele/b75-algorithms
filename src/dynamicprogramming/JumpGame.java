package dynamicprogramming;

public class JumpGame {

	public static void main(String[] args) {
		System.out.println(new JumpGame().canJump(new int[] {2,3,1,1,4})); // should return true
	}

	public boolean canJump(int[] nums) {
		int goal = nums.length - 1;
		
		for (int i = nums.length - 1; i >= 0; i--) {
			if (i + nums[i] >= goal) {
				goal = i;
			}
		}
		return goal == 0;
	}
}
