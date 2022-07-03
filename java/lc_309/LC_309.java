package lc_309;

/*
 *@author: 黄豪
 *@date : 2021年9月16日
 *@todo:给定一个整数数组，其中第 i 个元素代表了第 i 天的股票价格 。​
设计一个算法计算出最大利润。在满足以下约束条件下，你可以尽可能地完成更多的交易（多次买卖一支股票）:
你不能同时参与多笔交易（你必须在再次购买前出售掉之前的股票）。
卖出股票后，你无法在第二天买入股票 (即冷冻期为 1 天)。
示例:
输入: [1,2,3,0,2]
输出: 3 
解释: 对应的交易状态为: [买入, 卖出, 冷冻期, 买入, 卖出]
*/
public class LC_309 {

}
//动态规划
class Solution {
    public int maxProfit(int[] prices) {
        int n = prices.length;
        int f0[] = new int[n];
        f0[0] = -prices[0];
        int f1[] = new int[n];
        int f2[] = new int[n];
        for (int i = 1; i < n; i++){
            f0[i] = Math.max(f0[i-1], f2[i - 1] - prices[i]);
            f1[i] = prices[i] + f0[i - 1];
            f2[i] = Math.max(f1[i - 1], f2[i - 1]);
        }
        return Math.max(Math.max(f0[n - 1], f1[n - 1]), f2[n - 1]);
    }
}