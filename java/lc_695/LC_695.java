package lc_695;

/*
 *@author: 黄豪
 *@date : 2021年12月14日
 *@todo:695. 岛屿的最大面积
给你一个大小为 m x n 的二进制矩阵 grid 。

岛屿 是由一些相邻的 1 (代表土地) 构成的组合，这里的「相邻」要求两个 1 必须在 水平或者竖直的四个方向上 相邻。你可以假设 grid 的四个边缘都被 0（代表水）包围着。

岛屿的面积是岛上值为 1 的单元格的数目。

计算并返回 grid 中最大的岛屿面积。如果没有岛屿，则返回面积为 0 。
*/
public class LC_695 {

}
//深度优先搜索
class Solution {
    private int[][] dirs = new int[][]{{1, 0}, {-1, 0}, {0, -1}, {0, 1}};
    boolean[][] vis;
    private int dfs(int[][] grid, int r, int c){
        vis[r][c] = true;
        int count = 1;
        for (int[] dir : dirs){
            int dr = r + dir[0];
            int dc = c + dir[1];
            if (dr >= 0 && dr < grid.length && dc >= 0 && dc < grid[0].length &&
                !vis[dr][dc] && grid[dr][dc] == 1){
                    count += dfs(grid, dr, dc);
            }
        }
        return count;
    }
    public int maxAreaOfIsland(int[][] grid) {
        int ans = 0;
        int r = grid.length, c = grid[0].length;
        vis = new boolean[r][c];
        for (int i = 0; i < r; i++){
            for (int j = 0; j < c; j++){
                if (!vis[i][j] && grid[i][j] == 1)
                    ans = Math.max(ans, dfs(grid, i, j));
            }
        }
        return ans;
    }
}
//并查集
class Solution1 {
    class UnionFind{
        int[] parent;
        int[] size;
        public UnionFind(int n){
            parent = new int[n];
            size = new int[n];
            for (int i = 0; i < n; i++){
                parent[i] = i;
                size[i] = 1;
            }
        }
        public int find(int x){
            return x == parent[x] ? x : find(parent[x]);
        }
        public int union(int x, int y){
            x = find(x);
            y = find(y);
            if (x == y){
                return 0;
            }
            if (size[x] >= size[y]){
                parent[y] = x;
                size[x] += size[y];
                return size[x];
            }else{
                parent[x] = y;
                size[y] += size[x];
                return size[y];
            }
        }
    }
    public int maxAreaOfIsland(int[][] grid) {
        int ans = 0;
        int r = grid.length, c = grid[0].length;
        UnionFind uf = new UnionFind(r * c);
        for (int i = 0; i < r; i++){
            for (int j = 0; j < c; j++){
                if (grid[i][j] == 1){
                    int id = i * c + j;
                    if (i > 0 && grid[i - 1][j] == 1){
                        uf.union(id - c, id);
                    }
                    if (j > 0 && grid[i][j - 1] == 1){
                        uf.union(id - 1, id);
                    }
                    ans = Math.max(ans, uf.size[uf.find(id)]);
                }
            }
        }
        return ans;
    }
}