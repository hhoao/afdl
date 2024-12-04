package lc_1959;


import java.util.Arrays;

/**
 * LC_1959
 *
 * @author w
 * @since 2024/9/18
 **/

public class LC_1959 {
    public static void main(String[] args) {
        Solution solution = new Solution();
//        int i = solution.minSpaceWastedKResizing(new int[]{10, 20}, 0);
//        int i = solution.minSpaceWastedKResizing(new int[]{10, 20, 30}, 1);
        int i = solution.minSpaceWastedKResizing(new int[]{10,20,15,30,20}, 2);
        System.out.println(i);
    }
}

// 方案一 :
// 因为最后一个数组大小只能调整为最后几个元素的最大值， 所以可以通过每次从后往前遍历来设置数组大小
// 使用 maxHeight 表示全局最大高度
// 使用 dp[i][j][2] 表示第 i 次调整，调整下标 j 元素时浪费的最小空间, 以及高度
// 遍历 k 到 j (k > j),  dp[i][j] = Math.max(dp[i][k][0] + (maxHeight - j 到 k 的 最大高度) * (k - j), dp[i][j])
// 现在该如何获取 j 到 k 的最大高度
// 可以通过预处理通过一个二维数组存储 j 到 k 的最大高度
// 方案二:
// 题目可以转换为，将 nums 数组分为 k 个数组，求所有数组的最大值 * 数组长度再相加的最小值
// 可以推断出: 一段数组所浪费的最小值等于两个子数组所浪费的最小值
// 我们可以通过动态规划做此题, dp[i][j] 为下标为 i 第 j 次调整的所浪费空间的最小值
// 状态转移方程为： dp[i][j] = Math.min(dp[f - 1][j - 1] + g[f][i], dp[i][j])
// g[f][i] 可以理解为 f到 i 浪费的空间，可以通过 max(nums[f]...nums[i]) * (i - f) 计算
// g[f][i] 提前计算得出

class Solution {
    public int minSpaceWastedKResizing(int[] nums, int k) {
        int[][] waists = new int[nums.length][nums.length];
        int[][] dp = new int[nums.length + 1][k + 1];
        int max = Integer.MIN_VALUE, sum = 0;
        for (int i = 0; i < nums.length; i++) {
            max = Math.max(nums[i], max);
            sum += nums[i];
            int currentMax = nums[i], currentSum = nums[i];
            dp[i + 1][0] = max * (i + 1) - sum;
            for (int j = i + 1; j < nums.length; j++) {
                currentSum += nums[j];
                currentMax = Math.max(currentMax, nums[j]);
                waists[i][j] = currentMax * (j - i + 1) - currentSum;
            }
        }
        for (int j = 1; j <= k; j++) {
            for (int i = 1; i <= nums.length; i++) {
                dp[i][j] = waists[0][nums.length - 1];
                for (int f = j; f <= i; f++) {
                    dp[i][j] = Math.min(dp[f - 1][j - 1] + waists[f - 1][i - 1], dp[i][j]);
                }
            }
        }
        return dp[nums.length][k];
    }
}
