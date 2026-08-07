class Solution {
    public int maxProfit(int[] prices) {
        if(prices.length == 0) return 0;
        int minPrice = prices[0];
        int maxProfit = 0;
        for(int i = 1; i < prices.length; i++){
            minPrice = Math.min(minPrice, prices[i]);
            int profit = prices[i] - minPrice;
            maxProfit = Math.max(maxProfit, profit);
        }
        return maxProfit;
    }
}