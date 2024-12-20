package lc_213;

/**
 * @author 黄豪
 *213. 打家劫舍 II
你是一个专业的小偷，计划偷窃沿街的房屋，每间房内都藏有一定的现金。这个地方所有的房屋都 围成一圈 ，这意味着第一个房屋和最后一个房屋是紧挨着的。同时，相邻的房屋装有相互连通的防盗系统，如果两间相邻的房屋在同一晚上被小偷闯入，系统会自动报警 。

给定一个代表每个房屋存放金额的非负整数数组，计算你 在不触动警报装置的情况下 ，能够偷窃到的最高金额。
 */
public class LC_213 {

}
//我的代码
class Solution {
    public int rob(int[] nums) {
        if (nums.length == 1) return nums[0];
        int n = nums.length;
        int firstSum = 0, secondSum  = 0;
        int post = 0;
        for (int i = 1, pre = 0, cur = 0; i < n; i++){
            post = Math.max(pre + nums[i - 1], cur);
            pre = cur;
            cur = post;
        }
        firstSum = post;
        post = 0;
       
        for (int i = 2, pre = 0, cur = 0; i <= n; i++){
            post = Math.max(pre + nums[i - 1], cur);
            pre = cur;
            cur = post;
        }
        secondSum = post;
        
        return Math.max(firstSum, secondSum);
    }
}
