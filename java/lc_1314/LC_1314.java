package lc_1314;

/*
 *@author: 黄豪
 *@date : 2022年1月17日
 *@todo:1314. 矩阵区域和
给你一个 m x n 的矩阵 mat 和一个整数 k ，请你返回一个矩阵 answer ，其中每个 answer[i][j] 是所有满足下述条件的元素 mat[r][c] 的和： 

i - k <= r <= i + k,
j - k <= c <= j + k 且
(r, c) 在矩阵内。
 

示例 1：

输入：mat = [[1,2,3],[4,5,6],[7,8,9]], k = 1
输出：[[12,21,16],[27,45,33],[24,39,28]]
示例 2：

输入：mat = [[1,2,3],[4,5,6],[7,8,9]], k = 2
输出：[[45,45,45],[45,45,45],[45,45,45]]
*/
public class LC_1314 {

}
//一维前缀和
class Solution {
    public int[][] matrixBlockSum(int[][] mat, int k) {
        int n = mat.length, m = mat[0].length;
        int[][] pre = new int[n][m];
        for (int i = 0; i < n; i++){
            pre[i][0] = mat[i][0];
            for (int j = 1; j < m; j++){
                pre[i][j] = pre[i][j - 1] + mat[i][j];
            }
        }
        int[][] ans = new int[n][m];
        for (int i = 0; i < n; i++){
            for (int j = 0; j < m; j++){
                for (int t = Math.max(i - k, 0); t < Math.min(i + k + 1, n); t++){
                    if (j + k < m)
                        ans[i][j] += j - k - 1 >= 0 ? pre[t][j + k] - pre[t][j - k - 1] : pre[t][j + k];
                    else
                        ans[i][j] += j - k - 1 >= 0 ? pre[t][m - 1] - pre[t][j - k - 1] : pre[t][m - 1];
                }
            }
        }
        return ans;
    }
}
//二维前缀和
class Solution1 {
    public int[][] matrixBlockSum(int[][] mat, int k) {
        int n = mat.length, m = mat[0].length;
        int[][] pre = new int[n+1][m+1];
        for (int i = 1; i <= n; i++){
            for (int j = 1; j <= m; j++){
                pre[i][j] = pre[i][j - 1] + pre[i - 1][j] - pre[i - 1][j - 1] + mat[i-1][j-1];
            }
        }
        int[][] ans = new int[n][m];
        for (int i = 0; i < n; i++){
            for (int j = 0; j < m; j++){
                int r_min = (i - k < 0 ? 0 : i - k) + 1;
                int r_max = (i + k >= n ? n - 1 : i + k) + 1;
                int c_min = (j - k < 0 ? 0 : j - k) + 1;
                int c_max = (j + k >= m ? m - 1 : j + k) + 1;
                if (r_min == 1){
                    if (c_min == 1){
                        ans[i][j] = pre[r_max][c_max];
                    }else{
                        ans[i][j] = pre[r_max][c_max] - pre[r_max][c_min - 1];
                    }
                }else{
                    if (c_min == 1){
                        ans[i][j] = pre[r_max][c_max] - pre[r_min - 1][c_max];
                    }else{
                        ans[i][j] = pre[r_max][c_max] - pre[r_min - 1][c_max] - pre[r_max][c_min - 1] + pre[r_min - 1][c_min - 1];
                    }
                }
            }
        }
        return ans;
    }
}