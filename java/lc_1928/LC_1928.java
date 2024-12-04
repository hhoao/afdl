package lc_1928;


import java.util.ArrayDeque;
import java.util.HashMap;

/**
 * LC_1928
 *
 * @author w
 * @since 2024/10/4
 **/

public class LC_1928 {
}

//题目: [1928] 规定时间内到达终点的最小花费
//时间: 2024-10-03 19:06:43
//
//一个国家有 n 个城市，城市编号为 0 到 n - 1 ，题目保证 所有城市 都由双向道路 连接在一起 。道路由二维整数数组 edges 表示，其中
//edges[i] = [xi, yi, timei] 表示城市 xi 和 yi 之间有一条双向道路，耗费时间为 timei 分钟。两个城市之间可能会有多条耗费时间不同
//的道路，但是不会有道路两头连接着同一座城市。
//
// 每次经过一个城市时，你需要付通行费。通行费用一个长度为 n 且下标从 0 开始的整数数组 passingFees 表示，其中 passingFees[j]
// 是你经过城市 j 需要支付的费用。
//
// 一开始，你在城市 0 ，你想要在 maxTime 分钟以内 （包含 maxTime 分钟）到达城市 n - 1 。旅行的 费用 为你经过的所有城市 通行费
//之和 （包括 起点和终点城市的通行费）。
//
// 给你 maxTime，edges 和 passingFees ，请你返回完成旅行的 最小费用 ，如果无法在 maxTime 分钟以内完成旅行，请你返回 -
//1 。
//
//
//
// 示例 1：
//
//
//
//
//输入：maxTime = 30, edges = [[0,1,10],[1,2,10],[2,5,10],[0,3,1],[3,4,10],[4,5,15]
//], passingFees = [5,1,2,20,20,3]
//输出：11
//解释：最优路径为 0 -> 1 -> 2 -> 5 ，总共需要耗费 30 分钟，需要支付 11 的通行费。
//
//
// 示例 2：
//
//
//
//
//输入：maxTime = 29, edges = [[0,1,10],[1,2,10],[2,5,10],[0,3,1],[3,4,10],[4,5,15]
//], passingFees = [5,1,2,20,20,3]
//输出：48
//解释：最优路径为 0 -> 3 -> 4 -> 5 ，总共需要耗费 26 分钟，需要支付 48 的通行费。
//你不能选择路径 0 -> 1 -> 2 -> 5 ，因为这条路径耗费的时间太长。
//
//
// 示例 3：
//
//
//输入：maxTime = 25, edges = [[0,1,10],[1,2,10],[2,5,10],[0,3,1],[3,4,10],[4,5,15]
//], passingFees = [5,1,2,20,20,3]
//输出：-1
//解释：无法在 25 分钟以内从城市 0 到达城市 5 。
//
//
//
//
// 提示：
//
//
// 1 <= maxTime <= 1000
// n == passingFees.length
// 2 <= n <= 1000
// n - 1 <= edges.length <= 1000
// 0 <= xi, yi <= n - 1
// 1 <= timei <= 1000
// 1 <= passingFees[j] <= 1000
// 图中两个节点之间可能有多条路径。
// 图中不含有自环。
//
//
// 👍 85 👎 0

// 动态规划
// 到达 n - 1 城市需要的最小费用等于  [你到达相连节点需要的时间] 小于 [maxTime - 相连接点到达 n - 1 城市需要的时间] 的所有计划 中的费用的最小值 + n - 1 城市需要的费用。
// 我们可以从前往后， 使用当前节点还可以花费多少时间来替代时间上面的是否可到达,
// 使用 Map<Integer, Integer> t 表示到达一个节点还可以花费的时间和到达这个节点所花费用的最小值, key 为还可以花费的时间，value 为使用费用最小值。

class Solution {
    public int minCost(int maxTime, int[][] edges, int[] passingFees) {
        int n = passingFees.length;
        HashMap[] cityLessTimeWithMinCost = new HashMap[n];
        int[][] cities = new int[n][n];
        for (int i = 0; i < n; i++) {
            cityLessTimeWithMinCost[i] = new HashMap();
            cities[i] = new int[n];
        }
        for (int[] edge : edges) {
            cities[edge[0]][edge[1]] = edge[2];
        }
        ArrayDeque<Integer> routes = new ArrayDeque<>();
        routes.addLast(0);
        return 0;
    }
}
