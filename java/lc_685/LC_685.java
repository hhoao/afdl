package lc_685;

import com.sun.tools.javac.Main;

/*
 *@author: 黄豪
 *@date : 2021年12月14日
 *@todo:685. 冗余连接 II
在本问题中，有根树指满足以下条件的 有向 图。该树只有一个根节点，所有其他节点都是该根节点的后继。该树除了根节点之外的每一个节点都有且只有一个父节点，而根节点没有父节点。

输入一个有向图，该图由一个有着 n 个节点（节点值不重复，从 1 到 n）的树及一条附加的有向边构成。附加的边包含在 1 到 n 中的两个不同顶点间，这条附加的边不属于树中已存在的边。

结果图是一个以边组成的二维数组 edges 。 每个元素是一对 [ui, vi]，用以表示 有向 图中连接顶点 ui 和顶点 vi 的边，其中 ui 是 vi 的一个父节点。

返回一条能删除的边，使得剩下的图是有 n 个节点的有根树。若有多个答案，返回最后出现在给定二维数组的答案。

 
*/
public class LC_685 {
	public static void main(String[] args) {
		new Solution().findRedundantDirectedConnection(new int[][]{{2,1},{3,1},{4,2},{1,4}});
	}
}
//并查集(思路清晰+每一步都走到底)
class Solution {
    class UnionFind{
        private int[] parent;
        public UnionFind(int n){
            parent = new int[n];
            for (int i = 0; i < n; i++){
                parent[i] = i;
            }
        }
        public int find(int x){
            return x == parent[x] ? x : find(parent[x]);
        }
        public void union(int x, int y){
            parent[find(x)] = parent[find(y)];
        }
    }
    public int[] findRedundantDirectedConnection(int[][] edges) {
        int n = edges.length;
        UnionFind uf = new UnionFind(n + 1);
        int[] parent = new int[n + 2];
        int cycle = - 1;
        int conflict = -1;
        for (int i = 0; i < n; i++){
            int[] edge = edges[i];
            int node1 = edge[0], node2 = edge[1];
            if (uf.find(node2) != node2){
                conflict = i;
            }else{
                parent[node2] = node1;
                if (uf.find(node2) == uf.find(node1)){
                    cycle = i;
                }else{
                    uf.union(node2, node1);
                }
            }
        }
        if (conflict != -1){
            if (cycle == -1){
            	return new int[] {edges[conflict][0], edges[conflict][1]};
            }else{
            	return new int[] {parent[edges[conflict][1]], edges[conflict][1]};
            }
        }else{
        	return new int[] {edges[cycle][0], edges[cycle][1]};
        }
    }
}
