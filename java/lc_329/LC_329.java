package lc_329;

/*
 *@author: 黄豪
 *@date : 2021年10月26日
 *@todo:329. 矩阵中的最长递增路径
给定一个 m x n 整数矩阵 matrix ，找出其中 最长递增路径 的长度。

对于每个单元格，你可以往上，下，左，右四个方向移动。 你 不能 在 对角线 方向上移动或移动到 边界外（即不允许环绕）。
*/
public class LC_329 {

}
//记忆化搜索
class Solution {
    int[][] dirs = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
    int rows, columns;
    public int longestIncreasingPath(int[][] matrix) {
        rows = matrix.length;
        columns = matrix[0].length;
        int[][] memo = new int[rows][columns];
        int ans = 1;
        for (int i = 0; i < rows; i++){
            for (int j = 0; j < columns; j++){
                ans = Math.max(ans, dfs(matrix, i, j, memo));
            }
        }
        return ans;
    }
    public int dfs(int[][] matrix, int row, int column, int[][] memo){
        if (memo[row][column] != 0){
            return memo[row][column];
        }
        memo[row][column]++;
        for (int[] dir : dirs){
            int newRow = row + dir[0], newColumn = column + dir[1];
            if (newRow >= 0 && newColumn >= 0 && newRow < rows && newColumn < columns && matrix[newRow][newColumn] > matrix[row][column])
            memo[row][column] = Math.max(memo[row][column], dfs(matrix, newRow, newColumn, memo)+1);
        }
        return memo[row][column];
    }
}