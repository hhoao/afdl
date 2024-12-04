package lc_851;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Deque;
import java.util.List;

/*
 *@author: 黄豪
 *@date : 2021年12月15日
 *@todo:851. 喧闹和富有
有一组 n 个人作为实验对象，从 0 到 n - 1 编号，其中每个人都有不同数目的钱，以及不同程度的安静值（quietness）。为了方便起见，我们将编号为 x 的人简称为 "person x "。

给你一个数组 richer ，其中 richer[i] = [ai, bi] 表示 person ai 比 person bi 更有钱。另给你一个整数数组 quiet ，其中 quiet[i] 是 person i 的安静值。richer 中所给出的数据 逻辑自恰（也就是说，在 person x 比 person y 更有钱的同时，不会出现 person y 比 person x 更有钱的情况 ）。

现在，返回一个整数数组 answer 作为答案，其中 answer[x] = y 的前提是，在所有拥有的钱肯定不少于 person x 的人中，person y 是最安静的人（也就是安静值 quiet[y] 最小的人）。
*/
public class LC_851 {
	public static void main(String[] args) {
		new Solution().loudAndRich(new int[][]{{1,0},{2,1},{3,1},{3,7},{4,3},{5,3},{6,3}}, new int[] {3,2,5,4,6,1,7,0});
	}
}
//拓扑排序
class Solution1 {
    public int[] loudAndRich(int[][] richer, int[] quiet) {
        int n = quiet.length;
        int m = richer.length;
        int[] ret = new int[n];
        int[] map = new int[n];
        Deque<Integer> queue = new ArrayDeque<>();
        List<Integer>[] lists = new List[n];
        int[] parent = new int[n];
        for (int i = 0; i < n; i++) {
        	lists[i] = new ArrayList<>();
        }
        
        for (int i = 0; i < m; i++){
            map[richer[i][1]]++;
            lists[richer[i][0]].add(richer[i][1]);
        }
        for (int i = 0; i < n; i++){
            if (map[i] == 0){
                queue.offer(i);
            }
            parent[i] = i;
        }
        while(!queue.isEmpty()){
            int person = queue.poll();
            List<Integer> ps = lists[person];
            for (Integer k : ps){
                if (quiet[k] > quiet[person]){
                    quiet[k] = Math.min(quiet[k], quiet[person]);
                    parent[k] = parent[person];
                }
                map[k]--;
                if (map[k] == 0){
                    queue.offer(k);
                }
            }
            ret[person] = parent[person];
        }
        return ret;
    }
}
//深度优先搜索
class Solution {
    int[] vis;
    int[] quiet;
    public int[] loudAndRich(int[][] richer, int[] quiet) {
        int n = richer.length, m = quiet.length;
        List<Integer>[] g = new List[m];
        this.quiet = quiet;
        vis = new int[m];
        Arrays.fill(vis, -1);
        for (int i = 0; i < m; i++){
            g[i] = new ArrayList<>();
        }
        for (int i = 0; i < n; i++){
            g[richer[i][1]].add(richer[i][0]);
        }
        int[] ret = new int[m];
        for (int i = 0; i < m; i++){
            ret[i] = dfs(i, g)[0];
        }
        return ret;
    }
    public int[] dfs(Integer person, List<Integer>[] g){
        if (vis[person] != -1){
            return new int[]{vis[person], quiet[person]};
        }
        int parent = person;
        int q = quiet[parent];
        for (Integer k : g[person]){
            int[] p =  dfs(k, g);
            if (p[1] < q){
                parent = p[0];
                q = p[1];
            }
        }
        quiet[person] = q;
        vis[person] = parent;
        return new int[]{parent, q};
    }
}
