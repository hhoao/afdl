package lc_547;

/*
 *@author: 黄豪
 *@date : 2021年12月13日
 *@todo:547. 省份数量
有 n 个城市，其中一些彼此相连，另一些没有相连。如果城市 a 与城市 b 直接相连，且城市 b 与城市 c 直接相连，那么城市 a 与城市 c 间接相连。

省份 是一组直接或间接相连的城市，组内不含其他没有相连的城市。

给你一个 n x n 的矩阵 isConnected ，其中 isConnected[i][j] = 1 表示第 i 个城市和第 j 个城市直接相连，而 isConnected[i][j] = 0 表示二者不直接相连。

返回矩阵中 省份 的数量。
*/
public class LC_547 {

}
//深度优先搜索
class Solution {
    boolean[] visited;
    public int findCircleNum(int[][] isConnected) {
        int ans = 0;
        int n = isConnected.length;
        visited = new boolean[n];
        for (int i = 0; i < n; i++){
            if (visited[i]) continue;
            visited[i] = true;
            for (int j = i+1; j < isConnected[i].length; j++){
                if (!visited[j] && isConnected[i][j] == 1){
                    visited[j] = true;
                    dfs(isConnected, j);
                }
            }
            ans++;
        }
        return ans;
    }
    public void dfs(int[][] isConnected, int city){
        int[] co = isConnected[city];
        for (int i = 0; i < co.length; i++){
            if (!visited[i] && co[i] == 1){
                visited[i] = true;
                dfs(isConnected, i);
            }
        }
    }
}
//并查集
class Solution1 {
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
            return x == parent[x] ? x : find(parent[x]);
        }
        void union(int x, int y){
            x = find(x);
            y = find(y);
            if (x == y){
                return;
            }
            if (size[x] >= size[y]){
                size[x] += size[y];
                parent[y] = x;
            }else{
                size[y] += size[x];
                parent[x] = y;
            }
            setCount--;
        }
        boolean connected(int x, int y){
            return find(x) == find(y);
        }
    }
    public int findCircleNum(int[][] isConnected) {
        int n = isConnected.length;
        UnionFind uf = new UnionFind(n);
        for (int i = 0; i < n; i++){
            for (int j = i + 1; j < isConnected[i].length; j++){
                if (isConnected[i][j] == 1){
                    uf.union(i, j);
                }
            }
        }
        return uf.setCount;
    }
}