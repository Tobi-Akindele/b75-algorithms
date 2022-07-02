package arrays;

public class ContainerWithMostWater {

	public static void main(String[] args) {
		System.out.println(new ContainerWithMostWater().maxArea(new int[] {1,8,6,2,5,4,8,3,7}));
		// should return 49
	}

	public int maxArea(int[] height) {

		int maxVol = Integer.MIN_VALUE;

		int left = 0;
		int right = height.length - 1;

		while (left < right) {

			int min = Math.min(height[left], height[right]);
			int newVol = min * (right - left);
			maxVol = Math.max(maxVol, newVol);

			if (height[left] < height[right]) {
				left += 1;
			} else if (height[right] < height[left]) {
				right -= 1;
			} else {
				left += 1; // Just shift any side;
			}
		}
		return maxVol;
	}
}
