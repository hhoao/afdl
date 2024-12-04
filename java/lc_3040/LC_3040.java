package lc_3040;

import java.util.Arrays;

/**
 * LC_3040
 *
 * @author xianxing
 * @since 2024/6/8
 **/

//给你一个整数数组 nums ，如果 nums 至少 包含 2 个元素，你可以执行以下操作中的 任意 一个：
//
//
// 选择 nums 中最前面两个元素并且删除它们。
// 选择 nums 中最后两个元素并且删除它们。
// 选择 nums 中第一个和最后一个元素并且删除它们。
//
//
// 一次操作的 分数 是被删除元素的和。
//
// 在确保 所有操作分数相同 的前提下，请你求出 最多 能进行多少次操作。
//
// 请你返回按照上述要求 最多 可以进行的操作次数。
//
//
//
// 示例 1：
//
//
//输入：nums = [3,2,1,2,3,4]
//输出：3
//解释：我们执行以下操作：
//- 删除前两个元素，分数为 3 + 2 = 5 ，nums = [1,2,3,4] 。
//- 删除第一个元素和最后一个元素，分数为 1 + 4 = 5 ，nums = [2,3] 。
//- 删除第一个元素和最后一个元素，分数为 2 + 3 = 5 ，nums = [] 。
//由于 nums 为空，我们无法继续进行任何操作。
//
//
// 示例 2：
//
//
//输入：nums = [3,2,6,1,4]
//输出：2
//解释：我们执行以下操作：
//- 删除前两个元素，分数为 3 + 2 = 5 ，nums = [6,1,4] 。
//- 删除最后两个元素，分数为 1 + 4 = 5 ，nums = [6] 。
//至多进行 2 次操作。
//
//
//
//
// 提示：
//
//
// 2 <= nums.length <= 2000
// 1 <= nums[i] <= 1000
//
//
// Related Topics 记忆化搜索 数组 动态规划 👍 22 👎 0

public class LC_3040 {
}

class Solution {
    private int[][] dp;

    public int maxOperations(int[] nums) {
        dp = new int[nums.length][nums.length];
        for (int i = 0; i < nums.length; i++) {
            int[] ints = new int[nums.length];
            Arrays.fill(ints, -1);
            dp[i] = ints;
        }
        return Math.max(Math.max(getSum(nums, 2, nums.length - 1, nums[0] + nums[1]),
                getSum(nums, 0, nums.length - 3, nums[nums.length - 1] + nums[nums.length - 2])),
            getSum(nums, 1, nums.length - 2, nums[nums.length - 1] + nums[0])) + 1;
    }

    private int getSum(int[] nums, int start, int end, int v) {
        int res = 0;
        if (start >= end) {
            return res;
        }
        if (dp[start][end] != -1) {
            return dp[start][end];
        }
        if (nums[start] + nums[start + 1] == v) {
            res = Math.max(getSum(nums, start + 2, end, v) + 1, res);
        }

        if (nums[end] + nums[end - 1] == v) {
            res = Math.max(getSum(nums, start, end - 2, v) + 1, res);
        }

        if (nums[start] + nums[end] == v) {
            res = Math.max(getSum(nums, start + 1, end - 1, v) + 1, res);
        }
        dp[start][end] = res;
        return res;
    }
}
