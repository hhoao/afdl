package lc_684;

/*
 *@author: 黄豪
 *@date : 2021年12月13日
 *@todo:684. 冗余连接
树可以看成是一个连通且 无环 的 无向 图。

给定往一棵 n 个节点 (节点值 1～n) 的树中添加一条边后的图。添加的边的两个顶点包含在 1 到 n 中间，且这条附加的边不属于树中已存在的边。图的信息记录于长度为 n 的二维数组 edges ，edges[i] = [ai, bi] 表示图中在 ai 和 bi 之间存在一条边。

请找出一条可以删去的边，删除后可使得剩余部分是一个有着 n 个节点的树。如果有多个答案，则返回数组 edges 中最后出现的边。
*/
public class LC_684 {

}
//并查集
class Solution {
    class UnionFind{
        int[] parent;
        int[] size;
        int n;
        int setCount;
        UnionFind(int n){
            parent = new int[n];
            size = new int[n];
            this.n = n;
            this.setCount = n;
            for (int i = 0; i < n; i++){
                parent[i] = i;
                size[i] = 1;
            }
        }
        int find(int x){
            return parent[x] == x ? x : find(parent[x]);
        }
        boolean union(int x, int y){
            x = find(x);
            y = find(y);
            if (x == y) return false;
            if (size[x] >= size[y]){
                size[y] += size[x];
                parent[y] = x;
            }else{
                size[x] += size[y];
                parent[x] = y;
            }
            setCount--;
            return true;
        }
        boolean isConnected(int x, int y){
            return find(x) == find(y);
        }
    }
    public int[] findRedundantConnection(int[][] edges) {
        int n = edges.length;
        int[] ans = new int[2];
        UnionFind unionFind = new UnionFind(1001);
        for (int i = 0; i < n; i++){
            if (!unionFind.union(edges[i][0], edges[i][1])){
                ans[0] = edges[i][0];
                ans[1] = edges[i][1];
                break;
            }
        }
        return ans;
    }
}
