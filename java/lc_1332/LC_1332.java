package lc_1332;

/*
 *@author: 黄豪
 *@date : 2022年1月22日
 *@todo:1332. 删除回文子序列
给你一个字符串 s，它仅由字母 'a' 和 'b' 组成。每一次删除操作都可以从 s 中删除一个回文 子序列。

返回删除给定字符串中所有字符（字符串为空）的最小删除次数。

「子序列」定义：如果一个字符串可以通过删除原字符串某些字符而不改变原字符顺序得到，那么这个字符串就是原字符串的一个子序列。

「回文」定义：如果一个字符串向后和向前读是一致的，那么这个字符串就是一个回文。

 

示例 1：

输入：s = "ababa"
输出：1
解释：字符串本身就是回文序列，只需要删除一次。
示例 2：

输入：s = "abb"
输出：2
解释："abb" -> "bb" -> "". 
先删除回文子序列 "a"，然后再删除 "bb"。
*/
public class LC_1332 {

}
//题解
class Solution {
    public int removePalindromeSub(String s) {
        return new StringBuilder(s).reverse().toString().equals(s)?1:2;
    }
}
//理解错题目
/*
 * 这个应该是
 * 1332. 删除回文子序列
给你一个字符串 s组成。每一次删除操作都可以从 s 中删除一个回文 子序列。

返回删除给定字符串中所有字符（字符串为空）的最小删除次数。

「连续子序列]

「回文」定义：如果一个字符串向后和向前读是一致的，那么这个字符串就是一个回文。
 */
class Solution1 {
    public int removePalindromeSub(String s) {
        int n = s.length();
        int[][] dp = new int[n][n];
        boolean[][] param = new boolean[n][n];
        for (int i = 0; i < n; i++){
            param[i][i] = true;
        }
        int ans = Integer.MAX_VALUE;
        for (int i = 1; i < n; i++){
            for (int j = n - i - 1; j >= 0; j--){
                param[j][j + i] = s.charAt(j) == s.charAt(j + i);
                param[j+i][j] = param[j][j + i];
                if (param[j][j+i]){
                    param[j][j + i] = param[j + 1][j + i - 1];
                    param[j+i][j] = param[j][j + i];
                }
                if (param[j][j + i]){
                    dp[j][j + i] = 1;
                }else{
                    for (int k = 0; k < i; k++){
                        dp[j][j + i] = Math.min(dp[j][j+i], dp[j][j+k] + dp[j+k+1][j+i]);
                    }
                }
                if (i == n - 1){
                    ans = Math.min(dp[j][j+i], ans);
                }
            }
        }
        return ans;
    }
}
