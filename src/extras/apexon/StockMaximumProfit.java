package extras.apexon;

public class StockMaximumProfit {

    public static int maxProfit(int[] prices) {
        int result = 0;

        int min = prices[0];
        for (int price: prices) {
            result = Math.max(result, price - min);
            min = Math.min(price, min);
        }

        return result;
    }

    public static int maxProfitDay(int[] prices) {
        int maxProfit = 0;
        int maxProfitDay = 0;

        int min = prices[0];
        for (int i = 1; i < prices.length; i++) {
            int profit = prices[i] - min;
            if (profit > maxProfit) {
                maxProfit = profit;
                maxProfitDay = i + 1;
            }
            min = Math.min(prices[i], min);
        }

        return maxProfitDay;
    }

    public static void main(String[] args) {
        System.out.println(maxProfit(new int[] {7,1,5,3,6,4}));
        System.out.printf("%dth day %n", maxProfitDay(new int[] {7,1,5,3,6,4}));
    }
}
