package lc_1139;


/**
 * LC_1139
 *
 * @author xianxing
 * @since 2024/8/27
 **/

public class LC_1139 {
}

/**
 * //题目: [1139] 最大的以 1 为边界的正方形
 * //时间: 2024-08-26 22:34:18
 * //
 * //给你一个由若干 0 和 1 组成的二维网格 grid，请你找出边界全部由 1 组成的最大 正方形 子网格，并返回该子网格中的元素数量。如果不存在，则返回 0
 * //。
 * //
 * //
 * //
 * // 示例 1：
 * //
 * // 输入：grid = [[1,1,1],[1,0,1],[1,1,1]]
 * //输出：9
 * //
 * //
 * // 示例 2：
 * //
 * // 输入：grid = [[1,1,0,0]]
 * //输出：1
 * //
 * //
 * //
 * //
 * // 提示：
 * //
 * //
 * // 1 <= grid.length <= 100
 * // 1 <= grid[0].length <= 100
 * // grid[i][j] 为 0 或 1
 * //
 * //
 * // 👍 224 👎 0
 */
class Solution {
    public int largest1BorderedSquare(int[][] grid) {
        int[][] up = new int[grid.length + 1][grid[0].length];
        int[][] left = new int[grid.length][grid[0].length + 1];
        int res = 0;
        for (int i = 0 ;i <= grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] != 0) {
                    up[i + 1][j] = up[i][j] + 1;
                    left[i][j + 1] = left[i][j] + 1;
                    int l = Math.min(up[i + 1][j], left[i][j + 1]);
                    while (l > res) {
                        if (up[i + 1][j - l - 1] >= l && left[i - l - 1][j + 1] >= l) {
                            res = l;
                            break;
                        }
                        l--;
                    }
                }
            }
        }
        return res;
    }
}
