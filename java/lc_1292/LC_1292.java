package lc_1292;

/*
 *@author: 黄豪
 *@date : 2022年1月17日
 *@todo:
*/
public class LC_1292 {
	public static void main(String[] args) {
		System.out.println(new Solution1().maxSideLength(new int[][] {{1,1,1,1},{1,0,0,0},{1,0,0,0},{1,0,0,0}}, 6));
	}
}
//暴力(超时)
class Solution {
    public int maxSideLength(int[][] mat, int threshold) {
        int n = mat.length, m = mat[0].length;
        int ans = 0;
        for (int k = 2; k <= Math.min(n, m); k++){
            for (int i = 0; i <= n - k; i++){
                for (int j = 0; j <= m - k; j++){
                    int sum = 0;
                    for (int h = 0; h < k; h++){
                        for (int p = 0; p < k; p++){
                            sum += mat[i + h][j +p];
                        }
                    }
                    if (sum <= threshold){
                        ans = k;
                        break;
                    }
                }
                if (ans == k){
                    break;
                }
            }
        }
        return ans;
    }
}
//前缀和
class Solution1 {
    public int maxSideLength(int[][] mat, int threshold) {
        int n = mat.length, m = mat[0].length;
        int ans = 0;
        for (int i = 0; i <= n - 2; i++){
            int[] columns = new int[m];
            for (int j = i; j < n && j - i < m; j++){
                for (int k = 0; k < m; k++){
                    columns[k] += mat[j][k];
                }
                if (j - i <= ans){
                    continue;
                }
                
                int sum = 0;
                for (int k = 0; k <= j - i; k++){
                    sum += columns[k];
                }
                if (sum <= threshold) {
                    ans = j - i;
                    continue;
                }
                for (int k = j - i + 1; k < m; k++){
                    sum -= columns[k - (j - i + 1)];
                    sum += columns[k];
                    if (sum <= threshold){
                        ans = j - i;
                        break;
                    }
                }
            }
        }
        return ans == 0 ? 0 : ans + 1;
    }
}
//官方枚举
class Solution2 {
    public int maxSideLength(int[][] mat, int threshold) {
        int n = mat.length, m = mat[0].length;
        int[][] rect = new int[n + 1][m + 1];
        int ans = 0;
        for (int i = 1; i <= n; i++){
            for (int j = 1; j <= m; j++){
                rect[i][j] = rect[i - 1][j] + rect[i][j - 1] - rect[i - 1][j - 1] + mat[i - 1][j - 1];
            }
        }
        int r = Math.min(m, n);
        for (int i = 1; i <= n; i++){
            for (int j = 1; j <= m; j++){
                for (int k = ans + 1; k <= r; k++){
                    if (i + k -1 <= n && j + k - 1 <= m && 
                    rect[i + k - 1][j + k - 1] - rect[i-1][j + k - 1] - rect[i + k - 1][j-1] + rect[i-1][j-1] <= threshold){
                        ans += 1;
                    }else{
                        break;
                    }
                }
            }
        }
        return ans;
    }
}