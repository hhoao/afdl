package lc_1824;


import java.util.Arrays;

/**
 * LC_1824
 *
 * @author w
 * @since 2024/9/8
 **/
//给你一个长度为 n 的 3 跑道道路 ，它总共包含 n + 1 个 点 ，编号为 0 到 n 。一只青蛙从 0 号点第二条跑道 出发 ，它想要跳到点 n 处。然而道路上可能有一些障碍。
//
//给你一个长度为 n + 1 的数组 obstacles ，其中 obstacles[i] （取值范围从 0 到 3）表示在点 i 处的 obstacles[i] 跑道上有一个障碍。如果 obstacles[i] == 0 ，那么点 i 处没有障碍。任何一个点的三条跑道中 最多有一个 障碍。
//
//比方说，如果 obstacles[2] == 1 ，那么说明在点 2 处跑道 1 有障碍。
//这只青蛙从点 i 跳到点 i + 1 且跑道不变的前提是点 i + 1 的同一跑道上没有障碍。为了躲避障碍，这只青蛙也可以在 同一个 点处 侧跳 到 另外一条 跑道（这两条跑道可以不相邻），但前提是跳过去的跑道该点处没有障碍。
//
//比方说，这只青蛙可以从点 3 处的跑道 3 跳到点 3 处的跑道 1 。
//这只青蛙从点 0 处跑道 2 出发，并想到达点 n 处的 任一跑道 ，请你返回 最少侧跳次数 。
//
//注意：点 0 处和点 n 处的任一跑道都不会有障碍。
//
//示例 1：
//
//
//输入：obstacles = [0,1,2,3,0]
//输出：2
//解释：最优方案如上图箭头所示。总共有 2 次侧跳（红色箭头）。
//注意，这只青蛙只有当侧跳时才可以跳过障碍（如上图点 2 处所示）。
//示例 2：
//
//
//输入：obstacles = [0,1,1,3,3,0]
//输出：0
//解释：跑道 2 没有任何障碍，所以不需要任何侧跳。
//示例 3：
//
//
//输入：obstacles = [0,2,1,0,3,0]
//输出：2
//解释：最优方案如上图所示。总共有 2 次侧跳。
//提示：
//
//obstacles.length == n + 1
//1 <= n <= 5 * 105
//0 <= obstacles[i] <= 3
//obstacles[0] == obstacles[n] == 0
//👍 124
//👎 0
public class LC_1824 {
}

// 当前跑道指定编号的最少侧跳数 =
// 如果指定编号旁边点跑道不是障碍
// Math.min(指定编号旁边点跑道最少侧跳数加跑道距离, 当前跑道指定编号的前一个编号的最少侧跳数)。
// 如果指定编号旁边点跑道是障碍, 但是隔一个跑道不是障碍
// Math.min(指定编号隔一个跑道最少侧跳数加一, 当前跑道指定编号的前一个编号的最少侧跳数)。
// 如果前一个当前跑道的前一个编号为障碍，那么不需要算当前跑道指定编号的前一个编号的最少侧跳数
// 因为只和前一个编号和旁边跑到有关，所以可以优化空间
class Solution {
    public int minSideJumps(int[] obstacles) {
        int[] dp = new int[3];
        dp[0] = 1;
        dp[2] = 1;
        for (int obstacle : obstacles) {
            int[] tmp = new int[3];
            for (int j = 0; j < 3; j++) {
                tmp[j] = obstacle != j + 1 ? dp[j] : Integer.MAX_VALUE;
            }

            for (int j = 0; j < 3; j++) {
                if (obstacle == j + 1) {
                    continue;
                }
                int i1 = (j + 1) % 3;
                if (obstacle != i1 + 1 && tmp[i1] != Integer.MAX_VALUE) {
                    tmp[j] = Math.min(tmp[i1] + 1, tmp[j]);
                }
                int i2 = (j + 2) % 3;
                if (obstacle != i2 + 1 && tmp[i2] != Integer.MAX_VALUE) {
                    tmp[j] = Math.min(tmp[i2] + 1, tmp[j]);
                }
            }
            dp = tmp;
        }
        int ans = Integer.MAX_VALUE;
        for (int j : dp) {
            ans = Math.min(j, ans);
        }
        return ans;
    }
}


// 官方
class Solution1 {
    static final int INF = 0x3fffffff;

    public int minSideJumps(int[] obstacles) {
        int n = obstacles.length - 1;
        int[] d = new int[3];
        Arrays.fill(d, 1);
        d[1] = 0;
        for (int i = 1; i <= n; i++) {
            int minCnt = INF;
            for (int j = 0; j < 3; j++) {
                if (j == obstacles[i] - 1) {
                    d[j] = INF;
                } else {
                    minCnt = Math.min(minCnt, d[j]);
                }
            }
            for (int j = 0; j < 3; j++) {
                if (j == obstacles[i] - 1) {
                    continue;
                }
                d[j] = Math.min(d[j], minCnt + 1);
            }
        }
        return Math.min(Math.min(d[0], d[1]), d[2]);
    }
}

