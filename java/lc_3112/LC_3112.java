package lc_3112;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Deque;
import java.util.PriorityQueue;

/**
 * LC_3112
 *
 * @author xianxing
 * @since 2024/7/18
 **/

//题目: [3112] 访问消失节点的最少时间
//时间: 2024-07-18 23:29:57
//
//给你一个二维数组 edges 表示一个 n 个点的无向图，其中 edges[i] = [ui, vi, lengthi] 表示节点 ui 和节点 vi 之间
//有一条需要 lengthi 单位时间通过的无向边。
//
// 同时给你一个数组 disappear ，其中 disappear[i] 表示节点 i 从图中消失的时间点，在那一刻及以后，你无法再访问这个节点。
//
// 注意，图有可能一开始是不连通的，两个节点之间也可能有多条边。
//
// 请你返回数组 answer ，answer[i] 表示从节点 0 到节点 i 需要的 最少 单位时间。如果从节点 0 出发 无法 到达节点 i ，那么
//answer[i] 为 -1 。
//
//
//
// 示例 1：
//
//
//
//
// 输入：n = 3, edges = [[0,1,2],[1,2,1],[0,2,4]], disappear = [1,1,5]
//
//
// 输出：[0,-1,4]
//
// 解释：
//
// 我们从节点 0 出发，目的是用最少的时间在其他节点消失之前到达它们。
//
//
// 对于节点 0 ，我们不需要任何时间，因为它就是我们的起点。
// 对于节点 1 ，我们需要至少 2 单位时间，通过 edges[0] 到达。但当我们到达的时候，它已经消失了，所以我们无法到达它。
// 对于节点 2 ，我们需要至少 4 单位时间，通过 edges[2] 到达。
//
//
// 示例 2：
//
//
//
//
// 输入：n = 3, edges = [[0,1,2],[1,2,1],[0,2,4]], disappear = [1,3,5]
//
//
// 输出：[0,2,3]
//
// 解释：
//
// 我们从节点 0 出发，目的是用最少的时间在其他节点消失之前到达它们。
//
//
// 对于节点 0 ，我们不需要任何时间，因为它就是我们的起点。
// 对于节点 1 ，我们需要至少 2 单位时间，通过 edges[0] 到达。
// 对于节点 2 ，我们需要至少 3 单位时间，通过 edges[0] 和 edges[1] 到达。
//
//
// 示例 3：
//
//
// 输入：n = 2, edges = [[0,1,1]], disappear = [1,1]
//
//
// 输出：[0,-1]
//
// 解释：
//
// 当我们到达节点 1 的时候，它恰好消失，所以我们无法到达节点 1 。
//
//
//
// 提示：
//
//
// 1 <= n <= 5 * 10⁴
// 0 <= edges.length <= 10⁵
// edges[i] == [ui, vi, lengthi]
// 0 <= ui, vi <= n - 1
// 1 <= lengthi <= 10⁵
// disappear.length == n
// 1 <= disappear[i] <= 10⁵
//
//
// 👍 40 👎 0
public class LC_3112 {
}

// dfs
// 开始先根据edges二维数组创建每个点到其他点的距离
// 创建一个visited数组用于记录该节点是否消失，它在
// dfs遍历的每一步进行记录，并且在每次到达一个节点
// 记录它的当前时间。
// dfs的队列的初始值为0
// dfs的终止条件为队列为空。
class Solution {
    public int[] minimumTime(int n, int[][] edges, int[] disappear) {
        ArrayList<int[]>[] points = new ArrayList[n];
        for (int i = 0; i < n; i++) {
            points[i] = new ArrayList<>();
        }
        for (int[] edge : edges) {
            points[edge[0]].add(new int[]{edge[1], edge[2]});
            points[edge[1]].add(new int[]{edge[1], edge[2]});
        }
        int[] ans = new int[n];
        Arrays.fill(ans, -1);
        boolean[] visited = new boolean[n];
        PriorityQueue<Integer[]> pointsDeque = new PriorityQueue<>(Comparator.comparing(a->a[1]));
        pointsDeque.offer(new Integer[]{0, 0});
        while (!pointsDeque.isEmpty()) {
            Integer[] start = pointsDeque.poll();
            if (visited[start[0]] || disappear[start[0]] <= start[1]) {
                continue;
            }
            visited[start[0]] = true;
            ans[start[0]] = start[1];
            ArrayList<int[]> nextPoints = points[start[0]];
            for (int[] nextPoint : nextPoints) {
                int takeTime = start[1] + nextPoint[1];
                pointsDeque.offer(new Integer[]{nextPoint[0], takeTime});
            }
        }
        return ans;
    }
}
