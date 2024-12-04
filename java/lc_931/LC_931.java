package lc_931;


import java.util.Arrays;

/**
 * LC_931
 *  给你一个 n x n 的 方形 整数数组 matrix ，请你找出并返回通过 matrix 的下降路径 的 最小和 。
 *
 * 下降路径 可以从第一行中的任何元素开始，并从每一行中选择一个元素。在下一行选择的元素和当前行所选元素最多相隔一列（即位于正下方或者沿对角线向左或者向右的第一个元素）。具体来说，位置 (row, col) 的下一个元素应当是 (row + 1, col - 1)、(row + 1, col) 或者 (row + 1, col + 1) 。
 *
 * 示例 1：
 *
 *
 *
 * 输入：matrix = [[2,1,3],[6,5,4],[7,8,9]]
 * 输出：13
 * 解释：如图所示，为和最小的两条下降路径
 * 示例 2：
 *

 *
 * 输入：matrix = [[-19,57],[-40,-5]]
 * 输出：-59
 * 解释：如图所示，为和最小的下降路径
 * 提示：
 *
 * n == matrix.length == matrix[i].length
 * 1 <= n <= 100
 * -100 <= matrix[i][j] <= 100
 * 👍 356
 * 👎 0
 * @author xianxing
 * @since 2024/9/3
 **/

public class LC_931 {
    public static void main(String[] args) {
        int[][] ints = {{-19,57},{-40,-5}};
        Solution solution = new Solution();
        System.out.println(solution.minFallingPathSum(ints));
    }
}

class Solution {
    public int minFallingPathSum(int[][] matrix) {
        int[] dp = new int[matrix[0].length];
        for (int i = 0; i < matrix.length; i++) {
            int[] copy = new int[matrix[0].length];
            for (int j = 0; j < matrix[0].length; j++) {
                int min = dp[j];
                if (j - 1 >= 0) {
                    min = Math.min(dp[j - 1], min);
                }
                if (j + 1 < matrix[0].length) {
                    min = Math.min(dp[j + 1], min);
                }
                copy[j] = matrix[i][j] + min;
            }
            dp = copy;
        }
        return Arrays.stream(dp).min().getAsInt();
    }
}
