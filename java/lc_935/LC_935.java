package lc_935;


import java.util.Arrays;

/**
 * LC_935
 *
 * @author w
 * @since 2024/9/16
 **/

public class LC_935 {
}
//题目: [935] 骑士拨号器
//时间: 2024-09-16 09:10:04
//
//象棋骑士有一个独特的移动方式，它可以垂直移动两个方格，水平移动一个方格，或者水平移动两个方格，垂直移动一个方格(两者都形成一个 L 的形状)。
//
// 象棋骑士可能的移动方式如下图所示:
//
//
//
// 我们有一个象棋骑士和一个电话垫，如下所示，骑士只能站在一个数字单元格上(即蓝色单元格)。
//
//
//
// 给定一个整数 n，返回我们可以拨多少个长度为 n 的不同电话号码。
//
// 你可以将骑士放置在任何数字单元格上，然后你应该执行 n - 1 次移动来获得长度为 n 的号码。所有的跳跃应该是有效的骑士跳跃。
//
// 因为答案可能很大，所以输出答案模 10⁹ + 7.
//
//
//
//
//
//
// 示例 1：
//
//
//输入：n = 1
//输出：10
//解释：我们需要拨一个长度为1的数字，所以把骑士放在10个单元格中的任何一个数字单元格上都能满足条件。
//
//
// 示例 2：
//
//
//输入：n = 2
//输出：20
//解释：我们可以拨打的所有有效号码为[04, 06, 16, 18, 27, 29, 34, 38, 40, 43, 49, 60, 61, 67, 72,
//76, 81, 83, 92, 94]
//
//
// 示例 3：
//
//
//输入：n = 3131
//输出：136006598
//解释：注意取模
//
//
//
//
// 提示：
//
//
// 1 <= n <= 5000
//
//
// 👍 150 👎 0


// 每一次拨打长度为 n 的不同的电话号码数都和上一次有关， 可以使用动态规划，
// 但是我们不可能把上一次电话号码都缓存起来，因为太多了，我们可以缓存他们的
// 最后一个数字，该数字用数量标记，每次拨打下一个电话的时候加上当前数字
// 可以跳的选择 * 数量。
class Solution {
    int[][] jumpOptions = {{4, 6}, {6, 8}, {7, 9}, {4, 8}, {3, 9, 0}, {}, {1, 7, 0}, {2, 6}, {1, 3}, {2, 4}};
    long MOD = (long) (Math.pow(10, 9) + 7);

    public int knightDialer(int n) {
        int[] starts = {2, 5, 8, 0};
        int[] specialStarts = {1, 4, 7};
        long ans = 0;
        for (int start : starts) {
            ans = (ans + getOptions(start, n)) % MOD;
        }
        for (int specialStart : specialStarts) {
            ans = (ans + getOptions(specialStart, n) * 2) % MOD;
        }
        return (int) ((int) ans % MOD);
    }

    long getOptions(int start, int n) {
        long[] dp = new long[10];
        dp[start] = 1;
        for (int i = 0; i < n - 1; i++) {
            long[] copy = new long[10];
            for (int j = 0; j <= 9; j++) {
                int[] jumpOption = jumpOptions[j];
                for (int location : jumpOption) {
                    copy[location] = (copy[location] + dp[j]) % MOD;
                }
            }
            dp = copy;
        }
        long ret = 0;
        for (long l : dp) {
            ret = (ret + l) % MOD;
        }
        return ret;
    }
}
