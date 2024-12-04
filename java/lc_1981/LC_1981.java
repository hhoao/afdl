package lc_1981;


import java.util.Comparator;
import java.util.HashSet;
import java.util.Optional;
import java.util.TreeSet;

/**
 * LC_1981
 *
 * @author w
 * @since 2024/9/15
 **/
// 给你一个大小为 m x n 的整数矩阵 mat 和一个整数 target 。
//
//从矩阵的 每一行 中选择一个整数，你的目标是 最小化 所有选中元素之 和 与目标值 target 的 绝对差 。
//
//返回 最小的绝对差 。
//
//a 和 b 两数字的 绝对差 是 a - b 的绝对值。
//
//示例 1：
//
//
//
//输入：mat = [[1,2,3],[4,5,6],[7,8,9]], target = 13
//输出：0
//解释：一种可能的最优选择方案是：
//- 第一行选出 1
//- 第二行选出 5
//- 第三行选出 7
//所选元素的和是 13 ，等于目标值，所以绝对差是 0 。
//示例 2：
//
//
//
//输入：mat = [[1],[2],[3]], target = 100
//输出：94
//解释：唯一一种选择方案是：
//- 第一行选出 1
//- 第二行选出 2
//- 第三行选出 3
//所选元素的和是 6 ，绝对差是 94 。
//示例 3：
//
//
//
//输入：mat = [[1,2,9,8,7]], target = 6
//输出：1
//解释：最优的选择方案是选出第一行的 7 。
//绝对差是 1 。
//提示：
//
//m == mat.length
//n == mat[i].length
//1 <= m, n <= 70
//1 <= mat[i][j] <= 70
//1 <= target <= 800
//👍 74
//👎 0
public class LC_1981 {
    public static void main(String[] args) {
        System.out.println(Math.abs(Integer.MIN_VALUE));
    }
}


class Solution {
    public int minimizeTheDifference(int[][] mat, int target) {
        HashSet<Integer> gaps = new HashSet<>();
        gaps.add(target);
        for (int i = 0; i < mat.length; i++) {
            HashSet<Integer> copy = new HashSet<>();
            HashSet<Integer> matSet = new HashSet<>();
            for (int j = 0; j < mat[i].length; j++) {
                matSet.add(mat[i][j]);
            }
            int newMaxGap = Integer.MIN_VALUE;
            for (Integer integer : matSet) {
                int lessZeroMaxGap = Integer.MIN_VALUE;
                for (Integer gap : gaps) {
                    int newGap = gap - integer;
                    // 如果最大的 gap < 0，那么只需要在 set 里面存入最大的那个 gap
                    if (newGap < 0) {
                        lessZeroMaxGap = Math.max(newGap, lessZeroMaxGap);
                    } else {
                        copy.add(newGap);
                    }
                    newMaxGap = Math.max(newMaxGap, newGap);
                }
                if (lessZeroMaxGap != Integer.MIN_VALUE) {
                    copy.add(lessZeroMaxGap);
                }
            }
            gaps = copy;
        }
        int res = Integer.MAX_VALUE;
        for (Integer gap : gaps) {
            res = Math.min(Math.abs(gap), res);
        }
        return res;
    }
}
