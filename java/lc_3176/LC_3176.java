package lc_3176;


import java.util.Arrays;

/**
 * LC_3176
 * 给你一个整数数组 nums 和一个 非负 整数 k 。如果一个整数序列 seq 满足在下标范围 [0, seq.length - 2] 中 最多只有 k 个下标 i 满足 seq[i] != seq[i + 1] ，那么我们称这个整数序列为 好 序列。
 *
 * 请你返回 nums 中 好 子序列 的最长长度。
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
 * 1 <= nums.length <= 500
 * 1 <= nums[i] <= 109
 * 0 <= k <= min(nums.length, 25)
 * 👍 38
 * 👎 0
 * @author xianxing
 * @since 2024/9/6
 **/

public class LC_3176 {
    public static void main(String[] args) {
        Solution solution = new Solution();
        int i = solution.maximumLength(new int[]{1, 2, 1, 1, 3}, 2);
//        int i = solution.maximumLength(new int[]{1,2,3,4,5,1}, 0);
        System.out.println(i);
    }
}

// 当前下标为 k 序列 n 个下标满足条件的最大长度
// = 前一个序列下标为 z (z < k) 满足 n 个下标序列的最大长度 + 1（nums[z] == nums[k])
// = 前一个序列下标为 z (z < k) 满足 n - 1 个下标序列的最大长度 + 1（nums[z] != nums[k])
// dp[i][k] 表示序列以 i 下标 结尾，k 个下标满足条件的长度
class Solution {
    public int maximumLength(int[] nums, int k) {
        if (nums.length == 1) {
            return 1;
        }
        int[][] dp = new int[nums.length][k+1];
        for (int i = 0; i < nums.length; i++) {
            dp[i][0] = 1;
        }
        int ans = 0;
        for (int i = 1; i < nums.length; i++) {
            for (int j = i - 1; j >= 0; j--) {
                for (int t = 0; t <= k ; t++) {
                    if (t > 0 && dp[j][t - 1] == 0) {
                        break;
                    }
                    if (nums[i] == nums[j]) {
                        dp[i][t] = Math.max(dp[j][t] + 1, dp[i][t]);
                    } else if (t > 0){
                        dp[i][t] = Math.max(dp[j][t - 1] + 1, dp[i][t]);
                    }
                    ans = Math.max(ans, dp[i][t]);
                }
            }
        }
        return ans;
    }
}


// 官方
class Solution1 {
    public int maximumLength(int[] nums, int k) {
        int ans = 0;
        int len = nums.length;
        int[][] dp = new int[len][51];
        for (int i = 0; i < len; i++) {
            Arrays.fill(dp[i], -1);
        }

        for (int i = 0; i < len; i++) {
            dp[i][0] = 1;
            for (int l = 0; l <= k; l++) {
                for (int j = 0; j < i; j++) {
                    int add = nums[i] != nums[j] ? 1 : 0;
                    if (l - add >= 0 && dp[j][l - add] != -1) {
                        dp[i][l] = Math.max(dp[i][l], dp[j][l - add] + 1);
                    }
                }
                ans = Math.max(ans, dp[i][l]);
            }
        }

        return ans;
    }
}
