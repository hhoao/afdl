package lc_764;

/*
 *@author: 黄豪
 *@date : 2021年9月17日
 *@todo:764. 最大加号标志
在一个大小在 (0, 0) 到 (N-1, N-1) 的2D网格 grid 中，除了在 mines 中给出的单元为 0，其他每个单元都是 1。网格中包含 1 的最大的轴对齐加号标志是多少阶？返回加号标志的阶数。如果未找到加号标志，则返回 0。

一个 k" 阶由 1 组成的“轴对称”加号标志具有中心网格  grid[x][y] = 1 ，以及4个从中心向上、向下、向左、向右延伸，长度为 k-1，由 1 组成的臂。下面给出 k" 阶“轴对称”加号标志的示例。注意，只有加号标志的所有网格要求为 1，别的网格可能为 0 也可能为 1。

 
*/
public class LC_764 {

}
//我的动态规划
class Solution {
    public int orderOfLargestPlusSign(int n, int[][] mines) {
        int[][][] dp = new int[n][n][2];
        for (int i = 0; i < n; i++){
            for (int j = 0; j < n; j++){
                dp[i][j][0] = 1;
                dp[i][j][1] = 1;
            }
        }
        for (int[] mine : mines){
            dp[mine[0]][mine[1]][0] = 0;
            dp[mine[0]][mine[1]][1] = 0;
        }
        for (int i = 1; i < n - 1; i++){
            for (int j = 1; j < n - 1; j++){
                if (dp[i][j][0] != 0){
                    dp[i][j][0] += dp[i - 1][j][0];
                    dp[i][j][1] += dp[i][j - 1][1];
                }
            }
        }
        int ans = mines.length == n*n ? 0 : 1;
        for (int i = n - 2; i > 0; i--){
            for (int j = n - 2; j > 0; j--){
                if (dp[i][j][0] != 0){
                    dp[i][j][0] = Math.min(dp[i + 1][j][0] + 1, dp[i][j][0]);
                    dp[i][j][1] = Math.min(dp[i][j+1][1] + 1, dp[i][j][1]);
                }
                ans = Math.max(Math.min(dp[i][j][0], dp[i][j][1]), ans);
            }
        }
        return ans;
    }
}
