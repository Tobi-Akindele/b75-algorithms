package dynamicprogramming;

public class CoinChange {

	public static void main(String[] args) {
//		System.out.println(new CoinChange().coinChange(new int[] {1,2,5}, 11)); // should return 3
		System.out.println(new CoinChange().coinChange(new int[] {2}, 3)); // should return -1
	}

	public int coinChange(int[] coins, int amount) {
		int[] dp = new int[amount + 1];
		dp[0] = 0;

//		Initialise the array with amount + 1
		for (int i = 1; i < dp.length; i++) {
			dp[i] = amount + 1;
		}

		for (int a = 1; a < amount + 1; a++) {
			for (int c = 0; c < coins.length; c++) {

				if (a - coins[c] >= 0) {
					dp[a] = Math.min(dp[a], 1 + dp[a - coins[c]]);
				}

			}
		}

		return dp[amount] != amount + 1 ? dp[amount] : -1;
	}
}
