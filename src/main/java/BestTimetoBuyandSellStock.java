/**
 * Created by jakubnarloch on 23.03.15.
 */
public class BestTimetoBuyandSellStock {

    public int maxProfit(int[] prices) {

        // input: the array A of integers N
        // output: the maximum profit that can be achieved
        // edge cases: prices is null, prices is empty array, prices contains single element

        if(prices == null || prices.length == 0) {
            return 0;
        }

        int prev = prices[0];
        for(int ind = 0; ind < prices.length; ind++) {
            int tmp = prices[ind];
            prices[ind] -= prev;
            prev = tmp;
        }

        int max = 0;
        int maxSlice = 0;
        for(int ind = 0; ind < prices.length; ind++) {

            max = Math.max(0, max + prices[ind]);
            maxSlice = Math.max(maxSlice, max);
        }
        return maxSlice;
    }
}
