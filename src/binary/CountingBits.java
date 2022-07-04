package binary;

import java.util.Arrays;

public class CountingBits {

	public static void main(String[] args) {
		System.out.println(Arrays.toString(new CountingBits().countBits(2))); // should return [0,1,1]
	}

	public int[] countBits(int n) {

		if (n == 0)
			return new int[] { 0 };

		int[] res = new int[n + 1];
		int powerOf2 = 1;
		res[0] = 0;

		for (int i = 1; i < n + 1; i++) {
			if (powerOf2 * 2 == i) {
				powerOf2 = i;
			}
			res[i] = 1 + res[i - powerOf2];
		}
		return res;
	}
}
