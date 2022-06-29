package arrays;

public class BestTime2BuyNSellStock {

	public static void main(String[] args) {

		BestTime2BuyNSellStock obj = new BestTime2BuyNSellStock();

		int[] prices = { 7, 1, 5, 3, 6, 4 }; // should return 5
		System.out.println("Test one: ");
		System.out.println(obj.maxProfit(prices));
		System.out.println();

		int[] prices2 = { 7, 6, 4, 3, 1 }; // should return 0
		System.out.println("Test two: ");
		System.out.println(obj.maxProfit(prices2));
		System.out.println();

	}

	public int maxProfit(int[] prices) { // Solution 1

		int result = 0;

		if (prices.length <= 1 && prices.length >= 100000) {
			return result;
		}

		int min = prices[0];
		for (int i = 0; i < prices.length; i++) {
			if (prices[i] <= 0 && prices[i] >= 10000)
				return 0;

			result = Math.max(result, prices[i] - min);
			min = Math.min(min, prices[i]);
		}
		return result;
	}

//	public int maxProfit(int[] prices) { // Solution 2
//
//		int result = 0;
//		int minVal = Integer.MAX_VALUE;
//		int maxVal = 0;
//
//		for (int i = 0; i < prices.length; i++) {
//			if (minVal > prices[i]) {
//				minVal = prices[i];
//			} else if (prices[i] - minVal > maxVal) {
//				maxVal = prices[i] - minVal;
//			}
//		}
//
//		return maxVal;
//	}
}
