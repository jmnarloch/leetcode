/**
 * Created by jakubnarloch on 06.04.15.
 */
public class BestTimetoBuyandSellStockII {

    public int maxProfit(int[] prices) {

        // input: the stock prices
        // output: the maximum profit
        // edge cases: prices is null || prices is empty

        if(prices == null || prices.length <= 1) {
            return 0;
        }

        int profit = 0;
        int buy = prices[0];

        for(int ind = 1; ind < prices.length; ind++) {

            if(prices[ind] < prices[ind - 1]) {
                profit += prices[ind - 1] - buy;
                buy = prices[ind];
            }

            if(ind == prices.length - 1) {
                profit += prices[ind] - buy;
            }
        }
        return profit;
    }

    public static void main(String[] args) {

        BestTimetoBuyandSellStockII bestTime = new BestTimetoBuyandSellStockII();
        System.out.println(bestTime.maxProfit(new int[]{2, 1, 4}));
    }
}
