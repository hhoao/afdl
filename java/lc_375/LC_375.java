package lc_375;

/*
 *@author: 黄豪
 *@date : 2021年11月12日
 *@todo:375. 猜数字大小 II
我们正在玩一个猜数游戏，游戏规则如下：

我从 1 到 n 之间选择一个数字。
你来猜我选了哪个数字。
如果你猜到正确的数字，就会 赢得游戏 。
如果你猜错了，那么我会告诉你，我选的数字比你的 更大或者更小 ，并且你需要继续猜数。
每当你猜了数字 x 并且猜错了的时候，你需要支付金额为 x 的现金。如果你花光了钱，就会 输掉游戏 。
给你一个特定的数字 n ，返回能够 确保你获胜 的最小现金数，不管我选择那个数字 。
*/
public class LC_375 {

}
//动态规划
class Solution {
    int[][] dp;
    public int choice(int left, int right){
        if (left >= right) return 0;
        if (right - left == 2) return right - 1;
        if (right - left == 1) return left;
        int curPay = 2147483647;
        for (int i = (right + left) / 2 - 1; i <= right; i++){
            if (dp[left][i - 1] == 0) dp[left][i-1] = choice(left, i - 1);
            if (dp[i+1][right] == 0) dp[i+1][right] = choice(i+1, right);
            curPay = Math.min(curPay, Math.max(dp[left][i - 1], dp[i+1][right]) + i);
        }
        return curPay;
    }
    public int getMoneyAmount(int n) {
        dp = new int[n+2][n+2];
        return choice(1, n);
    }
}