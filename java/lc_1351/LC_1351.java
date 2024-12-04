package lc_1351;

/**
 * LC_1351
 *
 * //给你一个 m * n 的矩阵 grid，矩阵中的元素无论是按行还是按列，都以非严格递减顺序排列。 请你统计并返回 grid 中 负数 的数目。
 * //
 * //
 * //
 * // 示例 1：
 * //
 * //
 * //输入：grid = [[4,3,2,-1],[3,2,1,-1],[1,1,-1,-2],[-1,-1,-2,-3]]
 * //输出：8
 * //解释：矩阵中共有 8 个负数。
 * //
 * //
 * // 示例 2：
 * //
 * //
 * //输入：grid = [[3,2],[1,0]]
 * //输出：0
 * //
 * //
 * //
 * //
 * // 提示：
 * //
 * //
 * // m == grid.length
 * // n == grid[i].length
 * // 1 <= m, n <= 100
 * // -100 <= grid[i][j] <= 100
 * //
 * //
 * //
 * //
 * // 进阶：你可以设计一个时间复杂度为 O(n + m) 的解决方案吗？
 * //
 * // Related Topics 数组 二分查找 矩阵 👍 174 👎 0
 *
 * @author xianxing
 * @since 2024/5/27
 **/

public class LC_1351 {
}

class Solution {
    public int countNegatives(int[][] grid) {
        int res = 0;
        for (int i = 0, j = grid[0].length - 1; i < grid.length; i++) {
            while (j > -1 && grid[i][j] < 0) {
                j--;
            }
            res += grid[0].length - j - 1;
        }
        return res;
    }
}
