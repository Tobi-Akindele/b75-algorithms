package dynamicprogramming;

public class ClimbingStairs {

	public static void main(String[] args) {
		System.out.println(new ClimbingStairs().climbStairs(3)); // should return 3
		System.out.println(new ClimbingStairs().climbStairs(5)); // should return 8
	}

	public int climbStairs(int n) {
		int one = 1;
		int two = 1;
		
		for(int i = 0; i < n - 1; i++) {
			int temp = one;
			one = one + two;
			two = temp;
		}
		return one;
	}
}
