package lc_542;

import java.util.ArrayDeque;
import java.util.Deque;

/*
 *@author: 黄豪
 *@date : 2021年11月16日
 *@todo:
*/
public class LC_542 {

}
//最短路径
class Solution {
    static int[][] dirs = {{1, 0}, {0, 1}, {-1, 0}, {0, -1}};
    public int[][] updateMatrix(int[][] mat) {
        int n = mat.length, m = mat[0].length;
        boolean[][] visited = new boolean[n][m];
        int[][] ans = new int[n][m];
        Deque<Integer[]> queue = new ArrayDeque<>();
        for (int i = 0; i < n; i++){
            for (int j = 0; j < m; j++){
                if (mat[i][j] == 0){
                    queue.offer(new Integer[]{i, j});
                    visited[i][j] = true;
                }
            }
        }
        while(!queue.isEmpty()){
            Integer[] pos = queue.poll();
            int x = pos[0], y = pos[1];
            for (int[] dir : dirs){
                int xi = x + dir[0], yi = y + dir[1];
                if (xi >= 0 && xi < n && yi >= 0 && yi < m && !visited[xi][yi]){
                    ans[xi][yi] = ans[x][y] + 1;
                    queue.offer(new Integer[]{xi, yi});
                    visited[xi][yi] = true;
                }
            }
        }
        return ans;
    }
}
