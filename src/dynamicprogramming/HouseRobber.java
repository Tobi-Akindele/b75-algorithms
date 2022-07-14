package dynamicprogramming;

public class HouseRobber {

	public static void main(String[] args) {
		System.out.println(new HouseRobber().rob(new int[] {1,2,3,1})); // should return 4
	}

	public int rob(int[] nums) {
        int rob1 = 0;
        int rob2 = 0;
        
        for(int n: nums) {
            int temp = Math.max(n + rob1, rob2);
            rob1 = rob2;
            rob2 = temp;
        }
        
        return rob2;
    }
}
