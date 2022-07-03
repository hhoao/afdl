package lc_647;

/*
 *@author: 黄豪
 *@date : 2021年9月28日
 *@todo:647. 回文子串
给你一个字符串 s ，请你统计并返回这个字符串中 回文子串 的数目。

回文字符串 是正着读和倒过来读一样的字符串。

子字符串 是字符串中的由连续字符组成的一个序列。

具有不同开始位置或结束位置的子串，即使是由相同的字符组成，也会被视作不同的子串。
*/
public class LC_647 {

}
//我的dp
class Solution {
    public int countSubstrings(String s) {
        int n = s.length();
        boolean[][] dp = new boolean[n][n];
        int count = n;
        for (int i = 0; i < n; i++){
            dp[i][i] = true;
        }
        for (int i = 0; i < n; i++){
            for (int j = 0; j < n; j++){
                if (s.charAt(i) == s.charAt(j) && i !=  j && !dp[i][j]){
                    if ((i < n - 1 && j > 1 && dp[i + 1][j - 1]) || (i > 1 && j < n - 1) && dp[i - 1][j + 1]|| Math.abs(i - j) == 1){
                        count++;
                        dp[i][j] = true;
                        dp[j][i] = true;
                    }
                }
            }
        }
        return count;
    }
}
//中心拓展
class Solution1 {
    public int countSubstrings(String s) {
        int n = s.length(), ans = 0;
        for (int i = 0; i < 2 * n - 1; ++i) {
            int l = i / 2, r = i / 2 + i % 2;
            while (l >= 0 && r < n && s.charAt(l) == s.charAt(r)) {
                --l;
                ++r;
                ++ans;
            }
        }
        return ans;
    }
}
//Manacher
class Solution2 {
    public int countSubstrings(String s) {
        int n = s.length();
        StringBuffer t = new StringBuffer("$#");
        for (int i = 0; i < n; ++i) {
            t.append(s.charAt(i));
            t.append('#');
        }
        n = t.length();
        t.append('!');

        int[] f = new int[n];
        int iMax = 0, rMax = 0, ans = 0;
        for (int i = 1; i < n; ++i) {
            // 初始化 f[i]
            f[i] = i <= rMax ? Math.min(rMax - i + 1, f[2 * iMax - i]) : 1;
            // 中心拓展
            while (t.charAt(i + f[i]) == t.charAt(i - f[i])) {
                ++f[i];
            }
            // 动态维护 iMax 和 rMax
            if (i + f[i] - 1 > rMax) {
                iMax = i;
                rMax = i + f[i] - 1;
            }
            // 统计答案, 当前贡献为 (f[i] - 1) / 2 上取整
            ans += f[i] / 2;
        }

        return ans;
    }
}