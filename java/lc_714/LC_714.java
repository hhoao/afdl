package lc_714;

/*
 *@author: 黄豪
 *@date : 2021年9月19日
 *@todo:714. 买卖股票的最佳时机含手续费
给定一个整数数组 prices，其中第 i 个元素代表了第 i 天的股票价格 ；整数 fee 代表了交易股票的手续费用。

你可以无限次地完成交易，但是你每笔交易都需要付手续费。如果你已经购买了一个股票，在卖出它之前你就不能再继续购买股票了。

返回获得利润的最大值。

注意：这里的一笔交易指买入持有并卖出股票的整个过程，每笔交易你只需要为支付一次手续费。
*/
public class LC_714 {

}
class Solution {
    public int maxProfit(int[] prices, int fee) {
        int n = prices.length;
        int[] f1  = new int[n + 1];
        f1[0] = -prices[0];
        int[] f2 = new int[n + 1];
        for (int i = 1; i <= n; i++){
            f1[i] = Math.max(f1[i - 1], f2[i - 1] - prices[i - 1]);
            f2[i] = Math.max(f2[i - 1], f1[i - 1] + prices[i - 1] - fee);
        }
        return Math.max(f1[n], f2[n]);
    }
}