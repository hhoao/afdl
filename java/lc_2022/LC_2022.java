package lc_2022;

/*
 *@author: 黄豪
 *@date : 2022年1月1日
 *@todo:
*/
public class LC_2022 {

}
//模拟
class Solution {
    public int[][] construct2DArray(int[] original, int m, int n) {
        int len = original.length;
        if (len != m * n) return new int[][]{};
        int[][] ans = new int[m][n];
        
        for (int i = 0; i < m; i++){
            for (int j = 0; j < n; j++){
                ans[i][j] = original[i * n + j];
            }
        }
        return ans;
    }
}
//API模拟
class Solution1 {
    public int[][] construct2DArray(int[] original, int m, int n) {
        if (original.length != m * n) {
            return new int[0][];
        }
        int[][] ans = new int[m][n];
        for (int i = 0; i < original.length; i += n) {
            System.arraycopy(original, i, ans[i / n], 0, n);
        }
        return ans;
    }
}