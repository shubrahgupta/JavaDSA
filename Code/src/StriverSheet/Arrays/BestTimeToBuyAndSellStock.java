package StriverSheet.Arrays;
//https://leetcode.com/problems/best-time-to-buy-and-sell-stock/description/
public class BestTimeToBuyAndSellStock {
    public static void main(String[] args) {
        BestTimeToBuyAndSellStock q = new BestTimeToBuyAndSellStock();
        int[] prices = {7,1,5,3,6,4};
//        int[] prices = {2,1,2,1,0,0,1};
        System.out.println(q.maxProfit(prices));
    }
    public int maxProfit(int[] prices) {
        if (prices.length == 1) {
            return 0;
        }
        int max_profit_so_far = Integer.MIN_VALUE;
        int max_profit_current = 0;
        for(int i = 1; i < prices.length; i++) {
            max_profit_current += (prices[i] - prices[i-1]);
            if (max_profit_current < 0) max_profit_current = 0;
            max_profit_so_far = Math.max(max_profit_current, max_profit_so_far);
        }
        return max_profit_so_far;

    }

}
