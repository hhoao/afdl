package lc_712;

import java.util.Arrays;

/*
 *@author: 黄豪
 *@date : 2021年9月19日
 *@todo:
 *712. 两个字符串的最小ASCII删除和
给定两个字符串s1, s2，找到使两个字符串相等所需删除字符的ASCII值的最小和。
*/
public class LC_712 {
	public static void main(String[] args) {
		Solution s = new Solution();
		System.out.println(s.minimumDeleteSum("ccaccjp", "fwosarcwge"));
	}
}
//我的动态规划
class Solution {
    public int minimumDeleteSum(String s1, String s2) {
        int total = 0;
        int n = s1.length(), m = s2.length();
        for (int i = 0; i < n; i++){
            total += s1.charAt(i);
        }
        for (int i = 0; i < m; i++){
            total += s2.charAt(i);
        }
        int[][] dp = new int[n+1][m+1];
        for (int i = 1; i <= n; i++){
            for (int j = 1; j <= m; j++){
                dp[i][j] = Math.max(dp[i][j - 1], dp[i - 1][j]);
                if (s1.charAt(i - 1) == s2.charAt(j - 1))
                    dp[i][j] = Math.max(dp[i][j], dp[i - 1][j - 1] + s1.charAt(i - 1) * 2);
            }
        }
        return total - dp[n][m];
    }
}
