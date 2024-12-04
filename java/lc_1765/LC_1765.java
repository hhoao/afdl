package lc_1765;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Queue;

/*
 *@author: 黄豪
 *@date : 2022年1月29日
 *@todo:1765. 地图中的最高点
给你一个大小为 m x n 的整数矩阵 isWater ，它代表了一个由 陆地 和 水域 单元格组成的地图。

如果 isWater[i][j] == 0 ，格子 (i, j) 是一个 陆地 格子。
如果 isWater[i][j] == 1 ，格子 (i, j) 是一个 水域 格子。
你需要按照如下规则给每个单元格安排高度：

每个格子的高度都必须是非负的。
如果一个格子是是 水域 ，那么它的高度必须为 0 。
任意相邻的格子高度差 至多 为 1 。当两个格子在正东、南、西、北方向上相互紧挨着，就称它们为相邻的格子。（也就是说它们有一条公共边）
找到一种安排高度的方案，使得矩阵中的最高高度值 最大 。

请你返回一个大小为 m x n 的整数矩阵 height ，其中 height[i][j] 是格子 (i, j) 的高度。如果有多种解法，请返回 任意一个 。

 

示例 1：



输入：isWater = [[0,1],[0,0]]
输出：[[1,0],[2,1]]
解释：上图展示了给各个格子安排的高度。
蓝色格子是水域格，绿色格子是陆地格。
示例 2：



输入：isWater = [[0,0,1],[1,0,0],[0,0,0]]
输出：[[1,1,0],[0,1,1],[1,2,2]]
解释：所有安排方案中，最高可行高度为 2 。
任意安排方案中，只要最高高度为 2 且符合上述规则的，都为可行方案。
*/
public class LC_1765 {

}
//多源广度优先搜索
class Solution {
    private static final int[][] dirs = {{1, 0}, {0, 1},{-1, 0}, {0, -1}};
    public int[][] highestPeak(int[][] isWater) {
        int n = isWater.length, m = isWater[0].length;
        Queue<int[]> queue= new ArrayDeque<>();
        int[][] ans = new int[n][m];
        for (int i = 0; i < n; i++){
            Arrays.fill(ans[i], -1);
        }
        for (int i = 0; i <n; i++){
            for (int j = 0; j < m; j++){
                if (isWater[i][j] == 1){
                    queue.offer(new int[]{i, j, 0});
                    ans[i][j] = 0;
                }
            }
        }
        while (!queue.isEmpty()){
            int[] src = queue.poll();
            
            for (int[] dir : dirs){
                int x = src[0] + dir[0];
                int y = src[1] + dir[1];
                if (x >= 0 && y >= 0 && x < n && y < m && ans[x][y] == -1){
                    ans[x][y] = src[2]+1;
                    queue.offer(new int[]{x, y, ans[x][y]});
                }
            }
        }
        return ans;
    }
}
//动态规划
class Solution1 {
    public int[][] highestPeak(int[][] isWater) {
        int n = isWater.length, m = isWater[0].length;
        int[][] f = new int[n][m];
        for (int i = 0; i < n; i++){
            Arrays.fill(f[i], 100000);
        }
        for (int i = 0; i < n; i++){
            for (int j = 0; j < m; j++){
                if (isWater[i][j] == 0){
                    if (i > 0){
                        f[i][j] = Math.min(f[i][j], f[i - 1][j] + 1);
                    }
                    if (j > 0){
                        f[i][j] = Math.min(f[i][j], f[i][j - 1] + 1);
                    }
                }else{
                    f[i][j] = 0;
                }
            }
        }
        for (int i = n - 1; i >= 0; i--){
            for (int j = m - 1; j >= 0; j--){
                if (isWater[i][j] == 0){
                    if (i < n - 1){
                        f[i][j] = Math.min(f[i][j], f[i+1][j] + 1);
                    }
                    if (j < m - 1){
                        f[i][j] = Math.min(f[i][j], f[i][j + 1] + 1);
                    }
                }else{
                    f[i][j] = 0;
                }
            }
        }
        return f;
    }
}
