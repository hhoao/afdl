package lc_2373;

import java.util.List;

/**
 * 2373. 矩阵中的局部最大值
 * 给你一个大小为 n x n 的整数矩阵 grid 。
 *
 * 生成一个大小为 (n - 2) x (n - 2) 的整数矩阵  maxLocal ，并满足：
 *
 * maxLocal[i][j] 等于 grid 中以 i + 1 行和 j + 1 列为中心的 3 x 3 矩阵中的 最大值 。
 * 换句话说，我们希望找出 grid 中每个 3 x 3 矩阵中的最大值。
 *
 * 返回生成的矩阵。
 *
 * @author hhoa
 * @since 2023/3/1
 **/

class Solution {
    int[][] dirs = {{-1, 0}, {1, 0}, {0, 1}, {1, 1}, {-1, 1}, {-1, -1}, {1, -1}, {0, -1}};
    public int[][] largestLocal(int[][] grid) {
        int n = grid.length;
        if (n < 3) {
            return new int[0][0];
        }
        int[][] ret = new int[n - 2][n - 2];
        for (int i = 1; i < n - 1; i++){
            for (int j = 1; j < n - 1; j++) {
                int max = grid[i][j];
                for (int[] dir : dirs) {
                    max = Math.max(max, grid[i - dir[0]][j - dir[1]]);
                }
                ret[i - 1][j - 1] = max;
            }
        }
        return ret;
    }
}
