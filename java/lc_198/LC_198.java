package lc_198;

/**
 * @author 黄豪
 *198. 打家劫舍
你是一个专业的小偷，计划偷窃沿街的房屋。每间房内都藏有一定的现金，影响你偷窃的唯一制约因素就是相邻的房屋装有相互连通的防盗系统，如果两间相邻的房屋在同一晚上被小偷闯入，系统会自动报警。

给定一个代表每个房屋存放金额的非负整数数组，计算你 不触动警报装置的情况下 ，一夜之内能够偷窃到的最高金额。
 */
public class LC_198 {

}
//我的代码
class Solution {
    public int rob(int[] nums) {
        int n = nums.length;
        int[] dp = new int[n + 1];
        dp[0] = 0;
        dp[1] = nums[0];
        for (int i = 2; i <= n; i++){
            dp[i] = Math.max(dp[i - 1], dp[i - 2] + nums[i - 1]);
        }
        return dp[n];
    }
}
//滚动优化
class Solution1 {
    public int rob(int[] nums) {
        int n = nums.length;
        int pre = 0, cur = nums[0], post = 0;
        for (int i = 2; i <= n; i++){
            post = Math.max(cur, pre + nums[i - 1]);
            pre = cur;
            cur = post;
        }
        return cur;
    }
}
