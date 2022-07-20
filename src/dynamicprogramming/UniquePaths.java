package dynamicprogramming;

public class UniquePaths {

	public static void main(String[] args) {
		System.out.println(new UniquePaths().uniquePaths(3, 7)); // should return 28
	}

	public int uniquePaths(int m, int n) {
		int[] row = initializeArrWith1s(n);

		for (int i = 0; i < m - 1; i++) {
			int[] newRow = initializeArrWith1s(n);
			for (int j = n - 2; j >= 0; j--) {
				newRow[j] = newRow[j + 1] + row[j];
			}
			row = newRow;
		}
		return row[0];
	}

	private int[] initializeArrWith1s(int length) {
		int[] arr = new int[length];
		for (int i = 0; i < length; i++) {
			arr[i] = 1;
		}
		return arr;
	}
}
