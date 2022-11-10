package leetcode;

class MaxProfit {
    public static int maxProfit(int[] prices) {
        var isHolding = false;
        var buyPrice = 0;
        var profit = 0;
        for (var idx = 0; idx < prices.length; idx++) {
            if (isHolding && (idx == prices.length - 1 || prices[idx] > prices[idx + 1])) {
                profit += prices[idx] - buyPrice;
                isHolding = false;
            } else if (!isHolding && idx < prices.length - 1 && prices[idx] < prices[idx + 1]) {
                buyPrice = prices[idx];
                isHolding = true;
            }
        }
        return profit;
    }
}
