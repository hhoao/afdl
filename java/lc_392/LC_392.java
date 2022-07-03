package lc_392;

import java.util.Arrays;

/*
 *@author: 黄豪
 *@date : 2021年10月29日
 *@todo:392. 判断子序列
给定字符串 s 和 t ，判断 s 是否为 t 的子序列。

字符串的一个子序列是原始字符串删除一些（也可以不删除）字符而不改变剩余字符相对位置形成的新字符串。（例如，"ace"是"abcde"的一个子序列，而"aec"不是）。

进阶：

如果有大量输入的 S，称作 S1, S2, ... , Sk 其中 k >= 10亿，你需要依次检查它们是否为 T 的子序列。在这种情况下，你会怎样改变代码？

致谢：

特别感谢 @pbrother 添加此问题并且创建所有测试用例。
*/
public class LC_392 {

}
class Solution {
    public boolean isSubsequence(String s, String t) {
        int n = s.length(), m = t.length();
        boolean[][] dp = new boolean[n+1][m+1];
        Arrays.fill(dp[0], true);
        for (int i = 1; i <= n; i++){
            for (int j = 1; j <= m; j++){
                dp[i][j] = dp[i][j - 1];
                if (s.charAt(i - 1) == t.charAt(j - 1)){
                    dp[i][j] = dp[i - 1][j - 1];
                } 
            }
        }
        return dp[n][m] ;
    }
}
//优化
class Solution1 {
    public boolean isSubsequence(String s, String t) {
        int n = s.length(), m = t.length();
        int start = 0;
        for (int i = 1; i <= n; i++){
            boolean b = false;
            while (start < m){
                if (s.charAt(i - 1) == t.charAt(start)){
                    b = true;
                    start++;
                    break;
                }
                start++;
            }
            if ((start >= m && i < n) || !b) return false; 
        }
        return true;
    }
}
class Solution2 {
    public boolean isSubsequence(String s, String t) {
         int index = -1;
        for (char c : s.toCharArray()){
            index = t.indexOf(c, index+1);
            if (index == -1) return false;
        }
        return true;
    }
}