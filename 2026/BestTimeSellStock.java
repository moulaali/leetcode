/**
 * You are given an array prices where prices[i] is the price of a given stock on the ith day.
 *
 * You want to maximize your profit by choosing a single day to buy one stock and choosing a different day in the future to sell that stock.
 *
 * Return the maximum profit you can achieve from this transaction. If you cannot achieve any profit, return 0.
 *
 *
 *
 * Example 1:
 *
 * Input: prices = [7,1,5,3,6,4]
 * Output: 5
 * Explanation: Buy on day 2 (price = 1) and sell on day 5 (price = 6), profit = 6-1 = 5.
 * Note that buying on day 2 and selling on day 1 is not allowed because you must buy before you sell.
 * Example 2:
 *
 * Input: prices = [7,6,4,3,1]
 * Output: 0
 * Explanation: In this case, no transactions are done and the max profit = 0.
 */
public class BestTimeSellStock {
    public static void main(String[] args) {
        int[] prices = {7,1,5,3,6,4};
        // int[] prices = {7,6, 5, 2, 1};
        // int[] prices = {1, 5};

        getMaxProfit(prices);
    }

    static int getMaxProfit(int[] prices) {

        if (prices.length == 0) {
            return 0;
        }

        int maxProfit = 0;
        int currentMin = prices[0];


        for (int i = 1; i < prices.length; i++) {
            System.out.println("-------");
            if (prices[i] - currentMin > maxProfit) {
                maxProfit = (prices[i] - currentMin);
                System.out.println("Found new max at " + prices[i] + " maxProfit " + maxProfit);
            }

            if (prices[i] < currentMin) {
                System.out.println("new min found " + prices[i]);
                currentMin = prices[i];
            }
        }

        return maxProfit;
    }
}
