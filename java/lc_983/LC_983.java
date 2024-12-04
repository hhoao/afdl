package lc_983;


import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * LC_983
 *
 * @author w
 * @since 2024/10/1
 **/

public class LC_983 {
    public static void main(String[] args) {
        Solution solution = new Solution();
        int i1 = solution.mincostTickets(new int[]{1, 4, 6, 7, 8, 20},
            new int[]{2, 7, 15});
        System.out.println(i1);
    }
}

// 动态规划
// 可以把当前天需要花的最少钱分为四状态，不花钱，买一天的票， 买七天的票，买 30 天的票
// 不花钱的状态转移方程为：Math.min(前三十天买 30 天的票的钱, 前七天买七天票的钱， 前一天买一天票的钱）
// 买票的钱为：昨天不买票需要多少钱 + 买各自天数的票钱
class Solution {
    public int mincostTickets(int[] days, int[] costs) {
        int n = days.length;
        int[][] dp = new int[n + 1][4];
        for (int i = 1; i <= n; i++) {
            Arrays.fill(dp[i], 10000000);
        }
        int l1 = 1, l2 = 1;
        for (int i = 1; i <= n; i++) {
            int day = days[i - 1];
            while (day - days[l1] >= 7) {
                l1++;
            }
            while (day - days[l2] >= 30) {
                l2++;
            }
            dp[i][0] = Math.min(dp[l1][2], dp[l2][3]);
            int min = Math.min(dp[i - 1][0], dp[i - 1][1]);
            for (int j = 0; j < costs.length; j++) {
                dp[i][j + 1] = min + costs[j];
            }
        }
        return Math.min(Math.min(dp[n][0], dp[n][1]), Math.min(dp[n][2], dp[n][3]));
    }
}

// 记忆化搜索
class Solution1 {
    int[] costs;
    Integer[] memo;
    Set<Integer> dayset;

    public int mincostTickets(int[] days, int[] costs) {
        this.costs = costs;
        memo = new Integer[366];
        dayset = new HashSet();
        for (int d: days) {
            dayset.add(d);
        }
        return dp(1);
    }

    public int dp(int i) {
        if (i > 365) {
            return 0;
        }
        if (memo[i] != null) {
            return memo[i];
        }
        if (dayset.contains(i)) {
            memo[i] = Math.min(Math.min(dp(i + 1) + costs[0], dp(i + 7) + costs[1]), dp(i + 30) + costs[2]);
        } else {
            memo[i] = dp(i + 1);
        }
        return memo[i];
    }
}
