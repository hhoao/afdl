package lc_3117;


import java.util.HashMap;
import java.util.Map;

/**
 * LC_317
 * 给你一个整数数组 nums 和一个 非负 整数 k 。如果一个整数序列 seq 满足在范围下标范围 [0, seq.length - 2] 中存在 不超过 k 个下标 i 满足 seq[i] != seq[i + 1] ，那么我们称这个整数序列为 好 序列。
 *
 * 请你返回 nums 中 好 子序列 的最长长度
 *
 * 示例 1：
 *
 * 输入：nums = [1,2,1,1,3], k = 2
 *
 * 输出：4
 *
 * 解释：
 *
 * 最长好子序列为 [1,2,1,1,3] 。
 *
 * 示例 2：
 *
 * 输入：nums = [1,2,3,4,5,1], k = 0
 *
 * 输出：2
 *
 * 解释：
 *
 * 最长好子序列为 [1,2,3,4,5,1] 。
 *
 * 提示：
 *
 * 1 <= nums.length <= 5 * 103
 * 1 <= nums[i] <= 109
 * 0 <= k <= min(50, nums.length)
 * 👍 18
 * 👎 0
 * @author xianxing
 * @since 2024/9/7
 **/

public class LC_3117 {
}


class Solution {
    public int maximumLength(int[] nums, int k) {
        if (nums.length == 1) {
            return 1;
        }
        int[][] dp = new int[nums.length][k + 1];
        dp[0][0] = 1;
        int ans = 0;
        HashMap<Integer, Integer> commonMap = new HashMap<>();
        for (int i = 1; i < nums.length; i++) {
            int finalI = i;
            int compute = commonMap.compute(nums[i], (num, index) -> {
                if (index == null) {
                    return finalI;
                } else {
                    return index;
                }
            });
            dp[i][0] = 1;
            for (int j = i - 1; j >= 0; j--) {
                for (int t = 0; t <= k; t++) {
                    if (t > 0 && dp[j][t - 1] == 0) {
                        break;
                    }
                    if (nums[j] == nums[i]) {
                        dp[i][t] = Math.max(dp[j][t] + 1, dp[i][t]);
                    } else if (t > 0) {
                        dp[i][t] = Math.max(dp[j][t - 1] + 1, dp[i][t]);
                    }
                    ans = Math.max(dp[i][t], ans);
                }
                if (j == compute) {
                    break;
                }
            }
        }
        return ans;
    }
}

// 优化
class Solution1 {
    public int maximumLength(int[] nums, int k) {
        int[] dp = new int[k + 1];
        Map<Integer, int[]> commonMap = new HashMap<>();
        for (int num : nums) {
            int[] commonDp = commonMap.computeIfAbsent(num, (key) -> new int[k + 1]);
            for (int j = 0; j <= k; j++) {
                commonDp[j] = commonDp[j] + 1;
                if (j > 0) {
                    commonDp[j] = Math.max(commonDp[j], dp[j - 1] + 1);
                }
            }
            for (int j = 0; j <= k; j++) {
                dp[j] = Math.max(dp[j], commonDp[j]);
            }
        }
        return dp[k];
    }
}

