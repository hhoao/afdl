package lc_122;

/**
 * @author 黄豪
 *122. 买卖股票的最佳时机 II
给定一个数组，它的第 i 个元素是一支给定股票第 i 天的价格。

设计一个算法来计算你所能获取的最大利润。你可以尽可能地完成更多的交易（多次买卖一支股票）。

注意：你不能同时参与多笔交易（你必须在再次购买前出售掉之前的股票）。
 */
public class LC_122 {
	
}
//我的代码 一次遍历
class Solution {
    public int maxProfit(int[] prices) {
        int n = prices.length;
        int lowerPrice = prices[0];
        int profit = 0;
        for (int i = 0; i < n; i++){
            if (prices[i] < lowerPrice){
                lowerPrice = prices[i];
            }else{
                profit += prices[i] - lowerPrice;
                lowerPrice = prices[i];
            }
        }
        return profit;
    }
}
//官方 动态规划
class Solution1 {
    public int maxProfit(int[] prices) {
        int n = prices.length;
        int dp0 = 0, dp1 = -prices[0];
        for (int i = 1; i < n; ++i) {
            int newDp0 = Math.max(dp0, dp1 + prices[i]);
            int newDp1 = Math.max(dp1, dp0 - prices[i]);
            dp0 = newDp0;
            dp1 = newDp1;
        }
        return dp0;
    }
}
//贪心算法
class Solution2 {
    public int maxProfit(int[] prices) {
        int ans = 0;
        int n = prices.length;
        for (int i = 1; i < n; ++i) {
            ans += Math.max(0, prices[i] - prices[i - 1]);
        }
        return ans;
    }
}
