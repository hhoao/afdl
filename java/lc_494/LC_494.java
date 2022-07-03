package lc_494;

import java.util.Arrays;

/*
 *@author: 黄豪
 *@date : 2021年11月18日
 *@todo:494. 目标和
给你一个整数数组 nums 和一个整数 target 。

向数组中的每个整数前添加 '+' 或 '-' ，然后串联起所有整数，可以构造一个 表达式 ：

例如，nums = [2, 1] ，可以在 2 之前添加 '+' ，在 1 之前添加 '-' ，然后串联起来得到表达式 "+2-1" 。
返回可以通过上述方法构造的、运算结果等于 target 的不同 表达式 的数目。
*/
public class LC_494 {

}
//动态规划
class Solution {
    public int findTargetSumWays(int[] nums, int target) {
        int n = nums.length;
        int total = Arrays.stream(nums).sum();
        int max = Arrays.stream(nums).max().getAsInt();
        int[][] dp = new int[n+1][total * 2 + 1 + 2 * max];
        dp[0][total+max] = 1;
        for (int i = 1; i <= n; i++){
            for (int j = -total; j <= total; j++){
                dp[i][j + total + max] = dp[i - 1][j + total + max + nums[i - 1]] + dp[i - 1][j + total + max - nums[i - 1]];
            }
        }
        return dp[n][target+total+max];
    }
}