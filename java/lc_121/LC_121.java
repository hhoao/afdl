package lc_121;

/**
 * @author 黄豪
 *121. 买卖股票的最佳时机
给定一个数组 prices ，它的第 i 个元素 prices[i] 表示一支给定股票第 i 天的价格。

你只能选择 某一天 买入这只股票，并选择在 未来的某一个不同的日子 卖出该股票。设计一个算法来计算你所能获取的最大利润。

返回你可以从这笔交易中获取的最大利润。如果你不能获取任何利润，返回 0 。
 */
public class LC_121 {

}
//我的代码
class Solution {
    public int maxProfit(int[] prices) {
        int n = prices.length;
        int lowerPrice = prices[0];
        int hightPrice = prices[0];
        int profit=  0;
        for (int i = 0; i< n; i++){
            if (prices[i] < lowerPrice){
                lowerPrice = prices[i];
                hightPrice = lowerPrice;
            }else{
                hightPrice = prices[i];
            }
            profit = Math.max(profit, hightPrice-lowerPrice);
        }
        return profit;
    }
}	
//官方暴力法
class Solution1 {
    public int maxProfit(int prices[]) {
        int maxprofit = 0;
        for (int i = 0; i < prices.length - 1; i++) {
            for (int j = i + 1; j < prices.length; j++) {
                int profit = prices[j] - prices[i];
                if (profit > maxprofit) {
                    maxprofit = profit;
                }
            }
        }
        return maxprofit;
    }
}
//一次遍历
class Solution2 {
    public int maxProfit(int prices[]) {
        int minprice = Integer.MAX_VALUE;
        int maxprofit = 0;
        for (int i = 0; i < prices.length; i++) {
            if (prices[i] < minprice) {
                minprice = prices[i];
            } else if (prices[i] - minprice > maxprofit) {
                maxprofit = prices[i] - minprice;
            }
        }
        return maxprofit;
    }
}
