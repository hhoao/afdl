package lc_1738;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Map;

/**
 * LC_1738
 * //给你一个二维矩阵 matrix 和一个整数 k ，矩阵大小为 m x n 由非负整数组成。
 * //
 * // 矩阵中坐标 (a, b) 的 值 可由对所有满足 0 <= i <= a < m 且 0 <= j <= b < n 的元素 matrix[i][j]（下
 * //标从 0 开始计数）执行异或运算得到。
 * //
 * // 请你找出 matrix 的所有坐标中第 k 大的值（k 的值从 1 开始计数）。
 * //
 * //
 * //
 * // 示例 1：
 * //
 * // 输入：matrix = [[5,2],[1,6]], k = 1
 * //输出：7
 * //解释：坐标 (0,1) 的值是 5 XOR 2 = 7 ，为最大的值。
 * //
 * // 示例 2：
 * //
 * // 输入：matrix = [[5,2],[1,6]], k = 2
 * //输出：5
 * //解释：坐标 (0,0) 的值是 5 = 5 ，为第 2 大的值。
 * //
 * // 示例 3：
 * //
 * // 输入：matrix = [[5,2],[1,6]], k = 3
 * //输出：4
 * //解释：坐标 (1,0) 的值是 5 XOR 1 = 4 ，为第 3 大的值。
 * //
 * // 示例 4：
 * //
 * // 输入：matrix = [[5,2],[1,6]], k = 4
 * //输出：0
 * //解释：坐标 (1,1) 的值是 5 XOR 2 XOR 1 XOR 6 = 0 ，为第 4 大的值。
 * //
 * //
 * //
 * // 提示：
 * //
 * //
 * // m == matrix.length
 * // n == matrix[i].length
 * // 1 <= m, n <= 1000
 * // 0 <= matrix[i][j] <= 10⁶
 * // 1 <= k <= m * n
 * //
 * @author xianxing
 * @since 2024/5/26
 **/

public class LC_1738 {
}

class Solution {
    public int kthLargestValue(int[][] matrix, int k) {
        int m = matrix.length, n = matrix[0].length;
        int[][] pre = new int[m + 1][n + 1];
        List<Integer> results = new ArrayList<Integer>();
        for (int i = 1; i <= m; ++i) {
            for (int j = 1; j <= n; ++j) {
                pre[i][j] = pre[i - 1][j] ^ pre[i][j - 1] ^ pre[i - 1][j - 1] ^ matrix[i - 1][j - 1];
                results.add(pre[i][j]);
            }
        }
        results.sort((num1, num2) -> num2 - num1);
        return results.get(k - 1);
    }
}


class Solution1 {
    public int kthLargestValue(int[][] matrix, int k) {
        int m = matrix.length, n = matrix[0].length;
        int[][] copyMatrix = new int[m][n];
        ArrayList<Integer[]> points = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (i == 0) {
                    copyMatrix[j][i] = matrix[j][i];
                } else {
                    copyMatrix[j][i] = copyMatrix[j][i - 1] ^ matrix[j][i];
                }

                if (j != 0) {
                    copyMatrix[j][i] = matrix[j - 1][i] ^ matrix[j][i];
                }
                points.add(new Integer[]{j, i, copyMatrix[j][i]});
            }
        }
        Collections.sort(points, Comparator.comparing(a -> -a[2]));
        return points.get(k - 1)[2];
    }
}
