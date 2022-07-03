package lc_1391;

import java.util.ArrayDeque;
import java.util.Queue;

/*
 *@author: 黄豪
 *@date : 2021年12月19日
 *@todo:1391. 检查网格中是否存在有效路径
给你一个 m x n 的网格 grid。网格里的每个单元都代表一条街道。grid[i][j] 的街道可以是：

1 表示连接左单元格和右单元格的街道。
2 表示连接上单元格和下单元格的街道。
3 表示连接左单元格和下单元格的街道。
4 表示连接右单元格和下单元格的街道。
5 表示连接左单元格和上单元格的街道。
6 表示连接右单元格和上单元格的街道。
*/
public class LC_1391 {
	public static void main(String[] args) {
		System.out.println(new Solution().hasValidPath(new int[][]{{2,4,3},{6,5,2}}));
	}
}
//队列
class Solution {
    public boolean hasValidPath(int[][] grid) {
        int n = grid.length, m = grid[0].length;
        boolean[][] vis = new boolean[n][m];
        int l = 0, r = 0;
        Queue<Integer[]> queue = new ArrayDeque<>();
        queue.offer(new Integer[]{0, 0, grid[0][0]});
        while(!queue.isEmpty()){
            Integer[] inf = queue.poll();
            int x = inf[0], y = inf[1], type= inf[2];
            vis[x][y] = true;
            if (x == n -1 && y == m - 1) return true;
            if (type == 1){
                if (y > 0 && !vis[x][y - 1] && (grid[x][y - 1] == 4 || grid[x][y - 1] == 6 || grid[x][y - 1] == 1)){
                    queue.offer(new Integer[]{x, y - 1, grid[x][y - 1]});
                }//向左
                if (y < m - 1 && !vis[x][y + 1] && (grid[x][y + 1] == 3 || grid[x][y + 1] == 5 || grid[x][y + 1] == 1)){
                    queue.offer(new Integer[]{x, y + 1, grid[x][y + 1]});
                }//向右
            }
            else if (type == 2){
                if (x > 0 && !vis[x - 1][y] && (grid[x - 1][y] == 3 || grid[x - 1][y] == 4 || grid[x - 1][y] == 2)){
                    queue.offer(new Integer[]{x - 1, y, grid[x - 1][y]});
                }//向上
                if (x < n - 1 && !vis[x+1][y] && (grid[x+1][y] == 2 || grid[x+1][y] == 6 || grid[x+1][y] == 5)){
                    queue.offer(new Integer[]{x+1, y, grid[x+1][y]});
                }//向下
            }
            else if (type == 3){
                if (y > 0 && !vis[x][y - 1] && (grid[x][y - 1] == 4 || grid[x][y - 1] == 6 || grid[x][y - 1] == 1)){
                    queue.offer(new Integer[]{x, y - 1, grid[x][y - 1]});
                }//向左
                if (x < n - 1 && !vis[x+1][y] && (grid[x+1][y] == 2 || grid[x+1][y] == 6 || grid[x+1][y] == 5)){
                    queue.offer(new Integer[]{x+1, y, grid[x+1][y]});
                }//向下
            }
            else if (type == 4){
                if (x < n - 1 && !vis[x + 1][y] && (grid[x][y + 1] == 3 || grid[x][y + 1] == 5 || grid[x][y + 1] == 1)){
                    queue.offer(new Integer[]{x+1, y, grid[x + 1][y]});
                }
                if (y < m - 1 && !vis[x][y + 1] && (grid[x+1][y] == 2 || grid[x+1][y] == 6 || grid[x+1][y] == 5)){
                    queue.offer(new Integer[]{x, y + 1, grid[x][y + 1]});
                }
            }
            else if (type == 5){
                if (x > 0 && !vis[x - 1][y] && (grid[x - 1][y] == 3 || grid[x - 1][y] == 4 || grid[x - 1][y] == 2)){
                    queue.offer(new Integer[]{x - 1, y, grid[x - 1][y]});
                }//向上
                if (y > 0 && !vis[x][y - 1] && (grid[x][y - 1] == 4 || grid[x][y - 1] == 6 || grid[x][y - 1] == 1)){
                    queue.offer(new Integer[]{x, y - 1, grid[x][y - 1]});
                }//向左
            }
            else if (type == 6){
                if (x > 0 && !vis[x - 1][y] && (grid[x - 1][y] == 3 || grid[x - 1][y] == 4 || grid[x - 1][y] == 2)){
                    queue.offer(new Integer[]{x - 1, y, grid[x - 1][y]});
                }//向上
                if (y < m - 1 && !vis[x][y + 1] && (grid[x][y + 1] == 3 || grid[x][y + 1] == 5 || grid[x][y + 1] == 1)){
                    queue.offer(new Integer[]{x, y + 1, grid[x][y + 1]});
                }
            }
        }
        return false;
    }
}